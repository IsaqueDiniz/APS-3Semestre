package entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Entidades{
	
	private BufferedImage image;
	
	public Player(int x, int y, int w, int h,int scale, String s) {
		this.x = x;this.y = y;width = w;height = h;this.scale=scale;
		try {
			image = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
	}

	public void draw(Graphics2D g) {
		width = image.getWidth();
		height = image.getHeight();
		g.drawImage(image, (int)x, (int)y,width*scale,height*scale, null);
		
	}
	
}
