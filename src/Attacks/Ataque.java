package Attacks;

import java.util.Random;

import Characters.Ai;
import Characters.User;



public abstract class Ataque {
    public String nombre;
    public int energy; //energy consumption
    public int dmg;
    public int acc; //accuracy

    public boolean calcularAcierto(int acc) {
        Random random = new Random();
        int randomm = random.nextInt();
        if (randomm <= acc) {
            return true;
        } else {
            return false;
        }
    }

    public void ejecutarAtaque(Ai ai, User user,int turno) {
    	
    }
}
