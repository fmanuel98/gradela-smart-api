package ao.grandela.smartstock.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase
import java.math.BigDecimal
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false) val price: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val name: String = "",
    val quantity: Long = 0,
    val expirationAt: LocalDate? = null,
    @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
    @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null
) {}

@ApplicationScoped class ProductRepository : PanacheRepositoryBase<Product, Long>
