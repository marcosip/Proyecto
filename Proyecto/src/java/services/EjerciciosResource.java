package services;

import dao.EjercicioDAO;
import dao.TablaDAO;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import pojos.Ejercicio;

/**
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("ejercicios")
public class EjerciciosResource {

    private EjercicioDAO ejerciciodao;
    private TablaDAO tabladao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public EjerciciosResource() {
        ejerciciodao = new EjercicioDAO();
    }

    /**
     * Genera un listado de todos los ejercicios
     *
     * @return
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Ejercicio> getListaEjercicios() {
        return ejerciciodao.obtenListado();
    }

    /**
     * Genera la información asociada a un ejercicio
     *
     * @param id Identificador del ejercicio
     * @return Ejercicio seleccionado
     */
    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Ejercicio getEjercicio(@PathParam("id") int id) {
        return ejerciciodao.obtenItem(id);
    }

    /**
     * @return Nº total de ejercicios registrados en el sistema
     */
    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarEjercicios() {
        return "Hay " + String.valueOf(ejerciciodao.total()) + " ejercicios registrados";
    }
}
