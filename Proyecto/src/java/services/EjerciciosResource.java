package services;

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

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EjerciciosResource
     */
    public EjerciciosResource() {
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public void getListaEjercicios() {
        //return lista alumnos
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Ejercicio getEjercicio(@PathParam("id") int id) {
        return new Ejercicio();
    }

    @GET
    @Path("/count")
    @Produces({"application/xml", "application/json"})
    public String contarEjercicios() {
        return "";
    }
}
