package pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Define la estructura para poder crear un elemento de tipo enlace dentro de
 * una entidad
 *
 * @author usuario0305
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "link")
public class LinkBean {

    /**
     * Url del enlace (deberá ser siempre self)
     */
    @XmlAttribute
    private String url;
    /**
     * Ruta a la cuál apunta el enlace
     */
    @XmlAttribute
    private String href;

    /**
     *
     */
    public LinkBean() {
    }

    /**
     *
     * @param url
     * @param href
     */
    public LinkBean(String url, String href) {
        this.url = url;
        this.href = href;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href
     */
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "LinkBean{" + "href=" + href + '}';
    }

}
