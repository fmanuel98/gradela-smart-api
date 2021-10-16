package ao.grandela.smartstock.api.models

import ao.grandela.smartstock.domain.models.Product
import java.math.BigDecimal
import java.time.LocalDate

class ProductModel(
    val id: Long,
    val price: BigDecimal,
    val name: String,
    val quantity: Long = 0,
    val expirationAt: LocalDate?,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?
) {

  constructor(
      model: Product
  ) : this(
      model.id,
      model.price,
      model.name,
      model.quantity,
      model.expirationAt,
      model.createdAt,
      model.updatedAt
  )
}
