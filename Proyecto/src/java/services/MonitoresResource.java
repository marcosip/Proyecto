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
import pojos.Monitor;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("monitores")
public class MonitoresResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MonitoresResource
     */
    public MonitoresResource() {
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public void getListaMonitors() {
        //return lista alumnos
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Monitor getMonitor(@PathParam("id") int id) {
        return new Monitor();
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Monitor annadirMonitor() {
        return new Monitor();
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public String modificarMonitor(@PathParam("alumno") String content) {
        return "Ha añadido al alumno " + content;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarMonitor(@PathParam("id") int id) {
        return "Se ha borrado el alumno " + id;
    }

    @GET
    @Path("/count")
    @Produces({"application/xml", "application/json"})
    public String contarMonitors() {
        return "";
    }
}
