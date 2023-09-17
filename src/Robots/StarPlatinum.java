package Robots;

import Attacks.*;

public class StarPlatinum extends Robot {

    public boolean isShielded = false;
    public StarPlatinum() {
        name = "Star Platinum";
        hp = 1200;
        ep = 1000; //energy points
        ataque = new Ataque[4];
        ataque[0] = new Metralleta();
        ataque[1] = new Acid();
        ataque[2] = new Fuego();
        ataque[3] = new Shield();
    }

}
