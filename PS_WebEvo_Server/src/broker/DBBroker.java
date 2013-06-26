/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.GeneralDomainObject;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import model.users.User;
import model.website.HtmlPage;
import model.website.Website;

/**
 *
 * @author Djordje Gligorijevic
 */
public class DBBroker {

    private static DBBroker instance;
    private EntityManagerFactory emf;
    private EntityManager em;
    private static String logMessage;

    private DBBroker() {
        emf = Persistence.createEntityManagerFactory("webevo");
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    /*Beginning of GeneralDomainObject calls */
    public List<GeneralDomainObject> returnAll(List<GeneralDomainObject> odoList) throws Exception {
        if (odoList == null) {
            odoList = new ArrayList<GeneralDomainObject>();
        }
        String namedQuery = odoList.get(0).vratiImeKlase() + ".findAll";
        try {
            odoList = em.createNamedQuery(namedQuery).getResultList();
            logMessage = logMessage + "\n Uspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + "a iz baze.";
            //List<OpstiDomenskiObjekat> lista = em.createQuery("SELECT objd FROM "+tableName+" objd").getResultList();
            //return true;
            return odoList;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska u upitu. Neuspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + " iz baze.";
            throw e;
            //return false;
        }
    }

    public List<GeneralDomainObject> returnGDOforCondition(GeneralDomainObject odo, HashMap<String, Object> mapFieldValue) throws Exception {
        String query = "SELECT objd FROM " + odo.vratiImeKlase() + " objd where ";
        //Query createQuery = em.createQuery("SELECT objd FROM "+odo.vratiImeKlase()+" objd where ");

        for (Map.Entry<String, Object> entry : mapFieldValue.entrySet()) {
            query += "objd.";
            String string = entry.getKey();
            Object object = entry.getValue();
            query += string + "='" + object + "' AND ";
            //  createQuery = createQuery.setParameter(string, object);
        }
        String newq = query.substring(0, query.length() - 4);
        newq += ";";
        System.out.println(newq);
        try {
            //List<OpstiDomenskiObjekat> lista = createQuery.getResultList();
            List<GeneralDomainObject> lista = em.createQuery(newq).getResultList();


            return lista;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska u upitu. Neuspesno vraćanje " + odo.getClass().getSimpleName() + "po uslovu iz baze.";
            throw e;
        }
    }

    public void createNew(GeneralDomainObject odo) throws Exception {
        try {
            System.out.println("Usao u kreiraj novi");
            em.persist(odo);
            System.out.println("Prosao persist");
            em.flush();
            System.out.println("Prosao flush");
            em.refresh(odo);
            System.out.println("Prosao refresh");

            System.out.println("kreiran novi " + odo.vratiID() + " " + odo.vratiNazivNovogObjekta());

            logMessage = logMessage + "\n Uspesno kreiran " + odo.vratiNazivObjekta();
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska prilikom kreiranja " + odo.vratiNazivObjekta();
            throw e;
        }
    }

    public void saveGDO(GeneralDomainObject odo) throws Exception {
        try {
            em.persist(odo);
        } catch (Exception e) {
            logMessage = logMessage + "\n Objekat " + odo.getClass().getSimpleName() + " nije sačuvan.";
            throw e;
        }
    }

    public boolean deleteGDO(GeneralDomainObject d) {
        GeneralDomainObject resultODO = em.find(d.getClass(), d.vratiID());
        System.out.println("U obrisi je getid() klase:" + d.vratiID().getClass() + ", a d.getClass() je klase:" + d.getClass());
        if (resultODO == null) {
            logMessage = logMessage + "\n " + d.vratiImeKlase() + " nije pronadjen";
            return false;
        } else {
            em.remove(resultODO);
            logMessage = logMessage + "\n " + d.vratiImeKlase() + " uspešno izbrisan.";
            return true;
        }
    }

    public boolean updateGDO(GeneralDomainObject d) {
        GeneralDomainObject resultODO = em.find(d.getClass(), d.vratiID());

        if (resultODO == null) {
            logMessage = logMessage + "\n " + d.vratiImeKlase() + " nije pronadjen";
            return false;
        } else {
            d.prekopirajVrednostiAtributa(resultODO);
            em.merge(d);
//            em.persist(resultODO);
//            em.flush();
//           // em.refresh(resultODO);
            return true;
        }
    }

    public boolean beginTransaction() {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            logMessage = logMessage + "\n Otvorena je baza.";
            return true;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska pri otvaranju baze.";
            return false;
        }
    }

