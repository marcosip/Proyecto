package services;

import dao.AlumnoDAO;
import dao.MonitorDAO;
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

    /**
     * Genera un listado de todos los monitores
     *
     * @param token Cadena de validación para realizar la petición
     * @return Devuelve la lista de monitores si el token es válido o NULL si no
     * es válido
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Monitor> getListaMonitores(@HeaderParam("token") String token) {
        //Si el monitor tiene derechos de administrador, muestra la lista
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).isAdministrador() == 1) {
            return monitordao.obtenListado();
        } else {
            return null;
        }
    }

    /**
     * Genera la información asociada a un monitor
     *
     * @param token
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Monitor getMonitor(@HeaderParam("token") String token, @PathParam("id") int id) {
        //Solo muestra la ficha del monitor al que corresponda, no el de otro
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).getId() == id) {
            return monitordao.obtenItem(id);
        } else {
            return null;
        }
    }

    /**
     *
     * @param token
     * @param id
     * @return
     */
    @GET
    @Path("/{id}/alumnos")
    @Produces({"application/xml", "application/json"})
    public List<Alumno> getListaMonitores(@HeaderParam("token") String token, @PathParam("id") int id) {
        //Solo muestra el listado de alumnos para el monitor seleccionado si coincide
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).getId() == id) {
            return alumnodao.obtenListado(id);
        } else {
            return null;
        }
    }

    /**
     *
     * @param monitor
     * @return
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Monitor annadirMonitor(Monitor monitor) {
        return monitordao.guardar(monitor);
    }

    /**
     *
     * @param monitor Monitor a actualizar
     * @return Monitor actualizado
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Monitor modificarMonitor(Monitor monitor) {
        return monitordao.actualizar(monitor);
    }

    /**
     *
     * @param token
     * @param id Identificador del monitor a borrar
     * @return Mensaje de confirmación
     */
    @DELETE
    @Path("/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarMonitor(@HeaderParam("token") String token, @PathParam("id") int id) {
        //Si el monitor tiene derechos de administrador, muestra la lista
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).isAdministrador() == 1) {
            monitordao.borrar(id);
            return "Se ha borrado el monitor " + id;
        } else {
            return "No se ha podido borrar el monitor debido a que no tiene permisos o no se ha encontrado en el sistema";
        }
    }

    /**
     *
     * @return
     */
    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarMonitores() {
        return "Hay " + String.valueOf(monitordao.total()) + " monitores registrados";
    }
}
