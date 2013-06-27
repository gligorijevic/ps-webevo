/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.website;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "htmltag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlTag.findAll", query = "SELECT h FROM HtmlTag h"),
    @NamedQuery(name = "HtmlTag.findByHtmlTagId", query = "SELECT h FROM HtmlTag h WHERE h.htmlTagId = :htmlTagId"),
    @NamedQuery(name = "HtmlTag.findByHtmlTagName", query = "SELECT h FROM HtmlTag h WHERE h.htmlTagName = :htmlTagName")})
public class HtmlTag implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_tag", sequenceName = "seq_tag")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tag")
    @Basic(optional = false)
    @Column(name = "htmlTagId")
    private Integer htmlTagId;
    @Basic(optional = false)
    @Column(name = "htmlTagName")
    private String htmlTagName;
    @JoinColumn(name = "pairedTagId", referencedColumnName = "htmlTagId")
    @ManyToOne(optional = false)
    private PairedHtmlTag pairedTagId;
    @JoinColumn(name = "htmlPageId", referencedColumnName = "htmlPageId")
    @ManyToOne(optional = false)
    private HtmlPage htmlPageId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "htmlTag")
    private UnpairedHtmlTag unpairedHtmlTag;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "htmlTag")
    private PairedHtmlTag pairedHtmlTag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "htmlTagId")
    private List<HtmlTagAttribute> htmlTagAttributeList;

    public HtmlTag() {
        htmlTagAttributeList = new ArrayList<HtmlTagAttribute>();
    }

    public HtmlTag(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    public HtmlTag(Integer htmlTagId, String htmlTagName) {
        this.htmlTagId = htmlTagId;
        this.htmlTagName = htmlTagName;
    }

    public Integer getHtmlTagId() {
        return htmlTagId;
    }

    public void setHtmlTagId(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    public String getHtmlTagName() {
        return htmlTagName;
    }

    public void setHtmlTagName(String htmlTagName) {
        this.htmlTagName = htmlTagName;
    }

    public PairedHtmlTag getPairedTagId() {
        return pairedTagId;
    }

    public void setPairedTagId(PairedHtmlTag pairedTagId) {
        this.pairedTagId = pairedTagId;
    }

    public HtmlPage getHtmlPageId() {
        return htmlPageId;
    }

    public void setHtmlPageId(HtmlPage htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public UnpairedHtmlTag getUnpairedHtmlTag() {
        return unpairedHtmlTag;
    }

    public void setUnpairedHtmlTag(UnpairedHtmlTag unpairedHtmlTag) {
        this.unpairedHtmlTag = unpairedHtmlTag;
    }

    public PairedHtmlTag getPairedHtmlTag() {
        return pairedHtmlTag;
    }

    public void setPairedHtmlTag(PairedHtmlTag pairedHtmlTag) {
        this.pairedHtmlTag = pairedHtmlTag;
    }

    @XmlTransient
    public List<HtmlTagAttribute> getHtmlTagAttributeList() {
        return htmlTagAttributeList;
    }

    public void setHtmlTagAttributeList(List<HtmlTagAttribute> htmlTagAttributeList) {
        this.htmlTagAttributeList = htmlTagAttributeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlTagId != null ? htmlTagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlTag)) {
            return false;
        }
        HtmlTag other = (HtmlTag) object;
        if ((this.htmlTagId == null && other.htmlTagId != null) || (this.htmlTagId != null && !this.htmlTagId.equals(other.htmlTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.HtmlTag[ htmlTagId=" + htmlTagId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "HtmlTag";
    }

    @Override
    public String vratiNazivTabele() {
        return "htmltag";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.htmlTagId = ((HtmlTag)gdo).getHtmlTagId();
        this.htmlTagName = ((HtmlTag)gdo).getHtmlTagName();
        this.htmlPageId = ((HtmlTag)gdo).getHtmlPageId();
        this.htmlTagAttributeList = ((HtmlTag)gdo).getHtmlTagAttributeList();
        this.pairedHtmlTag = ((HtmlTag)gdo).getPairedHtmlTag();
        this.unpairedHtmlTag = ((HtmlTag)gdo).getUnpairedHtmlTag();
        this.pairedTagId = ((HtmlTag)gdo).getPairedTagId();
    }

    @Override
    public Object vratiID() {
        return htmlTagId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.htmlTagId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(htmlTagId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New HtmlTag";
    }

    @Override
    public String vratiNazivObjekta() {
        return "HtmlTag";
    }
}
