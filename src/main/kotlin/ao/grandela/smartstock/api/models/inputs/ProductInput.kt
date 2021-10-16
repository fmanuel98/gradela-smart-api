package ao.grandela.smartstock.api.models.inputs

import ao.grandela.smartstock.domain.models.Category
import ao.grandela.smartstock.domain.models.Product
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.*

class ProductInput(
                @field:Positive val price: BigDecimal,
                @field:NotBlank val name: String,
                @field:PositiveOrZero val quantity: Long,
                val expirationAt: LocalDate? = null,
                val code: String,
                val codebarra: String,
                val image: String = "",
                val ivaTax: BigDecimal,
                val discount: BigDecimal,
                val othorTax: BigDecimal,
                @field:Positive val stock: Long,
                @field:NotNull val categoryId: Long
) {
        fun toDomain() =
                        Product(
                                        name = name,
                                        price = price,
                                        expirationAt = expirationAt,
                                        code = code,
                                        stock = stock,
                                        othorTax = othorTax,
                                        discount = discount,
                                        image = image,
                                        ivaTax = ivaTax,
                                        category = Category(id = categoryId)
                        )
}
