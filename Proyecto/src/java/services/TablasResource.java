package services;

import dao.TablaDAO;
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
import pojos.Lineasejercicio;
import pojos.Tabla;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("tablas")
public class TablasResource {

    private TablaDAO tabladao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public TablasResource() {
        tabladao = new TablaDAO();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablas() {
        return tabladao.obtenListado();
    }

    @GET
    @Path("/alumno/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablasAlumnos(@PathParam("id") int id) {
        return tabladao.obtenListado(id);
    }

    @GET
    @Path("/{id}/lineas")
    @Produces({"application/xml", "application/json"})
    public List<Lineasejercicio> getListaEjercicios(@PathParam("id") int id) {
        return tabladao.obtenListaEjercicios(id);
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Tabla getTabla(@PathParam("id") int id) {
        return tabladao.obtenItem(id);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Tabla annadirTabla(Tabla tabla) {
        return tabladao.guardar(tabla);
    }
    
    @POST
    @Path("/lineas")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Lineasejercicio annadirLinea(Lineasejercicio linea) {
        return tabladao.guardar(linea);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Tabla modificarTabla(Tabla tabla) {
        return tabladao.actualizar(tabla);
    }

    @DELETE
    @Path("/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarTabla(@PathParam("id") int id) {
        tabladao.borrar(id);
        return "Se ha borrado la tabla " + id;
    }

    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarMonitores() {
        return String.valueOf(tabladao.total());
    }
}
