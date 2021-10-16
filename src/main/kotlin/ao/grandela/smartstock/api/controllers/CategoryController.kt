package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.CategoryModel
import ao.grandela.smartstock.api.models.inputs.CategoryInput
import ao.grandela.smartstock.domain.models.CategoryRepository
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("categories")
class CategoryController(val repository: CategoryRepository) {
  @GET fun listar() = repository.listAll().map { CategoryModel(it) }

  @POST
  @Transactional
  fun salvar(@Valid input: CategoryInput): CategoryModel {
    val category = input.toDomain()
    repository.persist(category)
    return CategoryModel(category)
  }
}
