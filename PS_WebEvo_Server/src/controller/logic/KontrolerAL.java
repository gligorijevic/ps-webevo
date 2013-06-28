package controller.logic;

/*
 * KontrolerAL.java
 *
 * 02.05.2011
 *
 * @autor Dr Sinisa Vlajic
 *
 * Katedra za softversko inzenjerstvo
 *
 * Laboratorija za softversko inzenjerstvo
 *
 * Fakultet organizacionih nauka - Beograd
 *
 */
import exception.WrongUsernameOrPasswordException;
import java.io.*;
import java.net.*;
import java.util.List;
import javax.swing.tree.DefaultTreeModel;
import model.GeneralDomainObject;
import model.corpus.Corpus;
import model.corpus.TaggedSentence;
import model.users.User;
import model.website.HtmlPage;
import model.website.Website;
import org.jsoup.nodes.Document;
import util.RequestOntology;
import util.TransferObject;

public class KontrolerAL // Kontroler aplikacione logike
{

    static ServerSocket ss;
    static Klijent kl[];

    public static void main(String[] args) throws Exception {
        kl = new Klijent[10];
        ss = new ServerSocket(8189);

        System.out.println("Podignut je serverski program:");
        for (int brojKlijenta = 0; brojKlijenta < 10; brojKlijenta++) {
            Socket soketS = ss.accept();
            System.out.println("Stigao klijent " + (brojKlijenta + 1));
            kl[brojKlijenta] = new Klijent(soketS, brojKlijenta + 1);
        }
    }
}

class Klijent extends Thread {

    public Klijent(Socket soketS1, int brojKlijenta1) {
        soketS = soketS1;
        brojKlijenta = brojKlijenta1;
        System.out.println("Konstruktor");
        start();
    }

