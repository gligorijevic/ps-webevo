/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

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
@Table(name = "speciality")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speciality.findAll", query = "SELECT s FROM Speciality s"),
    @NamedQuery(name = "Speciality.findBySpecialityId", query = "SELECT s FROM Speciality s WHERE s.specialityId = :specialityId"),
    @NamedQuery(name = "Speciality.findBySpecialityName", query = "SELECT s FROM Speciality s WHERE s.specialityName = :specialityName"),
    @NamedQuery(name = "Speciality.findBySpecialityDescription", query = "SELECT s FROM Speciality s WHERE s.specialityDescription = :specialityDescription")})
public class Speciality implements GeneralDomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq_speciality", sequenceName="seq_speciality") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_speciality")
    @Basic(optional = false)
    @Column(name = "specialityId")
    private Integer specialityId;
    @Basic(optional = false)
    @Column(name = "specialityName")
    private String specialityName;
    @Basic(optional = false)
    @Column(name = "specialityDescription")
    private String specialityDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialityId")
    private List<Expert> expertList;

    public Speciality() {
    }

    public Speciality(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public Speciality(Integer specialityId, String specialityName, String specialityDescription) {
        this.specialityId = specialityId;
        this.specialityName = specialityName;
        this.specialityDescription = specialityDescription;
    }

    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public String getSpecialityDescription() {
        return specialityDescription;
    }

    public void setSpecialityDescription(String specialityDescription) {
        this.specialityDescription = specialityDescription;
    }

    @XmlTransient
    public List<Expert> getExpertList() {
        return expertList;
    }

    public void setExpertList(List<Expert> expertList) {
        this.expertList = expertList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (specialityId != null ? specialityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speciality)) {
            return false;
        }
        Speciality other = (Speciality) object;
        if ((this.specialityId == null && other.specialityId != null) || (this.specialityId != null && !this.specialityId.equals(other.specialityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return specialityName;
    }

    @Override
    public String vratiImeKlase() {
        return "Speciality";
    }

    @Override
    public String vratiNazivTabele() {
        return "speciality";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.specialityId = ((Speciality)gdo).getSpecialityId();
        this.specialityDescription = ((Speciality)gdo).getSpecialityDescription();
        this.specialityName = ((Speciality)gdo).getSpecialityName();
        this.expertList = ((Speciality)gdo).getExpertList();
    }

    @Override
    public Object vratiID() {
        return specialityId;
    }

    @Override
    public void postaviAtributPretrazivanja(String atribut) {
        this.specialityId = Integer.parseInt(atribut);
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return String.valueOf(specialityId);
    }

    @Override
    public String vratiNazivNovogObjekta() {
        return "New Speciality";
    }

    @Override
    public String vratiNazivObjekta() {
        return "Speciality";
    }
    
}
