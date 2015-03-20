package services;

import dao.AlumnoDAO;
import dao.MonitorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
    private MonitorDAO monitordao;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlumnosResource
     */
    public AlumnosResource() {
        alumnodao = new AlumnoDAO();

    }

    /**
     *
     * @return Devuelve la lista con todos los alumnos registrados en el sistema
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Alumno> getListaAlumnos() {
        return alumnodao.obtenListado();
    }

    /**
     * Genera la información asociada a un alumno
     *
     * @param id Identificador del alumno
     * @return Devuelve el alumno correspondiente al identificador asociado
     */
    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Alumno getAlumno(@PathParam("id") int id) {
        try {
            //genera el XML por consola
            alumnodao = new AlumnoDAO();
            JAXBContext jc = JAXBContext.newInstance(Alumno.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(alumnodao.obtenItem(id), System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(AlumnosResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alumnodao.obtenItem(id);
    }

    /**
     * Añade un alumno nuevo al sistema
     *
     * @param alumno Alumno a registrar en el sistema
     * @return Devuelve el alumno registrado en el sistema
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Alumno annadirAlumno(Alumno alumno) {
        return alumnodao.guardar(alumno);
    }

    /**
     * Actualiza/modifica la información de un alumno existente en el sistema
     *
     * @param alumno Alumno a modificar
     * @return Devuelve el alumno ya modificado
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Alumno modificarAlumno(Alumno alumno) {
        return alumnodao.actualizar(alumno);
    }

    /**
     * Elimina el alumno especificado del sistema
     *
     * @param token
     * @param id Identificador del alumno a borrar
     * @return Mensaje de confirmación
     */
    @DELETE
    @Path("/{id}")
    @Produces("text/plain" + ";charset=utf-8")
    public String borrarAlumno(@HeaderParam("token") String token, @PathParam("id") int id) {
        //Si el monitor tiene derechos de administrador, muestra la lista
        if (monitordao.obtenItem(token) != null && monitordao.obtenItem(token).isAdministrador() == 1) {
            alumnodao.borrar(id);
            return "Se ha borrado el alumno " + id;
        } else {
            return "No se ha podido borrar el alumno debido a que no tiene permisos o no se ha encontrado en el sistema";
        }
    }

    /**
     *
     * @return Nº total de alumnos registrados en el sistema
     */
    @GET
    @Path("/count")
    @Produces({"text/plain" + ";charset=utf-8"})
    public String contarAlumnos() {
        return "Hay " + String.valueOf(alumnodao.total() + " alumnos registrados");
    }
}
