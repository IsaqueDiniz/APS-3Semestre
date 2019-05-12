package tileMap;

import java.awt.image.BufferedImage;

public class Tile {
	
	private BufferedImage image;
	private int tipo;
	
	// tile types
	public static final int NORMAL = 0;
	public static final int BLOCKED = 1;
	
	public Tile(BufferedImage image, int tipo) {
		this.image = image;
		this.tipo = tipo;
	}
	
	public BufferedImage getImage() { return image; }
	public int getType() { return tipo; }
	
}