package gameStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import entidades.Player;

public class Resultado extends GameState{
	private Player player;
	private int p;
	
	public Resultado(Gerenciador ger, int p){
		this.ger = ger;
		player = new Player(0, 0, 0);
		this.p = p;
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
		g.drawString("Pontuação: " + p, 370, 200);
		if(p < 30)
		g.drawString("Vizinhança completamente poluída", 320, 280);
		else if(p < 80)
		g.drawString("Vizinhança parcialmente poluída", 320, 280);
		else
		g.drawString("Vizinhança completamente limpa", 320, 280);
		
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER)
			ger.setState(Gerenciador.MENU);
		
	}

	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
