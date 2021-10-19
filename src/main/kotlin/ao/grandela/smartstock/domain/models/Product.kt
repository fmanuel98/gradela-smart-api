package ao.grandela.smartstock.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
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
        var quantity: Long = 0,
        val expirationAt: LocalDate? = null,
        val code: String = "",
        val codebarra: String = "",
        val image: String = "",
        val ivaTax: BigDecimal = BigDecimal.ZERO,
        val discount: BigDecimal = BigDecimal.ZERO,
        val othorTax: BigDecimal = BigDecimal.ZERO,
        val stock: Long = 0,
        @ManyToOne(optional = false) val category: Category,
        @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
        @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null,
) {
    constructor(id: Long, categoryId: Long) : this(id = id, category = Category(categoryId))
    constructor(id: Long) : this(id, 0)
    constructor() : this(0)
}

@ApplicationScoped class ProductRepository : PanacheRepository<Product> {}
