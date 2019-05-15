package tileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile nuloTile = new NuloTile(0);
	public static Tile groundTile = new GroundTile(1);
	public static Tile casa1Tile = new Prédios(2);
	
	
	public static final int TILEWIDTH=64, TILEHEIGHT=64;
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;//This refere-se á esta classe(à Tiles)
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g, int x, int y,int scale) {
		g.drawImage(texture,x,y,TILEWIDTH*scale,TILEHEIGHT*scale,null);
	}

	public int getId() { return id; }
	
}