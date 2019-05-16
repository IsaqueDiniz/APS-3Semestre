package gameStates;

import tileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends GameState {
	
	
	private Background bg;
	
	private int currentChoice = 0;
	
	private String[] options = {
		"Start",
		"Créditos",
		"Sair"
	};
	
	public Menu(Gerenciador ger) {
		
		this.ger = ger;
		
		try {
			
			bg = new Background("/Background/menuBg.png", 1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {
		
	}
	
	public void update() {
		
		
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw title
		
		// draw menu options
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.WHITE);
			}
			else {
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 145, 140 + i * 15);
		}
		
	}
	
	
	private void select() {
		
		//start
		if(currentChoice == 0) {
			ger.setState(Gerenciador.LEVEL1);
		}
		if(currentChoice == 1) {
			ger.setState(Gerenciador.OPCOES);
		}
		if(currentChoice == 2) {
			System.exit(0);
		}
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
		
	}
	public void keyReleased(int k) {}
	
}