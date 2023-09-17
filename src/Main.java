import Characters.Ai;
import Characters.User;
import Robots.Robot;
import Robots.StarPlatinum;
import Robots.Titan;
import Utils.Utils;

import javax.print.attribute.ResolutionSyntax;


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
        ai.robot[0] = robotsDisponibles[1-randRobot];
        Utils.esperar(1000);
        System.out.println("Tu robot: " + user.roboto[0].name);
        System.out.println("robot del rival: " + ai.robot[0].name);

        System.out.println("Tirando moneda...");
		Utils.esperar(1000);
		System.out.println("Empieza " + ((turno==0)?user.name:ai.name));


        do {

			 if(turno==0) {
					System.out.println("Turno del jugador");
				
					boolean error = false;
					do {
						error = false;
						int opc = 0;
						UserAtkSelector(user, ai, opc, error, turno);

					} while(error);
				}  //el chabon que ataca

			 else { //el bot que ataca
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
								ai.robot[0].ataque[0].ejecutarAtaque(ai, user, opc, turno);
							}
							break;
						case 2:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[1].ejecutarAtaque(ai, user, opc, turno);
							}
							break;
						case 3:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[2].ejecutarAtaque(ai, user, opc, turno);
							}
							break;
						case 4:
							if(ai.robot[0].ep==0) {
								error = true;
							} else {
								ai.robot[0].ataque[3].ejecutarAtaque(ai, user, opc, turno);
							}
							break;
						}
					} while(error);
			 }
			if (!titan.isAlive()||!starPlatinum.isAlive()) {
				System.out.println("ha finalizado la pelea");
				continueBattle = false;
			}

			turno = (turno==0)?1:0;
		        
		}while(starPlatinum.isAlive()|| titan.isAlive()&&continueBattle);



	} //public static main string args
	public static boolean UserAtkSelector(User user, Ai ai, int opc, boolean error, int turno) {
		System.out.println("User\tEP: "+user.roboto[0].ep+"\tHP: "+ user.roboto[0].hp);
		System.out.println("Rival\tEP: "+ai.robot[0].ep+"\tHP: "+ ai.robot[0].hp);
		System.out.println("Qué movimiento debe usar " + user.roboto[0].name + "?");
		for (int i = 0; i < user.roboto[0].ataque.length; i++) {
			System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataque[i].nombre); //mostrar ataques del chabon
		}
		opc= Utils.ingresarEntero(1,4,Utils.sc);
		if (user.roboto[0].ep < user.roboto[0].ataque[opc-1].energy) {
			System.out.println("¡No queda energía restante!"); //si ataca y no tiene energia
			error = true;
		} else {

			System.out.println(user.roboto[0].name + " ha usado " + user.roboto[0].ataque[opc - 1].nombre);
			user.roboto[0].ataque[opc - 1].ejecutarAtaque(ai, user, opc, turno);
			user.roboto[0].ep -= user.roboto[0].ataque[opc-1].energy; //LO TENEMOS TIO NO HEMOS USADO CHATGPT TIO

			System.out.println(ai.robot[0].name + " le quedan " + ai.robot[0].hp + " puntos de vida!");
		}
		return error;
	}

} //main
