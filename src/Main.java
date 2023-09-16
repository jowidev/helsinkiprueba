import Characters.Ai;
import Characters.User;
import Robots.Robot;
import Robots.StarPlatinum;
import Robots.Titan;
import Utils.Utils;


public class Main {
    public static void main(String[] args) {
        Ai ai = new Ai();
        StarPlatinum starPlatinum = new StarPlatinum();
        Titan titan = new Titan();

        Robot[] robotsDisponibles = {titan, starPlatinum};
        boolean continueBattle = true;
        System.out.println("ingrese su nombre: ");
        String name = Utils.sc.nextLine();
        User user = new User(name);

        System.out.println("Bienvenido, "+user.name);
        System.out.println("Su robot será elegido aleatoriamente.");
        Utils.r.nextInt();
        int randRobot = Utils.r.nextInt(2);

        user.roboto[0] = robotsDisponibles[randRobot]; //no lo he hecho con chatgpt tio
        ai.robot[0] = robotsDisponibles[1 - randRobot]; //bueno un poquito pero no cuenta


        System.out.println("Tu robot: " + user.roboto[0].name);
        System.out.println("robot del rival: " + ai.robot[0].name);

        while ((starPlatinum.isAlive()|| titan.isAlive())&&continueBattle){
            mostrarMenuOpciones(user, continueBattle);
            AttackSelector(user);






        }

    }


    public static boolean mostrarMenuOpciones(User user, boolean continueBattle) {
        System.out.println("1.- Atacar\n"
                            +"2.- Salir");
        int opc = Utils.sc.nextInt();
        switch (opc) {

            case 1:
                AttackSelector(user);
                break;
            case 2:
                continueBattle = false;
                break;
            default:
                System.out.println("Opción no válida");
        }
        return continueBattle;
    }

    public static void AttackSelector(User user) {
        System.out.println("Qué movimiento debe usar " + user.roboto[0].name + "?");
        for (int i = 0; i < 4; i++) {
            System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].ataque[i].nombre);
        }
        Utils.sc.nextInt();
        /*
        System.out.println(talonflame.name + " ha usado " + talonflame.movs[x]);
        talonflame.movs[x].atacar(vaporeon);
        talonflame.movs[x].pp--;
        System.out.println(vaporeon.name+" le quedan "+vaporeon.hp+" puntos de vida!");*/
    }
}