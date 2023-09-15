package Utils;

import java.util.Random;
import java.util.Scanner;

public abstract class Utils {
   public static Scanner sc = new Scanner(System.in);
   public static Random r = new Random();

   public class Odds {
      enum Prob {
         HEADS,
         TAILS;
      }
   }

}
