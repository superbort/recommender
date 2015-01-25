package de.uni_muenster.dataintegration.recommender;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 * A simple Recommender which uses the file at the given path to produce recommendations based on
 * item similarity.
 */
public class ItemToItemRecommender extends AbstractRecommender {

  /**
   * Create a new ItemToItemRecommender for the specified file
   * @param filePath path to the file 
   */
  public ItemToItemRecommender(String filePath) throws IOException, TasteException {
    super(filePath);
    // we could also use GenericItemSimilarity here for better performance
    ItemSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
    recommender = new GenericItemBasedRecommender(dataModel, similarity);
  }

}
