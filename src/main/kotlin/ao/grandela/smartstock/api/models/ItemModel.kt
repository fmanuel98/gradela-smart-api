package ao.grandela.smartstock.api.models

import ao.grandela.smartstock.domain.models.Item
import java.math.BigDecimal
import java.time.LocalDate

class ItemModel(
                val id: Long?,
                val productPrice: BigDecimal?,
                val productName: String?,
                val quantity: Long?,
                val subTotal: BigDecimal?,
                val createdAt: LocalDate? = null,
                val updatedAt: LocalDate? = null,
) {
        constructor(
                        model: Item?
        ) : this(
                        model?.id,
                        model?.productPrice,
                        model?.productName,
                        model?.quantity,
                        model?.subTotal,
                        model?.createdAt,
                        model?.updatedAt
        )
}
