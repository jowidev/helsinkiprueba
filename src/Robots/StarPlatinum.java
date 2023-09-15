package Robots;

import Attacks.*;

public class StarPlatinum extends Robot {
    public StarPlatinum() {
        hp = 1200;
        ep = 1000;
        Ataque[] Movs = new Ataque[4];
        Movs[0] = new Metralleta();
        Movs[1] = new Acid();
        Movs[2] = new Fuego();
        Movs[3] = new Shield();
    }
}
