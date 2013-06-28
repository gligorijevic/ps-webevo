/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.website;

import java.io.Serializable;
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
@Table(name = "pairedhtmltag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PairedHtmlTag.findAll", query = "SELECT p FROM PairedHtmlTag p"),
    @NamedQuery(name = "PairedHtmlTag.findByHtmlTagId", query = "SELECT p FROM PairedHtmlTag p WHERE p.htmlTagId = :htmlTagId")})
public class PairedHtmlTag implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_ptag", sequenceName = "seq_ptag")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ptag")
    @Basic(optional = false)
    @Column(name = "htmlTagId")
    private Integer htmlTagId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pairedTagId")
    private List<HtmlTag> htmlTagList;
    @JoinColumn(name = "htmlTagId", referencedColumnName = "htmlTagId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private HtmlTag htmlTag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pairedHtmlTagid")
    private List<HtmlTagText> htmlTagTextList;

    public PairedHtmlTag() {
        htmlTagTextList = new ArrayList<HtmlTagText>();
    }

    public PairedHtmlTag(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    public Integer getHtmlTagId() {
        return htmlTagId;
    }

    public void setHtmlTagId(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    @XmlTransient
    public List<HtmlTag> getHtmlTagList() {
        return htmlTagList;
    }

    public void setHtmlTagList(List<HtmlTag> htmlTagList) {
        this.htmlTagList = htmlTagList;
    }

    public HtmlTag getHtmlTag() {
        return htmlTag;
    }

    public void setHtmlTag(HtmlTag htmlTag) {
        this.htmlTag = htmlTag;
    }

    @XmlTransient
    public List<HtmlTagText> getHtmlTagTextList() {
        return htmlTagTextList;
    }

    public void setHtmlTagTextList(List<HtmlTagText> htmlTagTextList) {
        this.htmlTagTextList = htmlTagTextList;
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
        if (!(object instanceof PairedHtmlTag)) {
            return false;
        }
        PairedHtmlTag other = (PairedHtmlTag) object;
        if ((this.htmlTagId == null && other.htmlTagId != null) || (this.htmlTagId != null && !this.htmlTagId.equals(other.htmlTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.PairedHtmlTag[ htmlTagId=" + htmlTagId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "PairedHtmlTag";
    }

    @Override
    public String vratiNazivTabele() {
        return "pairedhtmltag";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.htmlTagId = ((PairedHtmlTag) gdo).getHtmlTagId();
        this.htmlTag = ((PairedHtmlTag) gdo).getHtmlTag();
        this.htmlTagList = ((PairedHtmlTag) gdo).getHtmlTagList();
        this.htmlTagTextList = ((PairedHtmlTag) gdo).getHtmlTagTextList();
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
        return "New PairedHtmlTag";
    }

    @Override
    public String vratiNazivObjekta() {
        return "PairedHtmlTag";
    }

    @Override
    public Class vratiKlasu() {
        return PairedHtmlTag.class;
    }
}
