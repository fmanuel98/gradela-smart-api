package ao.grandela.smartstock.api.controllers

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("products")
class ProductController {
  @GET fun listar() = "Quarkus"
}
