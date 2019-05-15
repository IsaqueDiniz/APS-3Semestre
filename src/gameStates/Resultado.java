package gameStates;

import java.awt.Color;
import java.awt.Graphics2D;

import entidades.Player;

public class Resultado extends GameState{
	
	private Player player;
	
	public Resultado(Gerenciador ger){
		this.ger = ger;
		player = new Player(0, 0, 0, 0, 0);
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setColor(Color.WHITE);
		if(player.getPontos() < 50)
		g.drawString("Final:Vizinhança completamente poluída", 540, 380);
		else if(player.getPontos() < 100)
		g.drawString("Final:Vizinhança parcialmente poluída", 540, 380);
		else
		g.drawString("Final:Vizinhança completamente limpa", 540, 380);
		
	}

	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
