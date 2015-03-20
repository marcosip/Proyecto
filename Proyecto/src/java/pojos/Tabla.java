package pojos;
// Generated 27-feb-2015 11:03:57 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Esta entidad contiene la información básica asociada a una tabla. La relación
 * de ejercicios asociados a dicha tabla se realiza a través de la entidad
 * lineaejercicio
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "tabla")
@XmlType(propOrder = {"alumno", "monitor", "fechaCreacion", "fechaInicio", "fechaCambio", "peso", "estatura", "objetivos", "link"})
public class Tabla implements java.io.Serializable {

    @XmlAttribute
    private Integer id;
    @XmlElement
    private Alumno alumno;
    @XmlElement
    private Monitor monitor;
    @XmlElement
    private Date fechaCreacion;
    @XmlElement
    private Date fechaInicio;
    @XmlElement
    private Date fechaCambio;
    @XmlElement
    private BigDecimal peso;
    @XmlElement
    private Integer estatura;
    @XmlElement
    private String objetivos;
    /**
     * Enlace al listado de lineas de ejercicios asociados a la tabla actual
     */
    @Transient
    private LinkBean link;

    /**
     *
     */
    public Tabla() {
    }

    /**
     *
     * @param id
     * @param fechaCreacion
     * @param fechainicio
     * @param fechaCambio
     * @param peso
     * @param estatura
     * @param objetivos
     */
    public Tabla(Integer id, Date fechaCreacion, Date fechainicio, Date fechaCambio, BigDecimal peso, Integer estatura, String objetivos) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechainicio;
        this.fechaCambio = fechaCambio;
        this.peso = peso;
        this.estatura = estatura;
        this.objetivos = objetivos;
    }

    /**
     *
     * @param id
     * @param alumno
     * @param monitor
     * @param fechaCreacion
     * @param fechaInicio
     * @param fechaCambio
     * @param peso
     * @param estatura
     * @param objetivos
     */
    public Tabla(Integer id, Alumno alumno, Monitor monitor, Date fechaCreacion, Date fechaInicio, Date fechaCambio, BigDecimal peso, Integer estatura, String objetivos) {
        super();
        this.id = id;
        this.alumno = alumno;
        this.monitor = monitor;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicio = fechaInicio;
        this.fechaCambio = fechaCambio;
        this.peso = peso;
        this.estatura = estatura;
        this.objetivos = objetivos;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
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
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     *
     * @param alumno
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     *
     * @return
     */
    public Monitor getMonitor() {
        return monitor;
    }

    /**
     *
     * @param monitor
     */
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    /**
     *
     * @return
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return
     */
    public Date getFechainicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechainicio
     */
    public void setFechainicio(Date fechainicio) {
        this.fechaInicio = fechainicio;
    }

    /**
     *
     * @return
     */
    public Date getFechaCambio() {
        return fechaCambio;
    }

    /**
     *
     * @param fechaCambio
     */
    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    public Integer getEstatura() {
        return estatura;
    }

    /**
     *
     * @param estatura
     */
    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    /**
     *
     * @return
     */
    public String getObjetivos() {
        return objetivos;
    }

    /**
     *
     * @param objetivos
     */
    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    /**
     *
     * @return
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * @param fechaInicio
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * @return Enlace a los detalles de la tabla (enlace a la lista de lineas
     * asociadas a la tabla)
     */
    @XmlElement
    public LinkBean getLink() {
        this.link = new LinkBean("self", "http://localhost:8080/Proyecto/webservice/tablas/" + this.getId() + "/lineas");
        return link;
    }

    /**
     *
     * @param link
     */
    public void setLink(LinkBean link) {
        this.link = link;
    }
}
