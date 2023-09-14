package Robots;

import Attacks.Acid;
import Attacks.Ataque;
import Attacks.Fuego;
import Attacks.Metralleta;

import java.util.Random;

public class Titan extends Robot {
    public int Titan() {
        hp = 1000;
        ep = 1500;
        Ataque[] Movs = new Ataque[4];
        Movs[0] = new Metralleta();
        Movs[1] = new Acid();
        Movs[2] = new Fuego();


    }
}
