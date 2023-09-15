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

        System.out.println("ingrese su nombre: ");
        String name = Utils.sc.nextLine();
        User user = new User(name); //llamar user es un quilombo esto





        System.out.println("Bienvenido, "+user.name);
        System.out.println("Su robot será elegido aleatoriamente.");
        Utils.r.nextInt();
        int userRobotIndex = Utils.r.nextInt(2);

        user.Roblox[0] = robotsDisponibles[userRobotIndex]; //no lo he hecho con chatgpt tio
        if (userRobotIndex==0) {
            ai.Roblox[0] = robotsDisponibles[1];
        } else {
            ai.Roblox[0] = robotsDisponibles[0];
        }
        System.out.println("Tu robot: " + user.Roblox[0].name);
        System.out.println("robot del rival: " + ai.Roblox[0].name);

        while (1==1){
            mostrarMenuOpciones();
            AttackSelector();



        }

    }


    public static void mostrarMenuOpciones() {
        System.out.println("1.- Ver estadisticas\n"
                            +"2.- Atacar\n"
                            +"3.- Salir");
        Utils.sc.nextInt();
    }

    public static void AttackSelector() {
        System.out.println("¿Qué ataque desea realizar?"
                +"3.- Salir");
        Utils.sc.nextInt();
    }
}