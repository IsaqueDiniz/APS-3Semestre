package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MenuState {
	
	private Font font;
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Help",
		"Quit"
	};
	private MainStage main;
	private Handler handler;
	
	public MenuState(){
		
	}
	
	public void render(Graphics g) {
			g.setFont(font);
			for(int i = 0; i < options.length; i++) {
				if(i == currentChoice) {
					g.setColor(Color.GRAY);
				}
				else {
					g.setColor(Color.RED);
				}
				g.drawString(options[i], 145, 140 + i * 15);
			}
			
		}
		
		public void tick() {
			if(currentChoice == 0) {
				
			}
			if(currentChoice == 1) {
				// help
			}
			if(currentChoice == 2) {
				System.exit(0);
			}
		}
		
		
		
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();//Devovlve o número ASCII da tecla pressionada
			if(key == KeyEvent.VK_ENTER){
			}
			if(key == KeyEvent.VK_UP) {
				currentChoice--;
				if(currentChoice == -1) {
					currentChoice = options.length - 1;
				}
			}
			if(key == KeyEvent.VK_DOWN) {
				currentChoice++;
				if(currentChoice == options.length) {
					currentChoice = 0;
				}
			}
		}
		public void keyReleased(int k) {}

		public int getCurrentChoice() {
			return currentChoice;
		}

		public void setCurrentChoice(int currentChoice) {
			this.currentChoice = currentChoice;
		}
		
		
		
	}
	


