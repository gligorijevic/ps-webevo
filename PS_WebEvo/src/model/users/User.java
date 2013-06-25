/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User implements GeneralDomainObject, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Expert expert;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Client client;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String username, String password, String firstName, String lastName, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public String vratiImeKlase() {
        return "User";
    }

    @Override
    public String vratiNazivTabele() {
        return "user";
    }

    @Override
    public void prekopirajVrednostiAtributa(GeneralDomainObject gdo) {
        this.userId = ((User)gdo).getUserId();
        this.username = ((User)gdo).getUsername();
        this.password = ((User)gdo).getPassword();
        this.firstName = ((User)gdo).getFirstName();
        this.lastName = ((User)gdo).getLastName();
        this.email = ((User)gdo).getEmail();
        this.client = ((User)gdo).getClient();
        this.expert = ((User)gdo).getExpert();
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
        return "New User";
    }

    @Override
    public String vratiNazivObjekta() {
        return "User";
    }
}
