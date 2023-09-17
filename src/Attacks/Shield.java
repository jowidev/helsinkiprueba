package Attacks;

import Characters.Ai;
import Characters.User;
import Robots.StarPlatinum;

import java.util.Random;

public class Shield extends Ataque {
    boolean shieldOn = false;

    public Shield() {
        nombre = "Escudo protector";
        energy = 50;
        acc = 40;
        dmg= 0;
    }

    @Override
    public void ejecutarAtaque(Ai ai, User user, int opc, int turno) {
        System.out.println("escudo activado");
    }

    public int shieldTurns(StarPlatinum starPlatinum, Ai ai, User user, int opc, int turno) {
        Random random = new Random();
        int shieldTurns = random.nextInt( 3)+1;
        if (turno==1&&starPlatinum.isShielded) {
            ai.robot[0].ataque[opc].dmg/=2;
            shieldTurns--;
        } else
            user.roboto[0].ataque[opc].dmg/=2;
        return shieldTurns;

    }
}
