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
        return(random.nextInt(101) <= acc)?true:false;
    }

    public void reducirEnergia(Ai ai, User user, int opc, int turno) {
        if (turno==1) { //idk why esto funciona con un 1 pero el ejecutar ataque con 0
            ai.robot[0].ep -= ai.robot[0].ataque[opc-1].energy;
        } else {
            user.roboto[0].ep -= user.roboto[0].ataque[opc - 1].energy; //LO TENEMOS TIO
        }
    }

    public void ejecutarAtaque(Ai ai, User user,int opc, int turno) {
        if (turno==0) {
            ai.robot[0].hp -= user.roboto[0].ataque[opc - 1].dmg;
        } else {
            user.roboto[0].hp -= ai.robot[0].ataque[opc-1].dmg;
        }
    }
}
