package efinal2_api_pw_p7_dr.controller;

import javax.print.attribute.standard.Media;

import efinal2_api_pw_p7_dr.service.IVentaService;
import efinal2_api_pw_p7_dr.service.to.VentaTo;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ventas")
public class VentaController {

    @Inject
    private IVentaService iVentaService;

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ingresar( VentaTo ventaTo) {
        this.iVentaService.ingresar(ventaTo);
        return Response.ok(ventaTo).build();
       
    }

    @GET 
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar() {
        return Response.ok().entity(this.iVentaService.listar()).build();
   
    }
    
}
