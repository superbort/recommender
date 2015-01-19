package de.uni_muenster.dataintegration.recommender;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 * A simple Recommender which uses the file at the given path to produce recommendations based on
 * user similarity.
 * @author alexanderbrommer
 *
 */
public class UserToUserRecommender extends AbstractRecommender{

  //TODO Comments
  public UserToUserRecommender(String filePath) throws IOException, TasteException {
    super(filePath);
    UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
    UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);
    recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
  }

}