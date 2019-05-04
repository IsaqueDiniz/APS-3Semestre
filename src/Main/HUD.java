package Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

public class HUD {
	
	public static int HEALTH = 100;
	
	private int mSegundos = 0;
	private int segundos = 0;
	private int minutos = 0;

	private long gameTimer = 0;
	private int tempo = 100;
	private int level = 0;
	
	public void tick() {
		this.mSegundos++;
				if(this.mSegundos == 60) {
					this.mSegundos = 0;
					this.segundos++;
				}
				if(this.segundos == 60) {
					this.segundos = 0;
					this.minutos++;
				}
				if(this.segundos == 5.0)
					this.level++;
				
				
	}
	
	public void render (Graphics g) {
		
		
		g.drawString("Tempo: " + this.minutos + ":" + this.segundos+":"+ this.mSegundos,590,25);
		g.drawString("Level: " + this.level, 590, 45);
		
	}
	
	public void setSegundos (int segundos) {
		this.segundos = segundos;
	}
	
	public int getSegundos() {
		return segundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public int getLevel(){
		return level;
	}

	public void setLevel(int level){
		this.level = level;
	}




}
