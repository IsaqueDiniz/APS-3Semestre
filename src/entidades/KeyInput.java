package entidades;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyInput implements KeyListener{
	
	private boolean []keys;
	public boolean esq,dir;

	public KeyInput(Player player) {
		keys = new boolean[256];
	}
	
	public void update() {
		dir = keys[KeyEvent.VK_D];
		esq = keys[KeyEvent.VK_A];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
