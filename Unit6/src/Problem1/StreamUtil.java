//Dean Mason
//Unit 6

package Problem1;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamUtil is used to showcase how using parallel streams works
 */
public class StreamUtil
{
   /**
    * Measures the time it takes to count the number of odd numbers using
    * an infinite stream, given a limit of numbers to count.
    * @param generator the Random generator used to generate the numbers.
    * @param limit the number of odd numbers to count
    * @param isParallel if true, use a parallel stream
    */
   public static long timeOdds(Random generator, int limit, boolean isParallel)
   {
      IntStream fullList;
      if (isParallel){
         fullList = IntStream.generate(generator::nextInt).parallel();
      }else{
         fullList = IntStream.generate(generator::nextInt);
      }

      long start = System.nanoTime();

      long totalOddInt = fullList
              .filter(w -> w % 2 != 0)
              .limit(limit)
              .count();
      //System.out.println(totalOddInt);

       return (System.nanoTime() - start);
   }
}

/**
 * Main runs the program. I honestly didn't look at other file until after figuring this out since it wasn't referenced here
 * and it didn't say it needed any code in the rubric. This is neat to see the timing differences. But the other runs as well.
 */
class Main {
   public static void main(String[] args) {
      Random generator = new Random();
      int run = 10;
      while(run < 100000000){
         long regular = StreamUtil.timeOdds(generator, run, false);
         long parallel = StreamUtil.timeOdds(generator, run, true);
         double a = (double) regular / 1000000;
         double b = (double) parallel / 1000000;
         System.out.println("(Nanosecond) Regular time for " + run + ": " + regular + " || " + "Parallel time for " + run + ": " + parallel);
         System.out.println("\t\t\t\tMillisecond time: " + a + "\t||\t" + b);
         run = run * 10;

      }

   }
}