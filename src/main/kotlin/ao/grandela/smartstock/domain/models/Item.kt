package ao.grandela.smartstock.domain.models

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "item")
data class Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @ManyToOne(optional = false, cascade = [CascadeType.MERGE]) var product: Product? = null,
    @ManyToOne(optional = false) var invoice: Invoice? = null,
    var productPrice: BigDecimal? = BigDecimal.ZERO,
    var productName: String? = "",
    val quantity: Long = 0,
    var subTotal: BigDecimal? = BigDecimal.ZERO,
    @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
    @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null
) {
  constructor() : this(0, null)
  @PostLoad
  @PrePersist
  @PreUpdate
  fun calcularSubTotal(): Unit {
    this.productPrice = this.product?.price
    this.productName = this.product?.name
    this.subTotal = productPrice?.multiply(BigDecimal(quantity))
  }

  fun total(): BigDecimal {
    calcularSubTotal()
    return subTotal ?: BigDecimal.ZERO
  }
}
