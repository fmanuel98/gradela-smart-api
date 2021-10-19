package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.inputs.InvoiceInput
import ao.grandela.smartstock.domain.models.Invoice
import ao.grandela.smartstock.domain.models.InvoiceRepository
import ao.grandela.smartstock.domain.services.CustomerService
import ao.grandela.smartstock.domain.services.ProductService
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("invoices")
@Tag(name = "Facturas")
class InvoiceController(
    val repository: InvoiceRepository,
    val productService: ProductService,
    val customerService: CustomerService
) {
  @GET fun listar() = repository.listAll().map { it }

  @POST
  @Transactional
  fun salvar(@Valid input: InvoiceInput): Invoice {
    val itens =
        input.items.map {
          val product = productService.findOrFail(it.productId)
          it.toDomain(product)
        }
    customerService.findOrFail(input.customerId)
    val invoice = Invoice(input.customerId, itens)
    repository.salvar(invoice)
    return invoice
  }
}
