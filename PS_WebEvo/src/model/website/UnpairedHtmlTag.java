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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "unpairedhtmltag")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnpairedHtmlTag.findAll", query = "SELECT u FROM UnpairedHtmlTag u"),
    @NamedQuery(name = "UnpairedHtmlTag.findByHtmlTagId", query = "SELECT u FROM UnpairedHtmlTag u WHERE u.htmlTagId = :htmlTagId")})
public class UnpairedHtmlTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Basic(optional = false)
    @Column(name = "htmlTagId")
    private Integer htmlTagId;
    @JoinColumn(name = "htmlTagId", referencedColumnName = "htmlTagId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private HtmlTag htmlTag;

    public UnpairedHtmlTag() {
    }

    public UnpairedHtmlTag(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    public Integer getHtmlTagId() {
        return htmlTagId;
    }

    public void setHtmlTagId(Integer htmlTagId) {
        this.htmlTagId = htmlTagId;
    }

    public HtmlTag getHtmlTag() {
        return htmlTag;
    }

    public void setHtmlTag(HtmlTag htmlTag) {
        this.htmlTag = htmlTag;
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
        if (!(object instanceof UnpairedHtmlTag)) {
            return false;
        }
        UnpairedHtmlTag other = (UnpairedHtmlTag) object;
        if ((this.htmlTagId == null && other.htmlTagId != null) || (this.htmlTagId != null && !this.htmlTagId.equals(other.htmlTagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.website.UnpairedHtmlTag[ htmlTagId=" + htmlTagId + " ]";
    }
}
