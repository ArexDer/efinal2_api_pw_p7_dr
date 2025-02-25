package efinal2_api_pw_p7_dr.controller;

import java.util.List;

import efinal2_api_pw_p7_dr.service.IProductoService;
import efinal2_api_pw_p7_dr.service.to.ProductoTo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/productos")
public class ProductoController {

    @Inject
    private IProductoService iproductoService;

    //GUARDAR
    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(ProductoTo productoTo) {
        this.iproductoService.guardar(productoTo);
        return Response.ok(productoTo).build();
    }

    //LISTAR PRODUCTOS
    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoTo> listarProductos() {
        return this.iproductoService.listarProductos();
    }

    //buscar POR NOMBRE
    @GET
    @Path("/buscarPorNombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoTo buscarPorNombre(@PathParam("nombre") String nombre) {
        return this.iproductoService.buscarPorNombre(nombre);
    }
    
}
