package services;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.BBDD;
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

    private BBDD bd;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public AlumnosResource() {
        bd = new BBDD();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public void getListaAlumnos() {

    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Alumno getAlumno(@PathParam("id") int id) {
        Alumno a = null;
        try {
            bd.ejecutarConsulta("SELECT * FROM alumnos WHERE id = " + id);
            bd.getResultado();
            while (bd.getResultado().next()) {
                a = new Alumno(bd.getResultado().getString("Nombre"),
                        bd.getResultado().getString("Apellidos"),
                        bd.getResultado().getDate("FechaAlta"),
                        bd.getResultado().getDate("FechaNacimiento"),
                        bd.getResultado().getString("CuadroClinico"));
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Alumno annadirAlumno() {
        return new Alumno();
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public String modificarAlumno(@PathParam("alumno") String content) {
        return "Ha añadido al alumno " + content;
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarAlumno(@PathParam("id") int id) {
        return "Se ha borrado el alumno " + id;
    }

    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarAlumnos() {
        int total = 0;
        try {
            bd.ejecutarConsulta("SELECT COUNT(*) AS total FROM alumnos");
            bd.getResultado();
            while (bd.getResultado().next()) {
                total=bd.getResultado().getInt("total");
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(AlumnosResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(total);
    }
}
