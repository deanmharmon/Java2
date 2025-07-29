//Dean Mason
//Unit 6
package Problem3;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class MoviesTester
{
   public static void main(String[] args) throws IOException
   {
      List<Movie> moviesList = Movies.readMovies("movies.txt");
 
      // You'll write this method
      List<String> initialWords = commonInitialWords(moviesList.stream());
      
      System.out.println("Size: " + initialWords.size());
      System.out.println("Expected: 100");
      System.out.println("Word #1: " + initialWords.get(0));
      System.out.println("Expected: The");
      System.out.println("Word #2: " + initialWords.get(1));
      System.out.println("Expected: A");
      System.out.println("Word #3: " + initialWords.get(2));
      System.out.println("Expected: In");
      System.out.println("Word #4: " + initialWords.get(3));
      System.out.println("Expected: I");
      System.out.println("Word #5: " + initialWords.get(4));
      System.out.println("Expected: Love");
      System.out.println("Word #100: " + initialWords.get(99));
      System.out.println("Expected: Before");
      for (String s : initialWords){
         System.out.println(s);
      }
   }
   
   /**
    * Given a Stream<Movie> return the 100 most common
    * starting words.
    */
   public static List<String> commonInitialWords(Stream<Movie> stream) {
      List<String> titles = stream.map(Movie::getTitle)
              .toList();

      List<String> firstWord = titles.stream()
              .map(title -> title.trim().split(" ")[0])
              .toList();

      List<String> firstUnique = firstWord.stream()
              .distinct()
              .toList();

      List<String> result = firstUnique.stream()
              .sorted((all, unique) -> {
                 long countAll = firstWord.stream().filter(w -> w.equals(all)).count();
                 long countUnique = firstWord.stream().filter(w -> w.equals(unique)).count();

                 if (countAll != countUnique) {
                    return Long.compare(countUnique, countAll);
                 } else {
                    return all.compareTo(unique);
                 }
              })
              .limit(100)
              .toList();
      return result;
   }

}