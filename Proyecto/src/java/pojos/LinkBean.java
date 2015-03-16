/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario0305
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "link")
public class LinkBean {

    @XmlAttribute
    private String url;
    @XmlAttribute
    private String href;

    public LinkBean() {
    }

    public LinkBean(String url, String href) {
        this.url = url;
        this.href = href;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
