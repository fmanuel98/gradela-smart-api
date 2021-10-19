package ao.grandela.smartstock.api.models

import ao.grandela.smartstock.domain.models.Customer
import java.time.LocalDate

class CustomerModel(
        val id: Long?,
        val name: String?,
        val createdAt: LocalDate?,
        val updatedAt: LocalDate?
) {
    constructor(model: Customer?) : this(model?.id, model?.name, model?.createdAt, model?.updatedAt)
}
