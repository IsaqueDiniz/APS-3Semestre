package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		x = MainStage.clamp(x,0,MainStage.WIDTH-37);
		y = MainStage.clamp(y,0,MainStage.HEIGHT-60);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	

}
