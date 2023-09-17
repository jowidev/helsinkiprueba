package Utils;

import Characters.User;

import java.util.InputMismatchException;
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
   
   public static int ingresarEntero(int min, int max, Scanner Scanner) {
		
		int opc=0;
		boolean error = false;
		
		do {
			error = false;
			try {
				opc = Scanner.nextInt();
				if (Integer.toString(opc).equals("moarenergy")) {
					System.out.println("chitero");
					//falta meter es user.roboto[0].ep+=500;
				}
				if((opc<min)||(opc>max)) {
					System.out.println("Ingrese un numero del " + min + " al " + max);
					error = true;
				}

				Scanner.nextLine();

			} catch (InputMismatchException e) {
				System.out.println("Ingrese el tipo de dato correcto");
				error = true;
				Scanner.nextLine();
			}
		}while(error);
		
		return opc;			
}

public static void esperar(int milis) {
	try {
		Thread.sleep(milis);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
