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
@Table(name = "htmltagtext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlTagText.findAll", query = "SELECT h FROM HtmlTagText h"),
    @NamedQuery(name = "HtmlTagText.findByHtmlTagTextId", query = "SELECT h FROM HtmlTagText h WHERE h.htmlTagTextId = :htmlTagTextId"),
    @NamedQuery(name = "HtmlTagText.findByHtmlTagTextValue", query = "SELECT h FROM HtmlTagText h WHERE h.htmlTagTextValue = :htmlTagTextValue")})
public class HtmlTagText implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_tagt", sequenceName = "seq_tagt")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tagt")
    @Basic(optional = false)
    @Column(name = "htmlTagTextId")
    private Integer htmlTagTextId;
    @Basic(optional = false)
    @Column(name = "htmlTagTextValue")
    private String htmlTagTextValue;
    @JoinColumn(name = "pairedHtmlTagid", referencedColumnName = "htmlTagId")
    @ManyToOne(optional = false)
    private PairedHtmlTag pairedHtmlTagid;

    public HtmlTagText() {
    }

    public HtmlTagText(Integer htmlTagTextId) {
        this.htmlTagTextId = htmlTagTextId;
    }

    public HtmlTagText(Integer htmlTagTextId, String htmlTagTextValue) {
        this.htmlTagTextId = htmlTagTextId;
        this.htmlTagTextValue = htmlTagTextValue;
    }

    public Integer getHtmlTagTextId() {
        return htmlTagTextId;
    }

    public void setHtmlTagTextId(Integer htmlTagTextId) {
        this.htmlTagTextId = htmlTagTextId;
    }

    public String getHtmlTagTextValue() {
        return htmlTagTextValue;
    }

    public void setHtmlTagTextValue(String htmlTagTextValue) {
        this.htmlTagTextValue = htmlTagTextValue;
    }

    public PairedHtmlTag getPairedHtmlTagid() {
        return pairedHtmlTagid;
    }

    public void setPairedHtmlTagid(PairedHtmlTag pairedHtmlTagid) {
        this.pairedHtmlTagid = pairedHtmlTagid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlTagTextId != null ? htmlTagTextId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlTagText)) {
            return false;
        }
        HtmlTagText other = (HtmlTagText) object;
        if ((this.htmlTagTextId == null && other.htmlTagTextId != null) || (this.htmlTagTextId != null && !this.htmlTagTextId.equals(other.htmlTagTextId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.HtmlTagText[ htmlTagTextId=" + htmlTagTextId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "HtmlTagText";
    }

    @Override
    public String vratiNazivTabele() {
        return "htmltagtext";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.htmlTagTextId = ((HtmlTagText) gdo).getHtmlTagTextId();
        this.htmlTagTextValue = ((HtmlTagText) gdo).getHtmlTagTextValue();
        this.pairedHtmlTagid = ((HtmlTagText) gdo).getPairedHtmlTagid();
    }

    @Override
    public Object vratiID() {
        return htmlTagTextId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.htmlTagTextId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(htmlTagTextId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New HtmlTagText";
    }

    @Override
    public String vratiNazivObjekta() {
        return "HtmlTagText";
    }
}
