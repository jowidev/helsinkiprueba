package Attacks;

import Robots.Robot;
import Robots.StarPlatinum;

import java.util.Random;

public class Shield extends Ataque {
    boolean shieldOn = false;

    public Shield() {
        energy = 50;
        acc = 40;
        dmg= 0;
    }

    public int shieldTurns() {
        Random random = new Random();
        int shieldTurns = random.nextInt(3);
        //dmg = dmg /2;
        shieldTurns--;
        return shieldTurns;
    }
}
