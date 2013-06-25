package logic.tagger.train;

import com.aliasi.corpus.Corpus;
import com.aliasi.corpus.ObjectHandler;
import com.aliasi.crf.ChainCrf;
import com.aliasi.crf.ChainCrfFeatureExtractor;
import com.aliasi.io.LogLevel;
import com.aliasi.io.Reporter;
import com.aliasi.io.Reporters;
import com.aliasi.stats.AnnealingSchedule;
import com.aliasi.stats.RegressionPrior;
import com.aliasi.tag.Tagging;
import com.aliasi.util.AbstractExternalizable;
import java.io.BufferedReader;
import logic.tagger.featurefunctions.SimpleChainCrfFeatureExtractor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import logic.tagger.EntityCorpus.TrainingCorpus;

/**
 *
 * @author Djordje Gligorijevic
 */
public class NamedEntityRecognitionTraining {

    public static String trainNamedEntityRecognitionModel(TrainingCorpus trainingCorpus) throws IOException {
        Corpus<ObjectHandler<Tagging<String>>> corpus = trainingCorpus;

        ChainCrfFeatureExtractor<String> featureExtractor = new SimpleChainCrfFeatureExtractor();

        boolean addIntercept = true;

        int minFeatureCount = 1;

        boolean cacheFeatures = false;

        boolean allowUnseenTransitions = true;

        double priorVariance = 4.0;
        boolean uninformativeIntercept = true;
        RegressionPrior prior = RegressionPrior.gaussian(priorVariance, uninformativeIntercept);
//        RegressionPrior prior = RegressionPrior.laplace(priorVariance, uninformativeIntercept);
        int priorBlockSize = 3;

        double initialLearningRate = 0.05;
        double learningRateDecay = 0.995;
        AnnealingSchedule annealingSchedule = AnnealingSchedule.exponential(initialLearningRate, learningRateDecay);

        double minImprovement = 0.00001;
        int minEpochs = 2;
        int maxEpochs = 2000;

        Reporter reporter = Reporters.stdOut().setLevel(LogLevel.DEBUG);
        Reporter reporter2 = Reporters.file(new File("results.txt"), "UTF-8").setLevel(LogLevel.DEBUG);

        System.out.println("\nEstimating");
        ChainCrf<String> crf = ChainCrf.estimate(corpus,
                featureExtractor,
                addIntercept,
                minFeatureCount,
                cacheFeatures,
                allowUnseenTransitions,
                prior,
                priorBlockSize,
                annealingSchedule,
                minImprovement,
                minEpochs,
                maxEpochs,
                reporter2);

        File modelFile = new File("simple_pos_model_crf_richer_"+trainingCorpus.getCorpusName());
        System.out.println("\nCompiling to file=" + modelFile);
        AbstractExternalizable.serializeTo(crf, modelFile);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("results.txt"))));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while((line=br.readLine())!=null){
            sb.append(line).append("\n\r");
        }
    
        return sb.toString();
    }
}
