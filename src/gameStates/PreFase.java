package gameStates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class PreFase extends GameState{
	
	private Background pre1;
	private int tela;
	
	public PreFase(Gerenciador ger) {
		this.ger = ger;

			pre1 = new Background("/Background/menuBg.png", 1);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		if(tela == 1)
		pre1 = new Background("/Background/preFase1.png", 1);
		if(tela == 2)
			ger.setState(ger.LEVEL1);
		
	}

	@Override
	public void draw(Graphics2D g) {
		pre1.draw(g);
		
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			tela += 1;
		}
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}
	
	

}
