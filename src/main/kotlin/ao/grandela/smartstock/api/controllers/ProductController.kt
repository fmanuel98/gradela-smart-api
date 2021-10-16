package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.ProductModel
import ao.grandela.smartstock.api.models.inputs.ProductInput
import ao.grandela.smartstock.domain.models.ProductRepository
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("products")
class ProductController(val repository: ProductRepository) {
  @GET fun listar() = repository.listAll().map { ProductModel(it) }

  @POST
  @Transactional
  fun salvar(@Valid input: ProductInput): ProductModel {
    val product = input.toDomain()
    repository.persist(product)
    return ProductModel(product)
  }
}
