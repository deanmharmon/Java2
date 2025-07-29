//Dean Mason
//Unit 6

package Problem2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
/**
 *Words is used to count the words in a given list
 * and using that, find out the longest words, distinct words, and
 * non-possesive words with more than 10 chars.
 */
public class Words
{      
   /**
    * The noLetterRepeated method reads all of the words 
    * in filename and returns a list of all words with 
    * length of at least ten, in which no letter is repeated.
    * You may assume that filename has one word per line.
    */
   public static List<String> noLetterRepeated(String filename)
   {
      List<String> result;
      //These are the practically same lines used in the book because they work well, no reason
      //to reinvent the wheel.
      try (Stream<String> lines = Files.lines(Paths.get(filename))){
         Stream<String> words = lines.filter(w -> !w.endsWith("'s"))
                 .filter(w -> w.length() >= 10);
         result = allLettersUnique(words);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

      
      return result;
   }
   
   /**
    * The longestWord method takes a Stream<String> and
    * returns the longest word in the stream.
    */
   public static String longestWord(Stream<String> stream)
   {
      String result;
      result = stream.reduce("", (prev, next)
              -> prev.length() >= next.length() ? prev : next);
      return result;
   }
   
   /**
    * Given a Stream<String> and a length, 
    * returns the number of words of that length in the stream.
    */
   public static long wordCount(Stream<String> stream, int len)
   {
      long result = stream.filter(w ->
              w.length() == len).count();

      return result;
   }

   /**
    * allLettersUnique makes sure that all the characters per word in a stream
    * are distinct from one another
    * @param stream stream object to be looked at
    * @return List of strings where all letters are unique
    */
   private static List<String> allLettersUnique(Stream<String> stream){

      List<String> result = stream.filter(w -> w.toLowerCase()
                      .chars()
                      .distinct()
                      .count() == w.length())
              .toList();
      return result;
   }
}
