package gameStates;

import tileMap.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends GameState {
	
	
	private Background bg,b1,b2,b3;
	
	private int currentChoice = 0;
	
	private String[] options = {
		"->",
		"->",
		"->"
	};
	
	public Menu(Gerenciador ger) {
		
		this.ger = ger;
		
		try {
			
			bg = new Background("/Background/menuBg.png", 1);
			b1 = new Background("/Menu/startBtn.png", 1);
			b2 = new Background("/Menu/creditosBtn.png", 1);
			b3 = new Background("/Menu/sairBtn.png", 1);
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
		b1.draw(g,20, 0,5);
		b2.draw(g,20, 100,5);
		b3.draw(g,20, 200,5);
		
		// draw title
		
		// draw menu options
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(Color.WHITE);
			}
			else {
				g.setColor(Color.black);
			}
			g.drawString(options[i], 10, 140 + i * 120);
			
		}
		
	}
	
	
	private void select() {
		
		//start
		if(currentChoice == 0) {
			ger.setState(Gerenciador.PREFASE);
		}
		if(currentChoice == 1) {
			ger.setState(Gerenciador.CREDITOS);
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