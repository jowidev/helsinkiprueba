package Attacks;

import java.util.Random;

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


}