    @Override
    public void run() {
        try {
//            String signal = "";
            out = new ObjectOutputStream(soketS.getOutputStream());
            in = new ObjectInputStream(soketS.getInputStream());

            System.out.println("run");
            while (true) { // Citanje naziva operacije i racuna
//                String NazivSO = (String) in.readObject();
                TransferObject to = (TransferObject) in.readObject();
                System.out.println("Stigao je zahtev" + to.getClientRequestOperation());
//                GeneralDomainObject gdo = (GeneralDomainObject) in.readObject();
                if (to.getClientRequestOperation() == RequestOntology.LOGIN) {
                    User user = (User) to.getClientObject();
                    System.out.println("Login klijenta: " + user.getUsername());
                    try {
                        User login = ControllerAL.getInstance().login(user.getUsername(), user.getPassword());
                        to.setServerObject(login);
                        to.setServerMessage("Successful login!");
                    } catch (WrongUsernameOrPasswordException e) {
                        to.setServerMessage(e.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.REGISTER) {
                    try {
                        User user = (User) to.getClientObject();
//                        ControllerAL.getInstance().register(user);
                        ControllerAL.getInstance().addNewGDO(user);
                        to.setServerObject(user);
                        to.setServerMessage("User " + user.getUsername() + " is successfully registered");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                        System.err.println(ex);
                        ex.printStackTrace();
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.GET_ALL_CORPUSES) {
                    List<Corpus> allCorpuses = (List<Corpus>) to.getClientObject();
                    List<GeneralDomainObject> returnAll = ControllerAL.getInstance().returnAll(new Corpus());
                    for (GeneralDomainObject generalDomainObject : returnAll) {
                        allCorpuses.add((Corpus) generalDomainObject);
                    }
                    for (Corpus c : allCorpuses) {
                        c.getTaggedSentenceList().size();
                    }
                    to.setServerObject(allCorpuses);
                    to.setServerMessage("All courpuses have been found.");
                } else if (to.getClientRequestOperation() == RequestOntology.ADD_NEW_CORPUS) {
                    Corpus newCorpus = (Corpus) to.getClientObject();
                    try {
                        ControllerAL.getInstance().addNewGDO(newCorpus);
                        to.setServerMessage("New corus has been sccessfuly saved.");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.AD_NEW_TAGGEDSENTENCE) {
                    TaggedSentence ts = (TaggedSentence) to.getClientObject();
                    try {
                        ControllerAL.getInstance().addNewGDO(ts);
                        to.setServerMessage("New taggedSentence has been sccessfuly saved.");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.LOAD_WEBPAGE) {
                    String webpageUrl = (String) to.getClientObject();
                    try {
                        Document parseWebpageDocumentFromUrl = ControllerAL.getInstance().parseWebpageDocumentFromUrl(webpageUrl);
                        to.setServerObject(parseWebpageDocumentFromUrl.html());
                        to.setServerMessage("Webpage has been successfully loaded");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.GET_WEBPAGE_TREEMODEL) {
                    String webpageUrl = (String) to.getClientObject();
                    try {
                        Document parseWebpageDocumentFromUrl = ControllerAL.getInstance().parseWebpageDocumentFromUrl(webpageUrl);
                        DefaultTreeModel treeModelFromWebpage = ControllerAL.getInstance().getTreeModelFromWebpage(parseWebpageDocumentFromUrl);
//                        Document parseWebpageDocumentFromUrl = ControllerAL.getInstance().parseWebpageDocumentFromUrl(webpageUrl);
                        to.setServerObject(treeModelFromWebpage);
                        to.setServerMessage("Webpage has been successfully copieds");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.GET_ALL_WEBSITES) {
                    List<Website> allWebsites = (List<Website>) to.getClientObject();
                    List<GeneralDomainObject> returnAll = ControllerAL.getInstance().returnAll(new Website());
                    for (GeneralDomainObject generalDomainObject : returnAll) {
                        allWebsites.add((Website) generalDomainObject);
                    }
                    for (Website w : allWebsites) {
                        w.getHtmlPageList().size();
                    }
                    to.setServerObject(allWebsites);
                    to.setServerMessage("All courpuses have been found.");
                } else if (to.getClientRequestOperation() == RequestOntology.SAVE_WEBPAGE) {
                    Website ts = (Website) to.getClientObject();
                    try {
                        ControllerAL.getInstance().addNewGDO(ts);
                        to.setServerMessage("New webpage has been sccessfuly saved.");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                } else if (to.getClientRequestOperation() == RequestOntology.TRAIN_NLP_MODEL) {
                    Corpus corpus = (Corpus) to.getClientObject();
                    String trainingDone = ControllerAL.getInstance().startTraining(corpus);
                    to.setServerObject(trainingDone);
                    to.setServerMessage("Training done");
                } else if (to.getClientRequestOperation() == RequestOntology.TRAIN_NLP_MODEL) {
                    Corpus corpus = (Corpus) to.getServerObject();
                    ControllerAL.getInstance().deleteGDO(corpus);
                    to.setServerObject(null);
                    to.setServerMessage("Removing corpus done");
                } else if (to.getClientRequestOperation() == RequestOntology.UPDATE_TAGGEDSENTENCE) {
                    TaggedSentence ts = (TaggedSentence) to.getServerObject();
                    ControllerAL.getInstance().updateGDO(ts);
                    to.setServerObject(ts);
                    to.setServerMessage("Updateing tagged sentence is done");
                } else if (to.getClientRequestOperation() == RequestOntology.UPDATE_CORPUS) {
                    Corpus corpus = (Corpus) to.getServerObject();
                    ControllerAL.getInstance().updateGDO(corpus);
                    to.setServerObject(corpus);
                    to.setServerMessage("Updateing tagged sentence is done");
                } else if (to.getClientRequestOperation() == RequestOntology.COPY_WEBPAGE_STRUCTURE) {
                    String webpageUrl = (String) to.getClientObject();
                    try {
                        Document parseWebpageDocumentFromUrl = ControllerAL.getInstance().parseWebpageDocumentFromUrl(webpageUrl);
                        HtmlPage htmlPage = new HtmlPage();
                        ControllerAL.getInstance().copyHtmlPageStructure(parseWebpageDocumentFromUrl, htmlPage);
                        to.setServerObject(htmlPage);
                        to.setServerMessage("HtmlPage has been successfully copied");
                    } catch (Exception ex) {
                        to.setServerMessage(ex.getMessage());
                    }
                }

                //                else if (NazivSO.equals("VratiSve") == true) {
                //                    List<OpstiDomenskiObjekat> odoList = new ArrayList<OpstiDomenskiObjekat>();
                //                    odoList.add(gdo);
                //                    odoList = VratiSve.VratiSve(odoList, signal);
                //                    List<OpstiDomenskiObjekat> odoListDS = new ArrayList<OpstiDomenskiObjekat>();
                //                    if (gdo instanceof Dataset) {
                //
                //                        for (int i = 0; i < odoList.size(); i++) {
                //                            OpstiDomenskiObjekat opstiDomenskiObjekat = odoList.get(i);
                //                            DataSetTO dto = new DataSetTO((Dataset) opstiDomenskiObjekat);
                //                            odoListDS.add(dto);
                //
                //                        }
                //                        out.writeObject(odoListDS);
                //                    } else {
                //                        out.writeObject(odoList);
                //                    }
                //                    out.writeObject(signal);
                //                }  
//                else {
//                    if (NazivSO.equals("kreirajNovi") == true) {
//                        signal = KreirajNovi.kreirajNovi(gdo);
//                    }
//
//                    if (NazivSO.equals("Pretrazi") == true) {
//                        signal = Pretrazi.Pretrazi(gdo);
//                    }
//
//                    if (NazivSO.equals("Zapamti") == true) {
                //signal = Zapamti.Zapamti(gdo);

//                    }
//
//                    if (NazivSO.equals("Obradi") == true) {
//                        signal = Obradi.Obradi(gdo);
//                    }
//
//                    if (NazivSO.equals("Storniraj") == true) {
//                        signal = Storniraj.Storniraj(gdo);
//                    }
//                }
                // Slanje promenjenog racuna i signala o uspesnosti operacije
//                out.writeObject(gdo);
//                out.writeObject(signal);
                out.writeObject(to);
                out.flush();
                out.reset();
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    private Socket soketS;
    int brojKlijenta;
    ObjectOutputStream out;
    ObjectInputStream in;
}
