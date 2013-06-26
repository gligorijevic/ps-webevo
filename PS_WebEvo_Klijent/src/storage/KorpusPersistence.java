///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package storage;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Djordje Gligorijevic
// */
//public class KorpusPersistence {
//
//
//    private KorpusPersistence() {
//    }
//
//    public static KorpusPersistence getInstance() {
//        return KorpusPersistenceHolder.INSTANCE;
//    }
//
//    public Korpus getKorpusByTaggedSentenceID(int taggedSentenceID) {
//        for (int i = 0; i < korpuses.size(); i++) {
//            for (int j = 0; j < korpuses.get(i).getKorpus().size(); j++) {
//                if (korpuses.get(i).getKorpus().get(j).getId() == taggedSentenceID) {
//                    return korpuses.get(i);
//                }
//            }
//        }
//        return null;
//    }
//
//    public ArrayList<TaggedSentence> getAllTaggedSentences() {
//        ArrayList<TaggedSentence> allSentences = new ArrayList<>();
//
//        for (int i = 0; i < korpuses.size(); i++) {
//            allSentences.addAll(korpuses.get(i).getKorpus());
//        }
//
//        return allSentences;
//    }
//
//    public void addKorpus(Korpus korpus) throws Exception {
//        if (!korpuses.contains(korpus)) {
//            int id = getMaxKorpusId();
//            if(korpus.getId() == 0){
//               korpus.setId(id);
//            }
//            
//            korpuses.add(korpus);
//           
//        }else{
//            throw new Exception("Korpus already exists.");
//        }
//           
//    }
//
//    private static class KorpusPersistenceHolder {
//
//        private static final KorpusPersistence INSTANCE = new KorpusPersistence();
//    }
//
//    public void setKorpus(List<Korpus> korpus) {
//        this.korpuses = korpus;
//    }
//
//    public List<Korpus> getKorpus() {
//        return korpuses;
//    }
//
////    public void addTaggedSentence(TaggedSentence ts) {
////        for (Korpus korpus : korpuses) {
////            if (ts.getKorpus().equals(korpus)) {
////                korpus.getKorpus().add(ts);
////            }
////        }
////    }
//
////    public void deleteTaggedSentence(int i, Korpus k) {
////        for (int j = 0; j < korpuses.size(); j++) {
////            if (korpuses.get(j).equals(k)) {
////                korpuses.get(j).getKorpus().remove(i);
////            }
////        }
////    }
//
////    public void deleteTaggedSentenceByID(int id, Korpus k) {
////        for (int j = 0; j < korpuses.size(); j++) {
////            if (korpuses.get(j).equals(k)) {
////                for (int i = 0; i < korpuses.get(j).getKorpus().size(); i++) {
////                    if (korpuses.get(j).getKorpus().get(i).getId() == id) {
////                        korpuses.get(j).getKorpus().remove(i);
////                    }
////                }
////            }
////        }
////    }
//
////    public TaggedSentence getTaggedSentence(int i, Korpus k) {
////        for (int j = 0; j < korpuses.size(); j++) {
////            if (korpuses.get(j).equals(k)) {
////                return korpuses.get(j).getKorpus().get(i);
////            }
////        }
////        return null;
////    }
//
////    public Korpus getKorpusFromId(int korpusID) {
////        for (int i = 0; i < korpuses.size(); i++) {
////            if (korpuses.get(i).getId() == korpusID) {
////                return korpuses.get(i);
////            }
////        }
////        return null;
////    }
//
////    private int getMaxKorpusId() {
////        int id = -1;
////
////        for (int i = 0; i < korpuses.size(); i++) {
////            if (korpuses.get(i).getId() > id) {
////                id = korpuses.get(i).getId();
////            }
////        }
////        return id + 1;
////    }
//}
