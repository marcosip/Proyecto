package services;

import dao.EjercicioDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import pojos.Ejercicio;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("ejercicios")
public class EjerciciosResource {

    private EjercicioDAO ejerciciodao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public EjerciciosResource() {
        ejerciciodao = new EjercicioDAO();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Ejercicio> getListaAlumnos() {
        return ejerciciodao.obtenListado();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Ejercicio getEjercicio(@PathParam("id") int id) {
        return ejerciciodao.obtenItem(id);
    }

    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarAlumnos() {
        return String.valueOf(ejerciciodao.total());
    }
}
