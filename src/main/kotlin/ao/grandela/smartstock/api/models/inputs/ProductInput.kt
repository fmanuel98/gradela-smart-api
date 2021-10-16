package ao.grandela.smartstock.api.models.inputs

import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

class ProductInput(
    @field:Positive val price: BigDecimal,
    @field:NotBlank val name: String = "",
    @field:PositiveOrZero val quantity: Long,
    val expirationAt: LocalDate? = null
)
