package ao.grandela.smartstock.api.models

import java.math.BigDecimal
import java.time.LocalDate

class InvoiceModel(
        val id: Long?,
        val itens: List<ItemModel>?,
        val customer: CustomerModel,
        val total: BigDecimal?,
        val createdAt: LocalDate? = null,
        val updatedAt: LocalDate? = null
)
