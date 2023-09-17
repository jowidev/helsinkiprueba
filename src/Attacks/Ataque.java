package Attacks;

import java.util.Random;

import Characters.Ai;
import Characters.User;
import Robots.Estado;
import Utils.Utils;




public abstract class Ataque {
    public String nombre;
    public int energy; 
	public int turnosMin = 0; 
	public int turnosMax =0;
    public int dmg;
    public int acc; 
    public Tipos Tipo;
    public  boolean efectoSecundario;

    public Ataque(String nombre, int energy, int dmg, int acc, Tipos tipo) {
		this.nombre = nombre;
		this.energy = energy;
		this.dmg = dmg;
		this.acc = acc;
		this.Tipo = tipo;
	}

    public Ataque(String nombre, int energy, int dmg, int acc, Tipos tipo, boolean efectoSecundario,  int turnosMin, int turnosMax) {
		this.nombre = nombre;
		this.energy = energy;
		this.dmg = dmg;
		this.acc = acc;
		this.Tipo = tipo;
		this.efectoSecundario = efectoSecundario;
		this.turnosMin = turnosMin;
		this.turnosMax = turnosMax;
	}
    
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
        	
        	if(user.roboto[0].ataque[opc-1].efectoSecundario) {
				
				if(user.roboto[0].ataque[opc-1].turnosMax>0) {
					ai.robot[0].efectoSecundario = true;
					ai.robot[0].estado = Estado.INABILITADO;
					ai.robot[0].turnos = Utils.r.nextInt(user.roboto[0].ataque[opc-1].turnosMin, user.roboto[0].ataque[opc-1].turnosMax);
				}
		
				switch(user.roboto[0].ataque[opc-1].nombre) {
				case "Interferencia Electromagnetica":
					System.out.println(" y ahora " +ai.robot[0].name + " no podra atacar por " + ai.robot[0].turnos + " turnos");
					break;
				
				}
				
        } else {
        	
        	float mult = calcularEfectividad(this.Tipo, ai, user);
			if(mult==2) {
				System.out.println("El ataque es super efectivo");
			} else if(mult==0.5f) {
				System.out.println("El ataque es poco efectivo");
			}
			
            user.roboto[0].hp -= ai.robot[0].ataque[opc-1].dmg*mult;
        }
        
    } else {
		float mult = calcularEfectividad(this.Tipo, ai, user);
		if(mult==2) {
			System.out.println("El ataque es super efectivo");
		} else if(mult==0.5f) {
			System.out.println("El ataque es poco efectivo");
		}
		
    ai.robot[0].hp -= user.roboto[0].ataque[opc - 1].dmg*mult;
		}
    }
    
    
	private float calcularEfectividad(Tipos tipo, Ai ai, User user) {
		
	float mult = 1;
		
		switch(tipo) {
			case FUEGO:
				if(ai.robot[0].name == "Star Platinum" || user.robot[0].name == "Star Platinum" ) {
					mult = 2;
				} else if(ai.robot[0].name == "EVA-01" || user.robot[0].name == "EVA-01") {
					mult = 0.5f;
				}
			break;
			case IMPACTO:
				if(ai.robot[0].name == "Star Platinum" || user.robot[0].name == "Star Platinum") {
					mult = 2;
				} else if(ai.robot[0].name == "EVA-01" || user.robot[0].name == "EVA-01") {
					mult = 0.5f;
				}
			break;
			case CORROSION:
				if(ai.robot[0].name == "EVA-01" || user.robot[0].name == "EVA-01") {
					mult = 2;
				} else if(ai.robot[0].name == "Star Platinum" || user.robot[0].name == "Star Platinum") {
					mult = 0.5f;
				}
			break;
		}
		return mult;
    }
	
	
	
	
}
