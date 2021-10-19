package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.CustomerModel
import ao.grandela.smartstock.api.models.inputs.CustomerInput
import ao.grandela.smartstock.domain.models.CustomerRepository
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("customers")
@Tag(name = "Clientes")
class CunstomerController(val repository: CustomerRepository) {
        @GET fun listar() = repository.listAll().map { CustomerModel(it) }

        @POST
        fun salvar(@Valid input: CustomerInput) =
                        input.toDomain().run { repository.salvar(this) }.let { CustomerModel(it) }

        @PUT
        @Transactional
        @Path("{customerId}")
        fun atualizar(@Valid input: CustomerInput, @PathParam("customerId") customerId: Long) =
                        repository.findById(customerId)?.let {
                                it.name = input.name
                                CustomerModel(it)
                        }
}
