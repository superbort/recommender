package de.uni_muenster.dataintegration.recommender;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class StartUp {
  
  private static final int NUMBER_OF_USERS = 943;  
  private static final int NUMBER_OF_RECOMMENDATIONS = 10;
  private static final String FILE_NAME = "u.data";

  public static void main(String[] args) throws IOException, TasteException {
    int userId = (new Random()).nextInt(NUMBER_OF_USERS);
    System.out.println("Recommendations for user id:"+ userId);
    
    System.out.println("User to user:");
    printRecommendations(new UserToUserRecommender(FILE_NAME), userId);

    
    System.out.println("Item to Item:");
    printRecommendations(new ItemToItemRecommender(FILE_NAME), userId);
  
  }
  
  private static void printRecommendations(AbstractRecommender recommender,int userId) throws TasteException{
    List<RecommendedItem> recommendations = recommender.recommend(userId, NUMBER_OF_RECOMMENDATIONS);
    for (RecommendedItem recommendation : recommendations) {
      System.out.println(recommendation);
    }

  }

}
