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
        public Estado estado;
        
        
        public boolean isAlive() {
                if (hp<=0) {
                        hp=0;
                        isAlive = false;
                }
                return isAlive;
        }
        

}
