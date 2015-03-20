package services;

import dao.MonitorDAO;
import dao.TablaDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import pojos.Lineasejercicio;
import pojos.Tabla;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("tablas")
public class TablasResource {

    private MonitorDAO monitordao;
    private TablaDAO tabladao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public TablasResource() {
        monitordao = new MonitorDAO();
        tabladao = new TablaDAO();
    }

    /**
     *
     * @return
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablas() {
        return tabladao.obtenListado();
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/alumno/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablasAlumnos(@PathParam("id") int id) {
        return tabladao.obtenListado(id);
    }

    /**
     *
     * @param token
     * @param id Indentificador del monitor
     * @return Lista de tablas asociadas al monitor
     */
    @GET
    @Path("/monitor/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablasMonitores(@HeaderParam("token") String token, @PathParam("id") int id) {
        //Si el monitor tiene derechos de administrador, muestra la lista
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).isAdministrador() == 1) {
            return tabladao.obtenListadoPorMonitor(id);
        } else {
            return null;
        }
    }

    @GET
    @Path("/ejercicio/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Tabla> getListaTablasPorEjercicio(@PathParam("id") int id)
    {
        return tabladao.obtenListadoPorEjercicio(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}/lineas")
    @Produces({"application/xml", "application/json"})
    public List<Lineasejercicio> getListaTablas(@PathParam("id") int id) {
        return tabladao.obtenListaEjercicios(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Tabla getTabla(@PathParam("id") int id) {
        return tabladao.obtenItem(id);
    }

    /**
     *
     * @param tabla
     * @return
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Tabla annadirTabla(Tabla tabla) {
        return tabladao.guardar(tabla);
    }

    /**
     *
     * @param linea
     * @return
     */
    @POST
    @Path("/lineas")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Lineasejercicio annadirLinea(Lineasejercicio linea) {
        return tabladao.guardar(linea);
    }

    /**
     *
     * @param tabla
     * @return
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Tabla modificarTabla(Tabla tabla) {
        return tabladao.actualizar(tabla);
    }

    /**
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarTabla(@PathParam("id") int id) {
        tabladao.borrar(id);
        return "Se ha borrado la tabla " + id;
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarTablas() {
        return "Hay " + String.valueOf(tabladao.total()) + " tablas registradas";
    }
}
