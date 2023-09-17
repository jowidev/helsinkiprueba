package Robots;
import java.util.Random;

import Attacks.Ataque;
import Attacks.Tipos;


public abstract class Robot {
        public int hp; //vida
        public String name;
        public Tipos tipo;
        public int ep; //energia
        public Ataque[] ataque = new Ataque[4];
        public boolean isAlive = true;
        public Estado estado = Estado.NINGUNO;
        public boolean efectoSecundario = false;
        public int turnos = 0;
        
        public boolean isAlive() {
                if (hp<=0) {
                        hp=0;
                        isAlive = false;
                }
                return isAlive;
        }
        
        public void restarTurnos() {
    		this.turnos--;
    		if(this.turnos==0) {
    			this.efectoSecundario = false;
    			this.estado = Estado.NINGUNO;
    		}
    	}

}
