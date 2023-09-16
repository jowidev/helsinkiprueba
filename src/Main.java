import Characters.Ai;
import Characters.User;
import Robots.Robot;
import Robots.StarPlatinum;
import Robots.Titan;
import Utils.Utils;
import jdk.jshell.execution.Util;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Ai ai = new Ai();
        StarPlatinum starPlatinum = new StarPlatinum();
        Titan titan = new Titan();
        int turno = Utils.r.nextInt(2);
        Robot[] robotsDisponibles = {titan, starPlatinum};
        boolean continueBattle = true;
        System.out.println("ingrese su nombre: ");
        String name = Utils.sc.nextLine();
        User user = new User(name);

        System.out.println("Bienvenido, "+user.name);
        System.out.println("Su robot será elegido aleatoriamente.");
        Utils.r.nextInt();
        int randRobot = Utils.r.nextInt(2);

        user.roboto	[0] = robotsDisponibles[randRobot]; //no lo he hecho con chatgpt tio
        if (randRobot==0) {
            ai.robot[0] = robotsDisponibles[1];
        } else {
            ai.robot[0] = robotsDisponibles[0];
        }

        System.out.println("Tu robot: " + user.roboto[0].name);
        System.out.println("robot del rival: " + ai.robot[0].name);

        System.out.println("Tirando moneda");
		Utils.esperar(1000);
		System.out.println("Empieza " + ((turno==0)?user.name:ai.name));
        
		
		 do {
			 
			 if(turno==0) {
					System.out.println("Turno del jugador");
				
					boolean error = false;
					do {
						error = false;
						
						System.out.println("Qué movimiento debe usar " + user.roboto[0].name + "?");
						for (int i = 0; i < user.roboto[0].ataque.length; i++) {
						    System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataque[i].nombre);
						}
						int opc = Utils.ingresarEntero(1,4, Utils.sc);
						switch(opc) {
						case 1:
							if(user.roboto[0].ep == 0) {
								error = true;
								System.out.println("No puede utilizar este ataque ya que no tiene mas usos disponible");
							} else {
								user.roboto[0].ataque[0].ejecutarAtaque(ai, user, turno);
							} 
							break;
						case 2:
							if(user.roboto[0].ep == 0) {
								error = true;
								System.out.println("No puede utilizar este ataque ya que no tiene mas usos disponible");
							} else {
								user.roboto[0].ataque[1].ejecutarAtaque(ai, user, turno);
							} 
							break;
						case 3:
							if(user.roboto[0].ep == 0) {
								error = true;
								System.out.println("No puede utilizar este ataque ya que no tiene mas usos disponible");
							} else {
								user.roboto[0].ataque[2].ejecutarAtaque(ai, user, turno);
							} 
							break;
						case 4:
							if(user.roboto[0].ep == 0) {
								error = true;
								System.out.println("No puede utilizar este ataque ya que no tiene mas usos disponible");
							} else {
								user.roboto[0].ataque[3].ejecutarAtaque(ai, user, turno);
							} 
							break;
						}
					} while(error);
				} else {
					System.out.println("Turno de " + ai.name);
					
					System.out.println(ai.name + " esta pensando el ataque");
					Utils.esperar(2000);
					boolean error = false;
					do {
						error = false;
						int opc = Utils.r.nextInt(1)+1;
						switch(opc) {
						case 1:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[0].ejecutarAtaque(ai, user, turno);
							}
							break;
						case 2:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[1].ejecutarAtaque(ai, user, turno);
							}
							break;
						case 3:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[2].ejecutarAtaque(ai, user, turno);
							}
							break;
						case 4:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[3].ejecutarAtaque(ai, user, turno);
							}
							break;
						}
					} while(error);
				}
				
				turno = (turno==0)?1:0;
		        
	        }while(starPlatinum.isAlive()|| titan.isAlive()&&continueBattle);
	        
		 
		
//       while ((starPlatinum.isAlive()|| titan.isAlive())&&continueBattle){
//            mostrarMenuOpciones();
//            AttackSelector(user);
//        }

       


    /*public static void mostrarMenuOpciones() {
        System.out.println("1.- Ver estadisticas\n"
                            +"2.- Atacar\n"
                            +"3.- Salir");
        Utils.sc.nextInt();
    }*/

    /*public static void AttackSelector(User user) {
        System.out.println("Qué movimiento debe usar " + user.roboto[0].name + "?");
        for (int i = 0; i < user.roboto[0].ataques.length; i++) {
            System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataques[i].nombre);
        }
        Utils.sc.nextInt();
        /*
        System.out.println(talonflame.name + " ha usado " + talonflame.movs[x]);
        talonflame.movs[x].atacar(vaporeon);
        talonflame.movs[x].pp--;
        System.out.println(vaporeon.name+" le quedan "+vaporeon.hp+" puntos de vida!");*/
    }
}
