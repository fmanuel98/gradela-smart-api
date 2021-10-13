package ao.grandela.smartstock.domain.models

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "item")
data class Item(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @ManyToOne(optional = false, cascade = [CascadeType.MERGE]) val product: Product,
    @ManyToOne(optional = false) val invoice: Invoice,
    val productPrice: BigDecimal,
    val producme: BigDecimal,
    val quantity: Long = 0,
    var subTotal: BigDecimal
) {
  @PostLoad
  @PrePersist
  @PreUpdate
  fun calcularSubTotal(): Unit {
    this.subTotal = productPrice.multiply(BigDecimal(quantity))
  }

  fun total(): BigDecimal {
    calcularSubTotal()
    return subTotal
  }
}
