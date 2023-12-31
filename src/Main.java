import java.util.InputMismatchException;
import java.util.Scanner;

import Characters.Ai;
import Characters.User;
import Robots.Robot;
import Robots.StarPlatinum;
import Robots.Titan;
import Utils.Utils;



public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static User user;
	
    public static void main(String[] args) {
    	
    	
    	
        Ai ai = new Ai();
        StarPlatinum starPlatinum = new StarPlatinum();
        Titan titan = new Titan();
        int turno = Utils.r.nextInt(2);
        Robot[] robotsDisponibles = {titan, starPlatinum};
        boolean continueBattle = true;
        boolean puedeAtacar = true;
        System.out.println("ingrese su nombre: ");
        String name = Utils.sc.nextLine();
        user = new User(name);

        System.out.println("Bienvenido, "+user.name);
        System.out.println("elija su robot:");
        for (int i=0; i<2; i++) {
            System.out.println(robotsDisponibles[i].name);
        }
        int sel = Utils.ingresarEntero(1,2,Utils.sc);


        user.roboto	[0] = robotsDisponibles[(sel-1)];
        ai.robot[0] = robotsDisponibles[1-(sel-1)];

        System.out.println("Tu robot: " + user.roboto[0].name);
        System.out.println("robot del rival: " + ai.robot[0].name);
        Utils.esperar(1000);
        System.out.println("Tirando moneda...");
		Utils.esperar(1000);
		System.out.println("Empieza " + ((turno==0)?user.name:ai.name));

        do {
        	
        	puedeAtacar = true;
        	
			 if(turno==0) { //el chabon que ataca
				 
				 puedeAtacar = procesarEfectoUser(user);
				 
				 if(puedeAtacar) {
					 
					 boolean error = false;
					do {
						int opc = 0;
						UserAtkSelector(user, ai, opc, error, turno);

					} while(error);
				}
					
					
             }  //el chabon que ataca

             else { //el bot que ataca
            	 
            	 puedeAtacar = procesarEfectoAi(ai);
				 
				 if(puedeAtacar) {
					 
					 boolean error = false;
	                 do {

	                     int aopc = 0;
	                     AiAtkSelector(user, ai, aopc, error, turno);

	                 } while(error);
				}
                 
                 
                 
             } //el bot que ataca

			 
			 
			 
			 
			if (!titan.isAlive()||!starPlatinum.isAlive()) {
				System.out.println("ha finalizado la pelea");
                if (!user.roboto[0].isAlive()) {
                    System.out.println("Has perdido!");
                } else {
                    System.out.println("Has ganado!");
                }
				continueBattle = false;
			}

            if (titan.ep<50 && starPlatinum.ep<50) {
                System.out.println("Ninguno tiene energía restante");
                if (user.roboto[0].hp>ai.robot[0].hp) {
                    System.out.println("¡Has ganado!");
                } else if (ai.robot[0].hp>user.roboto[0].hp){
                    System.out.println("Has perdido!");
                }
                continueBattle = false;
            }

			turno = (turno==0)?1:0;
		        
		}while((starPlatinum.isAlive()|| titan.isAlive())&&continueBattle);


	} //public static main string args

    private static boolean procesarEfectoAi(Ai ai) {
    	boolean puedeAtacar = true;
    	if(ai.robot[0].efectoSecundario) {
			switch(ai.robot[0].estado) {
			case INABILITADO:
				System.out.println("No puede atacar por " + ai.robot[0].turnos + " turnos");
				ai.robot[0].restarTurnos();
				puedeAtacar = false;
				break;
			}
		}
		return puedeAtacar;
		
	}

	private static boolean procesarEfectoUser(User user) {
    	
    	boolean puedeAtacar = true;
    	if(user.roboto[0].efectoSecundario) {
			switch(user.roboto[0].estado) {
			case INABILITADO:
				System.out.println("No puede atacar por " + user.roboto[0].turnos + " turnos");
				user.roboto[0].restarTurnos();
				puedeAtacar = false;
				break;
			}
		}
		return puedeAtacar;
    	
 
	}

	public static boolean AiAtkSelector(User user, Ai ai, int aopc, boolean error, int turno) {
        System.out.println("Turno de " + ai.name);
        System.out.println(ai.name + " está pensando el ataque...");
        Utils.esperar(500);
        aopc = Utils.r.nextInt(4)+1;

        if (ai.robot[0].ep < ai.robot[0].ataque[aopc-1].energy) {
            error = true;
            System.out.println("Al robot rival no le queda energía");
        } else {
            System.out.println(ai.name + " Ha usado " + ai.robot[0].ataque[aopc-1].nombre);
            if (ai.robot[0].ataque[aopc-1].calcularAcierto(ai.robot[0].ataque[aopc-1].acc)) {
                ai.robot[0].ataque[aopc-1].ejecutarAtaque(ai, user, aopc, turno);
                ai.robot[0].ataque[aopc-1].reducirEnergia(ai, user, aopc, turno);
            } else {
                System.out.println("Ha fallado el ataque...");
                user.roboto[0].ataque[aopc - 1].reducirEnergia(ai, user, aopc, turno);
            }
        }
        return error;
    }
	public static boolean UserAtkSelector(User user, Ai ai, int opc, boolean error, int turno) {
        System.out.println("Turno del jugador");

        System.out.println("Tu:   \tEP: "+user.roboto[0].ep+"\tHP: "+ user.roboto[0].hp);
		System.out.println("Rival:\tEP: "+ai.robot[0].ep+"\tHP: "+ ai.robot[0].hp);
		System.out.println("Qué movimiento debe usar " + user.roboto[0].name + "?");
		for (int i = 0; i < user.roboto[0].ataque.length; i++) {
            if (user.roboto[0].ep>user.roboto[0].ataque[i].energy) {
			System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataque[i].nombre); //mostrar ataques del chabon
		    } else {
                System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataque[i].nombre+" (No queda energía)"); //mostrar ataques del chabon

            }
        }
		opc=Trucazo(1,4);
		if (user.roboto[0].ep < user.roboto[0].ataque[opc-1].energy) {
			System.out.println("¡No queda energía restante!"); //si ataca y no tiene energia
			error = true;
		} else {

			System.out.println(user.roboto[0].name + " ha usado " + user.roboto[0].ataque[opc - 1].nombre);
            if (user.roboto[0].ataque[opc-1].calcularAcierto(user.roboto[0].ataque[opc-1].acc)) {
                user.roboto[0].ataque[opc - 1].ejecutarAtaque(ai, user, opc, turno);
                user.roboto[0].ataque[opc - 1].reducirEnergia(ai, user, opc, turno);
            } else {
                System.out.println("Ha fallado el ataque...");
                user.roboto[0].ataque[opc - 1].reducirEnergia(ai, user, opc, turno);

            }

            System.out.println("Al "+ai.robot[0].name + " enemigo le quedan " + ai.robot[0].hp + " puntos de vida!");
		}
		return error;
	}

	
public static int Trucazo(int min, int max) {
		
		int opc=0;
		boolean error = false;
		
		do {
			error = false;
			try {
				opc = sc.nextInt();
				
				if((opc<min)||(opc>max)) {
					System.out.println("Ingrese un numero del " + min + " al " + max);
					error = true;
				}

				sc.nextLine();

			} catch (InputMismatchException e) {
				if (sc.nextLine().equals("moarenergy")) {
					System.out.println("se ha añadido mas energia");
				user.roboto[0].ep+=500;
				}
				System.out.println("Ingrese el tipo de dato correcto");
				error = true;
			}
		}while(error);
		
		return opc;			
}

} //main
