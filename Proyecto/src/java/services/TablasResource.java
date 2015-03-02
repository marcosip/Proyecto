package services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import pojos.Tabla;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("tablas")
public class TablasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TablasResource
     */
    public TablasResource() {
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public void getListaTablas() {
        //return lista alumnos
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Tabla getTabla(@PathParam("id") int id) {
        return new Tabla();
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Tabla annadirTabla() {
        return new Tabla();
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public String modificarTabla(@PathParam("alumno") String content) {
        return "Ha añadido al alumno " + content;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarTabla(@PathParam("id") int id) {
        return "Se ha borrado el alumno " + id;
    }

    @GET
    @Path("/count")
    @Produces({"application/xml", "application/json"})
    public String contarTablas() {
        return "";
    }
}
