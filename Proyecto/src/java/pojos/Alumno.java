package pojos;
// Generated 27-feb-2015 11:03:57 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Contiene la información asociada a un alumno
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "alumno")
@XmlType(propOrder = {"nombre", "apellidos", "fechaAlta", "fechaNacimiento", "cuadroClinico", "link"})
public class Alumno implements Serializable {

    @XmlAttribute
    private Integer id;
    @XmlElement
    private String nombre;
    @XmlElement
    private String apellidos;
    @XmlElement
    private Date fechaAlta;
    @XmlElement
    private Date fechaNacimiento;
    @XmlElement
    private String cuadroClinico;
    /**
     * Enlace a las tablas del alumno
     */
    @Transient
    private LinkBean link;

    /**
     *
     */
    public Alumno() {
    }

    /**
     *
     * @param id
     */
    public Alumno(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param nombre
     */
    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param nombre
     * @param apellidos
     */
    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     *
     * @param nombre
     * @param apellidos
     * @param fechaAlta
     * @param fechaNacimiento
     * @param cuadroClinico
     */
    public Alumno(String nombre, String apellidos, Date fechaAlta, Date fechaNacimiento, String cuadroClinico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
        this.fechaNacimiento = fechaNacimiento;
        this.cuadroClinico = cuadroClinico;
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
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     *
     * @param fechaAlta
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     *
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public String getCuadroClinico() {
        return this.cuadroClinico;
    }

    /**
     *
     * @param cuadroClinico
     */
    public void setCuadroClinico(String cuadroClinico) {
        this.cuadroClinico = cuadroClinico;
    }

    /**
     *
     * @return Enlace al listado de tablas asociadas al alumno
     */
    @XmlElement
    public LinkBean getLink() {
        this.link = new LinkBean("self", "http://localhost:8080/Proyecto/webservice/tablas/alumno/" + this.getId());
        return this.link;
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
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

}
