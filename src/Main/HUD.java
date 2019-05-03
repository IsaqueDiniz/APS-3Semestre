package Main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	
	private long gameTimer = 0;
	private int tempo = 100;
	private int level = 1;
	
	public void tick() {
		gameTimer ++;
	}
	
	public void render (Graphics g) {
		
		g.drawString("Tempo: " +(tempo-1),590,25);
		g.drawString("Level: " + level, 590, 45);
		
	}
	
	public void setGameTimer (long gameTimer) {
		this.gameTimer = gameTimer;
	}
	
	public long getGameTimer() {
		return gameTimer;
	}

}
