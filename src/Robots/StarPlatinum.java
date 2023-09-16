package Robots;

import Attacks.*;

public class StarPlatinum extends Robot {
    public StarPlatinum() {
        name = "Star Platinum";
        hp = 1200;
        ep = 1000;
        Ataque[] movs = new Ataque[4];
        movs[0] = new Metralleta();
        movs[1] = new Acid();
        movs[2] = new Fuego();
        movs[3] = new Shield();
        //Ataque[] Movs = {Metralleta, Acid, Fuego, Shield}
    }
}
