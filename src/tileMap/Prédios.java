package tileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.Janela;

public class Prédios {
	
	private BufferedImage image;
	
	public Prédios(String s){
		try {
			image = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g, int x, int y, int w, int h, int s) {
		w = image.getWidth();
		h = image.getHeight();
		g.drawImage(image, x, y, w*s, h*s, null);
	}

}
