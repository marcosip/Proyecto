package services;

import dao.AlumnoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import pojos.Alumno;

/**
 *
 * REST Web Service
 *
 * @author usuario0305
 */
@Path("alumnos")
public class AlumnosResource {

    private AlumnoDAO alumnodao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public AlumnosResource() {
        alumnodao=new AlumnoDAO();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Alumno> getListaAlumnos() {
        return alumnodao.obtenListado();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Alumno getAlumno(@PathParam("id") int id) {
        return alumnodao.obtenItem(id);
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Alumno annadirAlumno(Alumno alumno) {
        return alumnodao.guardar(alumno);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public String modificarAlumno(@PathParam("content") String content) {
        return "Ha añadido al alumno " + content;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarAlumno(@PathParam("id") int id) {
        alumnodao.borrar(id);
        return "Se ha borrado el alumno " + id;
    }

    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarAlumnos() {
        return String.valueOf(alumnodao.total());
    }
}
