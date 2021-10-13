package ao.grandela.smartstock.domain.models

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "invoice")
data class Invoice(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
        @OneToMany(mappedBy = "invoice", cascade = [CascadeType.MERGE, CascadeType.PERSIST])
        val items: List<Item>,
        var total: BigDecimal = BigDecimal.ZERO
) {
    @PreUpdate
    @PrePersist
    fun calcularTotal(): Unit {
        total =
                items
                        .map { it.total() }
                        .reduce { accumulator, subTotal -> accumulator.add(subTotal) }
                        .also { print("Total fatura $it") }
    }
}
