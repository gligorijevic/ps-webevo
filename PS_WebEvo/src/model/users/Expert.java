/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import model.GeneralDomainObject;

/**
 *
 * @author Djordje Gligorijevic
 */
@Entity
@Table(name = "expert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Expert.findAll", query = "SELECT e FROM Expert e"),
    @NamedQuery(name = "Expert.findByUserId", query = "SELECT e FROM Expert e WHERE e.userId = :userId")})
public class Expert implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @JoinColumn(name = "specialityId", referencedColumnName = "specialityId")
    @ManyToOne(optional = false)
    private Speciality specialityId;
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Expert() {
    }

    public Expert(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Speciality getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Speciality specialityId) {
        this.specialityId = specialityId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expert)) {
            return false;
        }
        Expert other = (Expert) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.corpus.Expert[ userId=" + userId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "Expert";
    }

    @Override
    public String vratiNazivTabele() {
        return "expert";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.specialityId = ((Expert)gdo).getSpecialityId();
        this.user = ((Expert)gdo).getUser();
        this.userId = ((Expert)gdo).getUserId();
    }

    @Override
    public Object vratiID() {
        return userId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.userId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(userId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New Expert";
    }

    @Override
    public String vratiNazivObjekta() {
        return "Expert";
    }
}
