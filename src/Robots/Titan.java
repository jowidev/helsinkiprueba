package Robots;

import Attacks.*;

public class Titan extends Robot {
    public Titan() {
        hp = 1000;
        ep = 1500;
        Ataque[] Movs = new Ataque[4];
        Movs[0] = new Metralleta();
        Movs[1] = new Acid();
        Movs[2] = new Fuego();
        Movs[3] = new ElectroShock();
    }
}
