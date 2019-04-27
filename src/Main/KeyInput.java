package Main;

import java.awt.event.KeyAdapter;
// keyPressed e keyReleased são funções nativas de keyAdapter
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;//Declara um objeto Handler chamado...handler!
	
	public KeyInput(Handler handler) {//Constructor de KeyInput com um setHandler
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();//Devovlve o número ASCII da tecla pressionada
		for (int i = 0; i<handler.object.size(); i++) {//Lê todos os objetos na tela
			GameObject tempObject = handler.object.get(i);//Instancia um objeto baseado em sua posição na lista
			
			if(tempObject.getId() == ID.Player) {//Se o objeto é um Player, faça:
				if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_S) tempObject.setVelY(5);
				if(key == KeyEvent.VK_D) tempObject.setVelX(5);
				
				if(key == KeyEvent.VK_ESCAPE) System.exit(1);;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i<handler.object.size(); i++) {//Lê todos os objetos na tela
			GameObject tempObject = handler.object.get(i);//Instancia um objeto baseado em sua posição na lista
			
			if(tempObject.getId() == ID.Player) {//Se o objeto é um Player, faça:
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
			}
		}
		
	}
}
