package ao.grandela.smartstock.api.models.inputs

import ao.grandela.smartstock.domain.models.Item
import ao.grandela.smartstock.domain.models.Product
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class InvoiceInput(
    @field:NotNull val customerId: Long,
    @field:NotNull @field:NotEmpty val items: List<ItemInput>
)

class ItemInput(
    @field:NotNull val productId: Long,
    @field:NotNull @field:Positive val quantity: Long
) {
  fun toDomain(product: Product) = Item(product = product, quantity = this.quantity)
}
