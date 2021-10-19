package ao.grandela.smartstock.api.models.inputs

import ao.grandela.smartstock.domain.models.Customer
import javax.validation.constraints.*

class CustomerInput(@field:NotBlank val name: String = "") {
        fun toDomain() = Customer(name = name)
}
