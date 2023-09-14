package Attacks;

import java.util.Random;

public class electroShock extends Ataque {
    public electroShock() {
        nombre = "Interferencia Electromagnetica";
        energy = 75;
        dmg = 0;
        acc = 50;

    }

    public int ElectroShockTurns() {
        Random random = new Random();
        int ShockTurns = random.nextInt(3);
        //dmg = dmg /2;
        ShockTurns--;
        return ShockTurns;
    }
}
