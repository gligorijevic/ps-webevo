/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import model.website.HtmlPage;
import model.website.Website;

/**
 *
 * @author Djordje Gligorijevic
 */
public class DBBroker {

    private static DBBroker instance;
    private EntityManagerFactory emf;

    private DBBroker() {
        emf = Persistence.createEntityManagerFactory("webevo");
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

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
}
