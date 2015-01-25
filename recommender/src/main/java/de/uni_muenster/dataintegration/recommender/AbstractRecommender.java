package de.uni_muenster.dataintegration.recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

/**
 * Abstract base class for recommenders
 */
public abstract class AbstractRecommender {
  
  protected DataModel dataModel;
  protected Recommender recommender;
  
  /**
   * @throws IOException If the file can't be read
   */
  public AbstractRecommender(String filePath) throws IOException {
    dataModel = new FileDataModel(getFile(filePath));
  }

  /**
   * @param userId user for which recommendations are computed
   * @param howMany desired number of recommendations
   * @return List of recommended RecommendedItems, ordered from most strongly recommend to least
   */
  public List<RecommendedItem> recommend(int userId, int howMany) throws TasteException {
    List<RecommendedItem> recommendedItems = recommender.recommend(userId, howMany);
    return recommendedItems;
  }

  /**
   * Load a file from the maven resource folder (src/main/resource)
   * 
   * @param path The files path relative to the resource folder
   * @return The loaded file
   */
  private File getFile(String path) {
    ClassLoader classLoader = UserToUserRecommender.class.getClassLoader();
    File result = new File(classLoader.getResource(path).getFile());
    return result;
  }

}
