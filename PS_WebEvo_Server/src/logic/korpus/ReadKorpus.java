/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.korpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class ReadKorpus {

//    public static Korpus readCorpus(String korpusFileLocation) throws FileNotFoundException, IOException {
//        Korpus korpus = new Korpus();
//        korpus.setId(1);
//        korpus.setName("test");
//        korpus.setDescription("test");
//
//        File korpusFile = new File(korpusFileLocation);
//
//        BufferedReader bufRdr = new BufferedReader(new FileReader(korpusFile));
//        String line = null;
//
//        String currentSubject = null;
//        String lastSubject = null;
//
//        boolean areTags = false;
//        while ((line = bufRdr.readLine()) != null) {
//            TaggedSentence taggedSentence; //= new TaggedSentence();
//            ArrayList<String> sentences = new ArrayList<>();
//            ArrayList<String> tags = new ArrayList<>();
//            String[] tokens = line.split(",");
//            if (tokens.length > 1) {
//                for (String token : tokens) {
//                    if (!token.equals("") && token != null) {
//                        if (token.equals("KUPUS")) {
//                            areTags = true;
//                        } else {
//                            if (!areTags) {
//                                sentences.add(token);
//                            } else {
//                                tags.add(token);
//                            }
//                        }
//                    }
//                }
//                taggedSentence = new TaggedSentence(sentences, tags);
//                korpus.getKorpus().add(taggedSentence);
//                areTags = false;
//            }
//        }
//        return korpus;
//    }
//
//    public static void saveKorpus() throws FileNotFoundException {
//        //PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(korpusFileLocation)));
//
//        ArrayList<Korpus> korpuses = (ArrayList<Korpus>) persistence.KorpusPersistence.getInstance().getKorpus();
//
//        //ArrayList<TaggedSentence> korpus = (ArrayList<TaggedSentence>) persistence.KorpusPersistence.getInstance().getKorpus().getKorpus();
//
//        for (int i = 0; i < korpuses.size(); i++) {
//            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("korpus_" + korpuses.get(i).getName())));
//
//            for (TaggedSentence taggedSentence : korpuses.get(i).getKorpus()) {
//                out.write(taggedSentence.saveSentence());
//                out.write("KUPUS,");
//                out.write(taggedSentence.saveTags().substring(0, taggedSentence.saveTags().length() - 1));
//                out.write("\n\r");
//                out.flush();
//            }
//            out.close();
//        }
////        out.close();
//    }
}
