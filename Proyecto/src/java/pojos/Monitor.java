package pojos;
// Generated 27-feb-2015 11:03:57 by Hibernate Tools 4.3.1

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Especifica la información básica asociada a un monitor. Cada tabla que se
 * crea para un alumno, deberá tener asociado un monitor.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "monitor")
@XmlType(propOrder = {"nombre", "apellidos", "administrador", "link"})
public class Monitor implements java.io.Serializable {

    @XmlAttribute
    private Integer id;
    @XmlElement
    private String nombre;
    @XmlElement
    private String apellidos;
    /**
     * Especifica el nivel de permisos que tiene el monitor
     * <br/>
     * <ul>
     * <li>0 - Todos los permisos</li>
     * <li>1 - Sin permisos</li>
     * </ul>
     */
    @XmlElement
    private Integer administrador;
    /**
     * Enlace al listado de alumnos asociados al monitor seleccionado
     */
    @Transient
    private LinkBean link;

    /**
     *
     */
    public Monitor() {
    }

    /**
     *
     * @param id
     */
    public Monitor(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param nombre
     */
    public Monitor(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param nombre
     * @param apellidos
     */
    public Monitor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     *
     * @param nombre
     * @param apellidos
     * @param administrador
     */
    public Monitor(String nombre, String apellidos, Integer administrador) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.administrador = administrador;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return
     */
    public Integer isAdministrador() {
        return this.administrador;
    }

    /**
     *
     * @param administrador
     */
    public void setAdministrador(Integer administrador) {
        this.administrador = administrador;
    }

    /**
     *
     * @return Enlace al listado de alumnos asociados al monitor
     */
    @XmlElement
    public LinkBean getLink() {
        this.link = new LinkBean("self", "http://localhost:8080/Proyecto/webservice/monitores/" + this.getId() + "/alumnos");
        return link;
    }

    /**
     *
     * @param link
     */
    public void setLink(LinkBean link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Monitor{" + "nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
