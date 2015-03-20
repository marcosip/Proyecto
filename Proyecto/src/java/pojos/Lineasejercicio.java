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
 * Contiene los detalles especificos sobre cada ejercicio que se asocia a una
 * tabla. Por cada ejercicio, se especifican las veces que debe realizarse, el
 * peso a utilizar...
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "lineasejercicio")
@XmlType(propOrder = {"tabla", "dia", "ejercicio", "orden", "series", "repeticiones", "peso", "link"})
public class Lineasejercicio implements java.io.Serializable {

    @XmlAttribute
    private int id;
    @XmlElement
    private Integer tabla;
    @XmlElement
    private String dia;
    @XmlElement
    private int orden;
    @XmlElement
    private Integer series;
    @XmlElement
    private Integer repeticiones;
    @XmlElement
    private Integer peso;
    @XmlElement
    private Ejercicio ejercicio;

    /**
     * Enlace a la tabla a la cual está asociada los detalles de este ejercicio
     */
    @Transient
    private LinkBean link;

    /**
     *
     */
    public Lineasejercicio() {
    }

    /**
     *
     * @param id
     * @param dia
     * @param orden
     * @param series
     * @param repeticiones
     * @param peso
     * @param ejercicio
     * @param tabla
     */
    public Lineasejercicio(int id, String dia, int orden, Integer series, Integer repeticiones, Integer peso, Ejercicio ejercicio, Integer tabla) {
        this.id = id;
        this.dia = dia;
        this.orden = orden;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
        this.tabla = tabla;
    }

    /**
     *
     * @param id
     * @param tabla
     * @param dia
     * @param orden
     * @param series
     * @param repeticiones
     * @param peso
     * @param ejercicio
     * @param link
     */
    public Lineasejercicio(int id, Integer tabla, String dia, int orden, Integer series, Integer repeticiones, Integer peso, Ejercicio ejercicio, LinkBean link) {
        this.id = id;
        this.tabla = tabla;
        this.dia = dia;
        this.orden = orden;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso = peso;
        this.ejercicio = ejercicio;
        this.link = link;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getDia() {
        return dia;
    }

    /**
     *
     * @param dia
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     *
     * @return
     */
    public int getOrden() {
        return orden;
    }

    /**
     *
     * @param orden
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     *
     * @return
     */
    public Integer getSeries() {
        return series;
    }

    /**
     *
     * @param series
     */
    public void setSeries(Integer series) {
        this.series = series;
    }

    /**
     *
     * @return
     */
    public Integer getRepeticiones() {
        return repeticiones;
    }

    /**
     *
     * @param repeticiones
     */
    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    /**
     *
     * @return
     */
    public Integer getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     */
    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     */
    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    /**
     *
     * @param ejercicio
     */
    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    /**
     *
     * @return
     */
    public Integer getTabla() {
        return tabla;
    }

    /**
     *
     * @param tabla
     */
    public void setTabla(Integer tabla) {
        this.tabla = tabla;
    }

    /**
     *
     * @return Enlace a los detalles de la tabla (enlace a las líneas de la
     * tabla)
     */
    @XmlElement
    public LinkBean getLink() {
        this.link = new LinkBean("self", "http://localhost:8080/Proyecto/webservice/tablas/" + this.getTabla());
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
        return "Lineasejercicio{" + "tabla=" + tabla + ", dia=" + dia + ", orden=" + orden + ", series=" + series + ", repeticiones=" + repeticiones + ", peso=" + peso + ", ejercicio=" + ejercicio + '}';
    }

}
