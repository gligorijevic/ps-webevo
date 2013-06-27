/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.website;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "htmltagattribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlTagAttribute.findAll", query = "SELECT h FROM HtmlTagAttribute h"),
    @NamedQuery(name = "HtmlTagAttribute.findByHtmlTagAttributeId", query = "SELECT h FROM HtmlTagAttribute h WHERE h.htmlTagAttributeId = :htmlTagAttributeId"),
    @NamedQuery(name = "HtmlTagAttribute.findByHtmlTagAttributeName", query = "SELECT h FROM HtmlTagAttribute h WHERE h.htmlTagAttributeName = :htmlTagAttributeName"),
    @NamedQuery(name = "HtmlTagAttribute.findByHtmlTagAttributeValue", query = "SELECT h FROM HtmlTagAttribute h WHERE h.htmlTagAttributeValue = :htmlTagAttributeValue")})
public class HtmlTagAttribute implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_taga", sequenceName = "seq_taga")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_taga")
    @Basic(optional = false)
    @Column(name = "htmlTagAttributeId")
    private Integer htmlTagAttributeId;
    @Basic(optional = false)
    @Column(name = "htmlTagAttributeName")
    private String htmlTagAttributeName;
    @Basic(optional = false)
    @Column(name = "htmlTagAttributeValue")
    private String htmlTagAttributeValue;
    @JoinColumn(name = "htmlTagId", referencedColumnName = "htmlTagId")
    @ManyToOne(optional = false)
    private HtmlTag htmlTagId;

    public HtmlTagAttribute() {
    }

    public HtmlTagAttribute(Integer htmlTagAttributeId) {
        this.htmlTagAttributeId = htmlTagAttributeId;
    }

    public HtmlTagAttribute(Integer htmlTagAttributeId, String htmlTagAttributeName, String htmlTagAttributeValue) {
        this.htmlTagAttributeId = htmlTagAttributeId;
        this.htmlTagAttributeName = htmlTagAttributeName;
        this.htmlTagAttributeValue = htmlTagAttributeValue;
    }

    public Integer getHtmlTagAttributeId() {
        return htmlTagAttributeId;
    }

    public void setHtmlTagAttributeId(Integer htmlTagAttributeId) {
        this.htmlTagAttributeId = htmlTagAttributeId;
    }

    public String getHtmlTagAttributeName() {
        return htmlTagAttributeName;
    }

    public void setHtmlTagAttributeName(String htmlTagAttributeName) {
        this.htmlTagAttributeName = htmlTagAttributeName;
    }

    public String getHtmlTagAttributeValue() {
        return htmlTagAttributeValue;
    }

    public void setHtmlTagAttributeValue(String htmlTagAttributeValue) {
        this.htmlTagAttributeValue = htmlTagAttributeValue;
    }

    public HtmlTag getHtmlTagId() {
        return htmlTagId;
    }

    public void setHtmlTagId(HtmlTag htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlTagAttributeId != null ? htmlTagAttributeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlTagAttribute)) {
            return false;
        }
        HtmlTagAttribute other = (HtmlTagAttribute) object;
        if ((this.htmlTagAttributeId == null && other.htmlTagAttributeId != null) || (this.htmlTagAttributeId != null && !this.htmlTagAttributeId.equals(other.htmlTagAttributeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.HtmlTagAttribute[ htmlTagAttributeId=" + htmlTagAttributeId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "HtmlTagAttribute";
    }

    @Override
    public String vratiNazivTabele() {
        return "htmltagattribute";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.htmlTagAttributeId = ((HtmlTagAttribute)gdo).getHtmlTagAttributeId();
        this.htmlTagAttributeName = ((HtmlTagAttribute)gdo).getHtmlTagAttributeName();
        this.htmlTagAttributeValue = ((HtmlTagAttribute)gdo).getHtmlTagAttributeValue();
        this.htmlTagId = ((HtmlTagAttribute)gdo).getHtmlTagId();
    }

    @Override
    public Object vratiID() {
        return htmlTagAttributeId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.htmlTagAttributeId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(htmlTagAttributeId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New HtmlTagAttribute";
    }

    @Override
    public String vratiNazivObjekta() {
        return "HtmlTagAttribute";
    }
}
