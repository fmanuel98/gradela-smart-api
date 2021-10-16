package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.inputs.ProductInput
import ao.grandela.smartstock.domain.models.Product
import ao.grandela.smartstock.domain.models.ProductRepository
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("products")
class ProductController(val repository: ProductRepository) {
  @GET fun listar() = repository.listAll()

  @POST
  @Transactional
  fun salvar(@Valid input: ProductInput): Product {
    val product = Product(name = input.name, price = input.price, expirationAt = input.expirationAt)
    repository.persist(product)
    return product
  }
}
