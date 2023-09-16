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
        if (randRobot==0) {
            ai.robot[0] = robotsDisponibles[1];
        } else {
            ai.robot[0] = robotsDisponibles[0];
        }

        System.out.println("Tu robot: " + user.robot[0].name);
        System.out.println("robot del rival: " + ai.robot[0].name);

        while ((starPlatinum.isAlive()|| titan.isAlive())&&continueBattle){
            //mostrarMenuOpciones();
            AttackSelector(user);






        }

    }


    /*public static void mostrarMenuOpciones() {
        System.out.println("1.- Ver estadisticas\n"
                            +"2.- Atacar\n"
                            +"3.- Salir");
        Utils.sc.nextInt();
    }*/

    public static void AttackSelector(User user) {
        System.out.println("Qué movimiento debe usar " + user.robot[0].name + "?");
        for (int i = 0; i < user.roboto[0].movs.length; i++) {
            System.out.println("ataque " + (i + 1) + ": " + user.roboto[0].movs[i]);
        }
        Utils.sc.nextInt();
        /*
        System.out.println(talonflame.name + " ha usado " + talonflame.movs[x]);
        talonflame.movs[x].atacar(vaporeon);
        talonflame.movs[x].pp--;
        System.out.println(vaporeon.name+" le quedan "+vaporeon.hp+" puntos de vida!");*/
    }
}