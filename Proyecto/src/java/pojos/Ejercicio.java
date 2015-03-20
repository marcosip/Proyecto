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
 * Define los detalles de un ejercicio que es incluido por una linea de
 * ejercicio dentro de una tabla
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ejercicio")
@XmlType(propOrder = {"nombre"})
public class Ejercicio implements java.io.Serializable {

    @XmlAttribute
    private Integer id;
    @XmlElement
    private String nombre;
    /**
     * Enlace a las tablas en las cuales se ha incluido el ejercicio
     * seleccionado
     */
    @Transient
    private LinkBean link;

    /**
     *
     */
    public Ejercicio() {
    }

    /**
     *
     * @param id
     * @param nombre
     */
    public Ejercicio(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
     * @return Enlace al listado de tablas que utilizan el ejercicio
     * seleccionado
     */
    public LinkBean getLink() {
        this.link = new LinkBean("self", "http://localhost:8080/Proyecto/webservice/ejercicios/" + this.getId() + "/tablas");
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
        return "Ejercicio:" + nombre;
    }

}
