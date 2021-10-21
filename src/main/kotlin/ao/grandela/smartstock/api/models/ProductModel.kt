package ao.grandela.smartstock.api.models

import ao.grandela.smartstock.domain.models.Product
import java.math.BigDecimal
import java.time.LocalDate

class ProductModel(
    val id: Long?,
    val price: BigDecimal?,
    val name: String?,
    val quantity: Long?,
    val expirationAt: LocalDate?,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?,
    val code: String?,
    val codebarra: String?,
    val image: String?,
    val ivaTax: BigDecimal?,
    val discount: BigDecimal?,
    val othorTax: BigDecimal?,
    val stock: Long?,
    val category: CategoryModel?
) {

  constructor(
      model: Product?
  ) : this(
      model?.id,
      model?.price,
      model?.name,
      model?.quantity,
      model?.expirationAt,
      model?.createdAt,
      model?.updatedAt,
      model?.code,
      model?.codebarra,
      model?.image,
      model?.ivaTax,
      model?.discount,
      model?.othorTax,
      model?.stock,
      CategoryModel(model?.category)
  )
}
