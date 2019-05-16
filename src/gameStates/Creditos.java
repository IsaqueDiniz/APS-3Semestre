package gameStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class Creditos extends GameState{
	
	public Background creditos;
	
	public Creditos(Gerenciador ger) {
		this.ger = ger;
		
		try {
			
			creditos = new Background("/Background/creditos.png", 1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		creditos.draw(g);
		
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER)
			ger.setState(ger.MENU);
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}
