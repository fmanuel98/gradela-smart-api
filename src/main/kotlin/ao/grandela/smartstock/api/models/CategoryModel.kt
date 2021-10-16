package ao.grandela.smartstock.api.models

import ao.grandela.smartstock.domain.models.Category
import java.time.LocalDate

class CategoryModel(
        val id: Long,
        val name: String,
        val createdAt: LocalDate?,
        val updatedAt: LocalDate?
) {
    constructor(model: Category) : this(model.id, model.name, model.createdAt, model.updatedAt)
}
