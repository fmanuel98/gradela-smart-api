package ao.grandela.smartstock.domain.services

import ao.grandela.smartstock.domain.models.Customer
import ao.grandela.smartstock.domain.models.CustomerRepository
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.WebApplicationException

@ApplicationScoped
class CustomerService(val repository: CustomerRepository) {
  fun findOrFail(id: Long): Customer {
    val customer = repository.findById(id)
    if (customer == null) {
      throw WebApplicationException("Customer with id of " + id + " does not exist.", 404)
    }
    return customer
  }
}
