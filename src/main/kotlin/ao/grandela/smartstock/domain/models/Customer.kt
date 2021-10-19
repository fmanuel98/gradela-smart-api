package ao.grandela.smartstock.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import javax.transaction.Transactional
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "custumer")
data class Customer(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,
    var name: String = "",
    @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
    @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null,
) {
  constructor(id: Long) : this(id, "")
}

@ApplicationScoped
class CustomerRepository : PanacheRepository<Customer> {
  @Transactional
  fun salvar(customer: Customer): Customer {

    // if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
    //	throw new NegocioException(
    //		String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
    // }

    persist(customer)
    return customer
  }
}