    public boolean closeTransaction() {
        try {
            em.close();
            logMessage = logMessage + "\n Zatvorena je baza.";
            return true;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska pri zatvaranju baze.";
            return false;
        }
    }

    public boolean commitTransaction() {
        try {
            em.getTransaction().commit();
            logMessage = logMessage + "\n Commit transakcije.";
            return true;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska prilikom commit-a tramsakcije.";
            return false;
        }
    }

    public boolean rollbackTransaction() {
        try {
            em.getTransaction().rollback();
            logMessage = logMessage + "\n Rollback transakcije.";
            return true;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska prilikom rollback-a tramsakcije.";
            return false;
        }

    }

    /* Ending of GeneralDomainObject calls*/
    public void addNewCorpus(Corpus corpus) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(corpus);

            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void updateCorpus(Corpus corpus) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Corpus test = em.find(Corpus.class, corpus.getCorpusId());
            if (test != null) {
                em.merge(corpus);
            } else {
                em.persist(corpus);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void removeCorpus(Corpus corpus) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(corpus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void getTaggedSentence(int id) {
    }

    public void getTaggedSentences() {
    }

    public void addTaggedSentence(TaggedSentence taggedSentence) throws SQLException {
    }

    public void updateTaggedSentence(TaggedSentence taggedSentence) {
    }

    public void removeTaggedSentence(int id) {
    }

    public void removeTaggedSentences() {
    }

    public void getAllKorpusData() throws SQLException {
        readKorpusesData();
        getTaggedSentencesData();
    }

    private void readKorpusesData() throws SQLException {
    }

    private void getTaggedSentencesData() throws SQLException {
    }

    public List<Corpus> getAllCorpuses() {
        EntityManager em = emf.createEntityManager();
        List<Corpus> res = em.createQuery("SELECT c FROM Corpus c").getResultList();
        em.close();
        return res;
    }

    public void addNewTaggedSentence(TaggedSentence ts) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ts);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    /*
     * TODO testirati da li radi kako treba.
     */
    public void addWebsite(Website website) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (website.getWebsiteId() != null) {
                Website websiteInBase = em.find(Website.class, website.getWebsiteId());
                if (websiteInBase != null) {
                    em.merge(website);
                } else {
                    em.persist(website);
                }
            } else {
                em.persist(website);
                em.flush();
                em.refresh(website);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void addHtmlPage(HtmlPage htmlPage) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(htmlPage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public List<Website> getAllWebsites() {
        EntityManager em = emf.createEntityManager();
        List<Website> res = em.createQuery("SELECT w FROM Website w").getResultList();
        em.close();
        return res;
    }

    public User loginUser(User loginUser) {
//        List<User> res = em.createQuery("SELECT u FROM User u WHERE u.username=?").setParameter(1, loginUser.getUsername()).getResultList();
        List<User> res = em.createNamedQuery("User.findBysernameAndPassword").setParameter("username", loginUser.getUsername()).setParameter("password", loginUser.getPassword()).getResultList();
        System.out.println(res.size());
//        loginUser = res.get(0);
        return res.get(0);
    }

    public User registerNewUser(User regUser) {
        List<User> resultList = em.createNamedQuery("User.findByUsername").setParameter("username", regUser.getUsername()).getResultList();
        if(resultList.size()==1){
            regUser = resultList.get(0);
        }else{
            regUser = null;
        }
        return resultList.get(0);
    }

}
