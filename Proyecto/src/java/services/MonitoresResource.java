package services;

import dao.AlumnoDAO;
import dao.MonitorDAO;
import java.util.List;
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
import pojos.Alumno;
import pojos.Monitor;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("monitores")
public class MonitoresResource {

    private AlumnoDAO alumnodao;
    private MonitorDAO monitordao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public MonitoresResource() {
        alumnodao = new AlumnoDAO();
        monitordao = new MonitorDAO();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Monitor> getListaMonitores() {
        return monitordao.obtenListado();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Monitor getMonitor(@PathParam("id") int id) {
        return monitordao.obtenItem(id);
    }
    
    @GET
    @Path("/{id}/alumnos")
    @Produces({"application/xml", "application/json"})
    public List<Alumno> getListaAlumnos(@PathParam("id") int id)
    {
        return alumnodao.obtenListado(id);
    }
    
    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Monitor annadirMonitor(Monitor monitor) {
        return monitordao.guardar(monitor);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Monitor modificarMonitor(Monitor monitor) {
        return monitordao.actualizar(monitor);
    }

    @DELETE
    @Path("/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarMonitor(@PathParam("id") int id) {
        monitordao.borrar(id);
        return "Se ha borrado el monitor " + id;
    }

    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarMonitores() {
        return String.valueOf(monitordao.total());
    }
}
