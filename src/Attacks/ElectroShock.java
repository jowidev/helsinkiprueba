package Attacks;

import Characters.Ai;
import Characters.User;
import Robots.StarPlatinum;
import Robots.Titan;

import java.util.Random;

public class ElectroShock extends Ataque {
    public ElectroShock() {
        nombre = "Interferencia Electromagnetica";
        energy = 75;
        dmg = 0;
        acc = 50;

    }

    public int ElectroShockTurns(StarPlatinum starPlatinum, Ai ai, User user, int opc, int turno) { //stun
        Random random = new Random();
        int shockTurns = random.nextInt( 4)+1;
        if (turno==1&& starPlatinum.isShielded) {
            ai.robot[0].ataque[opc].dmg/=2;
            shockTurns--;
        } else
            user.roboto[0].ataque[opc].dmg/=2;
        return shockTurns;
    }
}
