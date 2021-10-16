package ao.grandela.smartstock.api.models.inputs

import ao.grandela.smartstock.domain.models.Category
import javax.validation.constraints.*

class CategoryInput(@field:NotBlank val name: String = "") {
        fun toDomain() = Category(name = name)
}
