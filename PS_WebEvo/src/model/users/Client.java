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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByUserId", query = "SELECT c FROM Client c WHERE c.userId = :userId")})
public class Client implements GeneralDomainObject, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq_client", sequenceName = "seq_client")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client")
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Client() {
    }

    public Client(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.corpus.Client[ userId=" + userId + " ]";
    }

    @Override
    public String vratiImeKlase() {
        return "Client";
    }

    @Override
    public String vratiNazivTabele() {
        return "client";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.user = ((Client)gdo).getUser();
        this.userId = ((Client)gdo).getUserId();
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
        return "New Client";
    }

    @Override
    public String vratiNazivObjekta() {
        return "Client";
    }

    @Override
    public Class vratiKlasu() {
        return Client.class;
    }
    
}
