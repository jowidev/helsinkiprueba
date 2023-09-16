package Robots;

import Attacks.*;

public class StarPlatinum extends Robot {
    public StarPlatinum() {
        name = "Star Platinum";
        hp = 1200;
        ep = 1000;
        ataques = new Ataque[4];
        ataques[0] = new Metralleta();
        ataques[1] = new Acid();
        ataques[2] = new Fuego();
        ataques[3] = new Shield();
        //Ataque[] Movs = {Metralleta, Acid, Fuego, Shield}
    }
}
