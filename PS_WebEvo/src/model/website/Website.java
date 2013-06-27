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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "website")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Website.findAll", query = "SELECT w FROM Website w"),
    @NamedQuery(name = "Website.findByWebsiteId", query = "SELECT w FROM Website w WHERE w.websiteId = :websiteId"),
    @NamedQuery(name = "Website.findByWebsiteName", query = "SELECT w FROM Website w WHERE w.websiteName = :websiteName"),
    @NamedQuery(name = "Website.findByWebsiteDescription", query = "SELECT w FROM Website w WHERE w.websiteDescription = :websiteDescription"),
    @NamedQuery(name = "Website.findByWebsiteUrl", query = "SELECT w FROM Website w WHERE w.websiteUrl = :websiteUrl")})
public class Website implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_website", sequenceName = "seq_website", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_website")
    @Basic(optional = false)
    @Column(name = "websiteId")
    private Integer websiteId;
    @Basic(optional = false)
    @Column(name = "websiteName")
    private String websiteName;
    @Basic(optional = false)
    @Column(name = "websiteDescription")
    private String websiteDescription;
    @Basic(optional = false)
    @Column(name = "websiteUrl")
    private String websiteUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "websiteId")
    private List<HtmlPage> htmlPageList;

    public Website() {
        htmlPageList = new ArrayList<HtmlPage>();
    }

    public Website(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public Website(Integer websiteId, String websiteName, String websiteDescription, String websiteUrl) {
        this.websiteId = websiteId;
        this.websiteName = websiteName;
        this.websiteDescription = websiteDescription;
        this.websiteUrl = websiteUrl;
    }

    public Integer getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Integer websiteId) {
        this.websiteId = websiteId;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getWebsiteDescription() {
        return websiteDescription;
    }

    public void setWebsiteDescription(String websiteDescription) {
        this.websiteDescription = websiteDescription;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @XmlTransient
    public List<HtmlPage> getHtmlPageList() {
        return htmlPageList;
    }

    public void setHtmlPageList(List<HtmlPage> htmlPageList) {
        this.htmlPageList = htmlPageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (websiteId != null ? websiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Website)) {
            return false;
        }
        Website other = (Website) object;
        if ((this.websiteId == null && other.websiteId != null) || (this.websiteId != null && !this.websiteId.equals(other.websiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return websiteName;
    }

    @Override
    public String vratiImeKlase() {
        return "Website";
    }

    @Override
    public String vratiNazivTabele() {
        return "website";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.websiteId = ((Website)gdo).getWebsiteId();
        this.websiteName = ((Website)gdo).getWebsiteName();
        this.websiteDescription = ((Website)gdo).getWebsiteDescription();
        this.websiteUrl = ((Website)gdo).getWebsiteUrl();
        this.htmlPageList = ((Website)gdo).getHtmlPageList();
    }

    @Override
    public Object vratiID() {
        return websiteId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.websiteId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(websiteId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New Website";
    }

    @Override
    public String vratiNazivObjekta() {
        return "Website";
    }
}
