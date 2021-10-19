package ao.grandela.smartstock.domain.services

import ao.grandela.smartstock.domain.models.Product
import ao.grandela.smartstock.domain.models.ProductRepository
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.WebApplicationException

@ApplicationScoped
class ProductService(val repository: ProductRepository) {
  fun findOrFail(id: Long): Product {
    val product = repository.findById(id)
    if (product == null) {
      throw WebApplicationException("Product with id of " + id + " does not exist.", 404)
    }
    return product
  }
}
