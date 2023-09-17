package Attacks;

import Characters.Ai;
import Characters.User;
import Robots.StarPlatinum;

import java.util.Random;

public class Escudo extends Ataque {
    boolean shieldOn = false;

    public Escudo() {
		super("Escudo protector", 50 , 0, 40, Tipos.EFECTO);
	}


    public int shieldTurns(StarPlatinum starPlatinum, Ai ai, User user, int opc, int turno) {
        Random random = new Random();
        int shieldTurns = random.nextInt( 3)+1;
        if (turno==0&&starPlatinum.isShielded) {
            ai.robot[0].ataque[opc].dmg/=2;
            shieldTurns--;
        } else
            user.roboto[0].ataque[opc].dmg/=2;
        	shieldTurns--;
        	
        return shieldTurns;

    }
}
