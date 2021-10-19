package ao.grandela.smartstock.api.controllers

import ao.grandela.smartstock.api.models.CategoryModel
import ao.grandela.smartstock.api.models.inputs.CategoryInput
import ao.grandela.smartstock.domain.models.CategoryRepository
import javax.transaction.Transactional
import javax.validation.Valid
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import org.eclipse.microprofile.openapi.annotations.tags.Tag

@Path("categories")
@Tag(name = "Categorias")
class CategoryController(val repository: CategoryRepository) {
  @GET fun listar() = repository.listAll().map { CategoryModel(it) }

  @POST
  @Transactional
  fun salvar(@Valid input: CategoryInput): CategoryModel {
    val category = input.toDomain()
    repository.persist(category)
    return CategoryModel(category)
  }
  @POST
  @Path("{categoriaId}")
  @Transactional
  fun atualizar(
      @Valid input: CategoryInput,
      @PathParam("categoriaId") categoriaId: Long
  ): CategoryModel {
    val c = repository.findById(categoriaId)
    c?.name = input.name
    // repository.update("name", input.name)
    return CategoryModel(c)
  }
}
