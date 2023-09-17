package Robots;

import Attacks.*;

public class Titan extends Robot {
	
	public boolean efectosecundario = false;
	
    public Titan() {
        name = "EVA-01";
        hp = 1000;
        ep = 1500;
        ataque = new Ataque[4];
        ataque[0] = new Metralleta();
        ataque[1] = new Acid();
        ataque[2] = new Fuego();
        ataque[3] = new Escudo();
    }
}
