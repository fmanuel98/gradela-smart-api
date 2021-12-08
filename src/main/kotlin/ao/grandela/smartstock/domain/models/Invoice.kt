package ao.grandela.smartstock.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.math.BigDecimal
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "invoice")
data class Invoice(
                @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
                @OneToMany(mappedBy = "invoice", cascade = [CascadeType.MERGE, CascadeType.PERSIST])
                var itens: List<Item>? = null,
                @ManyToOne(optional = false) val customer: Customer,
                var total: BigDecimal? = BigDecimal.ZERO,
                val InvoiceType: String = "",
                @Column(updatable = false) @CreationTimestamp val createdAt: LocalDate? = null,
                @Column(nullable = false) @UpdateTimestamp val updatedAt: LocalDate? = null
) {
        constructor(
                        custumerId: Long,
                        itens: List<Item>?
        ) : this(customer = Customer(custumerId), itens = itens)
        constructor() : this(0, null)
        @PreUpdate
        @PrePersist
        fun calcularTotal() {
                this.total =
                                itens?.map { it.total() }?.reduce { accumulator, subTotal ->
                                        accumulator.add(subTotal)
                                }
        }
}

@ApplicationScoped
class InvoiceRepository : PanacheRepository<Invoice> {

        fun salvar(invoice: Invoice): Invoice {
                val invoiceProcess = invoice
                invoiceProcess.itens?.forEach {
                        it.invoice = invoiceProcess
                        it.product = checkStock(it)
                }
                persist(invoiceProcess)
                return invoiceProcess
        }

        private fun checkStock(item: Item): Product? {
                val product = item.product
                val quantidadeDisponivel = product?.quantity ?: 0
                val quantidadeDesejada = item.quantity
                val quantidadeRestante = quantidadeDisponivel - quantidadeDesejada
                if (quantidadeRestante < 0) {}
                product?.quantity = quantidadeRestante
                return product
        }
}
