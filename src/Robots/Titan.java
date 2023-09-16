package Robots;

import Attacks.*;

public class Titan extends Robot {
    public Titan() {
        name = "EVA-01";
        hp = 1000;
        ep = 1500;
        Ataque[] movs = new Ataque[4];
        movs[0] = new Metralleta();
        movs[1] = new Acid();
        movs[2] = new Fuego();
        movs[3] = new ElectroShock();
    }
}
