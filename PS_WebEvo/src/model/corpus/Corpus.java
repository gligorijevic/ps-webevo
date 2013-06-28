/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.corpus;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "corpus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corpus.findAll", query = "SELECT c FROM Corpus c"),
    @NamedQuery(name = "Corpus.findByCorpusId", query = "SELECT c FROM Corpus c WHERE c.corpusId = :corpusId"),
    @NamedQuery(name = "Corpus.findByCorpusName", query = "SELECT c FROM Corpus c WHERE c.corpusName = :corpusName"),
    @NamedQuery(name = "Corpus.findByCorpusDescription", query = "SELECT c FROM Corpus c WHERE c.corpusDescription = :corpusDescription")})
public class Corpus implements GeneralDomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "corpusId")
    private Integer corpusId;
    @Basic(optional = false)
    @Column(name = "corpusName")
    private String corpusName;
    @Basic(optional = false)
    @Column(name = "corpusDescription")
    private String corpusDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corpusId")
    private List<TaggedSentence> taggedSentenceList;

    public Corpus() {
    }

    public Corpus(Integer corpusId) {
        this.corpusId = corpusId;
    }

    public Corpus(Integer corpusId, String corpusName, String corpusDescription) {
        this.corpusId = corpusId;
        this.corpusName = corpusName;
        this.corpusDescription = corpusDescription;
    }

    public Integer getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(Integer corpusId) {
        this.corpusId = corpusId;
    }

    public String getCorpusName() {
        return corpusName;
    }

    public void setCorpusName(String corpusName) {
        this.corpusName = corpusName;
    }

    public String getCorpusDescription() {
        return corpusDescription;
    }

    public void setCorpusDescription(String corpusDescription) {
        this.corpusDescription = corpusDescription;
    }

    @XmlTransient
    public List<TaggedSentence> getTaggedSentenceList() {
        return taggedSentenceList;
    }

    public void setTaggedSentenceList(List<TaggedSentence> taggedSentenceList) {
        this.taggedSentenceList = taggedSentenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corpusId != null ? corpusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corpus)) {
            return false;
        }
        Corpus other = (Corpus) object;
        if ((this.corpusId == null && other.corpusId != null) || (this.corpusId != null && !this.corpusId.equals(other.corpusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return corpusName;
    }

    @Override
    public String vratiImeKlase() {
        return "Corpus";
    }

    @Override
    public String vratiNazivTabele() {
        return "corpus";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.corpusDescription = ((Corpus)gdo).getCorpusDescription();
        this.corpusId = ((Corpus)gdo).getCorpusId();
        this.corpusName = ((Corpus)gdo).getCorpusName();
        this.taggedSentenceList = ((Corpus)gdo).getTaggedSentenceList();
    }

    @Override
    public Object vratiID() {
        return corpusId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.corpusId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(corpusId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New Corpus";
    }

    @Override
    public String vratiNazivObjekta() {
        return "Corpus";
    }

    @Override
    public Class vratiKlasu() {
        return Corpus.class;
    }
    
}
