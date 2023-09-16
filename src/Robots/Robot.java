package Robots;
import java.util.Random;

public abstract class Robot {
        public int hp; //vida
        public String name;
        public int ep; //energia
        public int[] movs;
        public boolean isAlive = true;
        public boolean isStunned = false;

        public boolean isAlive() {
                if (hp<=0) {
                        hp=0;
                        isAlive = false;
                }
                return isAlive;
        }
        public void atacar() {

        }

}
