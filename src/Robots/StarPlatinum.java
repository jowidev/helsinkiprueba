package Robots;

import Attacks.Acid;
import Attacks.Ataque;
import Attacks.Fuego;
import Attacks.Metralleta;

public class StarPlatinum extends Robot {
    public StarPlatinum() {
        hp = 1200;
        ep = 1000;
        Ataque[] Movs = new Ataque[4];
        Movs[0] = new Metralleta();
        Movs[1] = new Acid();
        Movs[2] = new Fuego();

    }
}
