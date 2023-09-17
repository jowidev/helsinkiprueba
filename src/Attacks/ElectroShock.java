package Attacks;

import Characters.Ai;
import Characters.User;
import Robots.StarPlatinum;
import Robots.Titan;

import java.util.Random;

public class ElectroShock extends Ataque {
  

    public ElectroShock() {
		super("Interferencia Electromagnetica", 75 , 0, 50, Tipos.EFECTO);
	}

	

    public int ElectroShockTurns(StarPlatinum starplatinum, Ai ai, User user, int opc, int turno) {
        Random random = new Random();
        int shockTurns = random.nextInt( 4)+1;
        if (turno==0&&starplatinum.isStunned) {
            ai.robot[0].ataque[opc].dmg/=2;
            shockTurns--;
        } else
            user.roboto[0].ataque[opc].dmg/=2;
        return shockTurns;
    }	
}
