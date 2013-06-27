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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    public List<GeneralDomainObject> returnAll(GeneralDomainObject gdo) {
//        if (odoList == null) {
        List<GeneralDomainObject> odoList = new ArrayList<GeneralDomainObject>();
//        }
        String namedQuery = gdo.vratiImeKlase() + ".findAll";
        try {
            odoList = em.createNamedQuery(namedQuery).getResultList();
            logMessage = logMessage + "\n Uspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + "a iz baze.";
            //List<OpstiDomenskiObjekat> lista = em.createQuery("SELECT objd FROM "+tableName+" objd").getResultList();
            //return true;
        } catch (Exception e) {
            logMessage = logMessage + "\n Greska u upitu. Neuspesno vraćanje svih " + odoList.get(0).vratiNazivObjekta() + " iz baze.";
            //return false;
        }
        return odoList;
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
            System.out.println("Creating new" + odo.vratiImeKlase());
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
        System.out.println("Updating " + d.vratiImeKlase());
        GeneralDomainObject resultODO = em.find(d.getClass(), d.vratiID());

        if (resultODO == null) {
            logMessage = logMessage + "\n " + d.vratiImeKlase() + " nije pronadjen";
            return false;
        } else {
//            d.prekopirajVrednostiAtributa(resultODO);
            em.merge(d);
//            em.persist(resultODO);
            em.flush();
            System.out.println(d.vratiImeKlase() + " is updated.");
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

    public int getMaxId(GeneralDomainObject gdo) {
//        int result = (Integer) em.createQuery("select max(gdo.websiteId) from ? gdo")
//                .setParameter(1, gdo.vratiImeKlase()).getSingleResult();
//        Query query = em.createQuery("SELECT MAX(w.websiteId) FROM Website w", Integer.class);
        Integer result = em.createQuery("SELECT MAX(w.websiteId) FROM Website w", Integer.class).getSingleResult();
        System.out.println(result);
        return result;

    }

    public User loginUser(User loginUser) {
//        List<User> res = em.createQuery("SELECT u FROM User u WHERE u.username=?").setParameter(1, loginUser.getUsername()).getResultList();
        List<User> res = em.createNamedQuery("User.findByUsernameAndPassword").setParameter("username", loginUser.getUsername()).setParameter("password", loginUser.getPassword()).getResultList();
        System.out.println(res.size());
        return res.get(0);
    }

    public void registerNewUser(User regUser) throws Exception {
        List<User> resultList = em.createNamedQuery("User.findByUsername").setParameter("username", regUser.getUsername()).getResultList();
        if (resultList.size() == 1) {
            regUser = resultList.get(0);
            throw new Exception("User already exists");
        } else {
            em.persist(regUser);
            em.refresh(regUser);
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
            ex.printStackTrace();
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
                    Website site = em.find(Website.class, website.getWebsiteId());
                    System.out.println("site");
                }
            } else {
                System.out.println("ubacivanje novog website-a");
//                website.setWebsiteId(getMaxId(website) + 1);
                em.persist(website);
                em.flush();
                em.refresh(website);
//                Website site = em.find(Website.class, website.getWebsiteId());
//                System.out.println("site");
//                em.merge(website);
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
}
