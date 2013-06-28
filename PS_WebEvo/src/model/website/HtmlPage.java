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
import javax.persistence.Lob;
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
@Table(name = "htmlpage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HtmlPage.findAll", query = "SELECT h FROM HtmlPage h"),
    @NamedQuery(name = "HtmlPage.findByHtmlPageId", query = "SELECT h FROM HtmlPage h WHERE h.htmlPageId = :htmlPageId"),
    @NamedQuery(name = "HtmlPage.findByHtmlPageName", query = "SELECT h FROM HtmlPage h WHERE h.htmlPageName = :htmlPageName"),
    @NamedQuery(name = "HtmlPage.findByHtmlPageDescription", query = "SELECT h FROM HtmlPage h WHERE h.htmlPageDescription = :htmlPageDescription")})
public class HtmlPage implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_page", sequenceName = "seq_page")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_page")
    @Basic(optional = false)
    @Column(name = "htmlPageId")
    private Integer htmlPageId;
    @Basic(optional = false)
    @Column(name = "htmlPageName")
    private String htmlPageName;
    @Basic(optional = false)
    @Column(name = "htmlPageDescription")
    private String htmlPageDescription;
    @Basic(optional = false)
    @Lob
    @Column(name = "htmlPageText")
    private String htmlPageText;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "htmlPageId")
//    private List<HtmlTag> htmlTagList;
    @JoinColumn(name = "websiteId", referencedColumnName = "websiteId")
    @ManyToOne(optional = false)
    private Website websiteId;

    public HtmlPage() {
//        htmlTagList = new ArrayList<HtmlTag>();
    }

    public HtmlPage(Integer htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public HtmlPage(Integer htmlPageId, String htmlPageName, String htmlPageDescription, String htmlPageText) {
        this.htmlPageId = htmlPageId;
        this.htmlPageName = htmlPageName;
        this.htmlPageDescription = htmlPageDescription;
        this.htmlPageText = htmlPageText;
    }

    public Integer getHtmlPageId() {
        return htmlPageId;
    }

    public void setHtmlPageId(Integer htmlPageId) {
        this.htmlPageId = htmlPageId;
    }

    public String getHtmlPageName() {
        return htmlPageName;
    }

    public void setHtmlPageName(String htmlPageName) {
        this.htmlPageName = htmlPageName;
    }

    public String getHtmlPageDescription() {
        return htmlPageDescription;
    }

    public void setHtmlPageDescription(String htmlPageDescription) {
        this.htmlPageDescription = htmlPageDescription;
    }

    public String getHtmlPageText() {
        return htmlPageText;
    }

    public void setHtmlPageText(String htmlPageText) {
        this.htmlPageText = htmlPageText;
    }

//    @XmlTransient
//    public List<HtmlTag> getHtmlTagList() {
//        return htmlTagList;
//    }
//
//    public void setHtmlTagList(List<HtmlTag> htmlTagList) {
//        this.htmlTagList = htmlTagList;
//    }

    public Website getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Website websiteId) {
        this.websiteId = websiteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (htmlPageId != null ? htmlPageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HtmlPage)) {
            return false;
        }
        HtmlPage other = (HtmlPage) object;
        if ((this.htmlPageId == null && other.htmlPageId != null) || (this.htmlPageId != null && !this.htmlPageId.equals(other.htmlPageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.HtmlPage[ htmlPageId=" + htmlPageId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "HtmlPage";
    }

    @Override
    public String vratiNazivTabele() {
        return "htmlpage";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.htmlPageId = ((HtmlPage) gdo).getHtmlPageId();
        this.htmlPageName = ((HtmlPage) gdo).getHtmlPageName();
        this.htmlPageDescription = ((HtmlPage) gdo).getHtmlPageDescription();
        this.htmlPageText = ((HtmlPage) gdo).getHtmlPageText();
        this.websiteId = ((HtmlPage) gdo).getWebsiteId();
//        this.htmlTagList = ((HtmlPage) gdo).getHtmlTagList();
    }

    @Override
    public Object vratiID() {
        return htmlPageId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.htmlPageId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(htmlPageId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New HtmlPage";
    }

    @Override
    public String vratiNazivObjekta() {
        return "HtmlPage";
    }

    @Override
    public Class vratiKlasu() {
        return HtmlPage.class;
    }
}
