/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.corpus;

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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "taggedsentence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaggedSentence.findAll", query = "SELECT t FROM TaggedSentence t"),
    @NamedQuery(name = "TaggedSentence.findByTaggedSentenceId", query = "SELECT t FROM TaggedSentence t WHERE t.taggedSentenceId = :taggedSentenceId"),
    @NamedQuery(name = "TaggedSentence.findBySentence", query = "SELECT t FROM TaggedSentence t WHERE t.sentence = :sentence"),
    @NamedQuery(name = "TaggedSentence.findByTags", query = "SELECT t FROM TaggedSentence t WHERE t.tags = :tags")})
public class TaggedSentence implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taggedSentenceId")
    private Integer taggedSentenceId;
    @Basic(optional = false)
    @Column(name = "sentence")
    private String sentence;
    @Basic(optional = false)
    @Column(name = "tags")
    private String tags;
    @JoinColumn(name = "corpusId", referencedColumnName = "corpusId")
    @ManyToOne(optional = false)
    private Corpus corpusId;
//    private List<String> sentenceSplitted;
//    private List<String> tagsSplitted;

    public TaggedSentence() {
    }

    public TaggedSentence(Integer taggedSentenceId) {
        this.taggedSentenceId = taggedSentenceId;
    }

    public TaggedSentence(Integer taggedSentenceId, String sentence, String tags) {
        this.taggedSentenceId = taggedSentenceId;
        this.sentence = sentence;
        this.tags = tags;
    }

    public Integer getTaggedSentenceId() {
        return taggedSentenceId;
    }

    public void setTaggedSentenceId(Integer taggedSentenceId) {
        this.taggedSentenceId = taggedSentenceId;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
//        this.sentenceSplitted = Arrays.asList(sentence.split(" "));
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
//        this.tagsSplitted = Arrays.asList(tags.split(" "));
    }

    public Corpus getCorpusId() {
        return corpusId;
    }

    public void setCorpusId(Corpus corpusId) {
        this.corpusId = corpusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taggedSentenceId != null ? taggedSentenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaggedSentence)) {
            return false;
        }
        TaggedSentence other = (TaggedSentence) object;
        if ((this.taggedSentenceId == null && other.taggedSentenceId != null) || (this.taggedSentenceId != null && !this.taggedSentenceId.equals(other.taggedSentenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.corpus.TaggedSentence[ taggedSentenceId=" + taggedSentenceId + " ]";
    }

//    /**
//     * @return the sentenceSplitted
//     */
//    public List<String> getSentenceSplitted() {
//        return sentenceSplitted;
//    }
//
//    /**
//     * @param sentenceSplitted the sentenceSplitted to set
//     */
//    public void setSentenceSplitted(List<String> sentenceSplitted) {
//        this.sentenceSplitted = sentenceSplitted;
//    }
//
//    /**
//     * @return the tagsSplitted
//     */
//    public List<String> getTagsSplitted() {
//        return tagsSplitted;
//    }
//
//    /**
//     * @param tagsSplitted the tagsSplitted to set
//     */
//    public void setTagsSplitted(List<String> tagsSplitted) {
//        this.tagsSplitted = tagsSplitted;
//    }

    @Override
    public String vratiImeKlase() {
        return "TaggedSentence";
    }

    @Override
    public String vratiNazivTabele() {
        return "taggedsentence";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.corpusId = ((TaggedSentence)gdo).getCorpusId();
        this.sentence = ((TaggedSentence)gdo).getSentence();
        this.taggedSentenceId = ((TaggedSentence)gdo).getTaggedSentenceId();
        this.tags = ((TaggedSentence)gdo).getTags();
    }

    @Override
    public Object vratiID() {
        return taggedSentenceId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.taggedSentenceId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(taggedSentenceId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New TaggedSentence";
    }

    @Override
    public String vratiNazivObjekta() {
        return "TaggedSentence";
    }

    @Override
    public Class vratiKlasu() {
        return TaggedSentence.class;
    }
}
