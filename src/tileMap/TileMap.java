package tileMap;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.Assets;
import entidades.Player;
import gameStates.Level1;
import main.Utilidades;

public class TileMap {
	
	private Level1 level1;
	private int width,height,spawnX,spawnY;
	private int[][] tiles;
	private int xOff ;
	
	public TileMap(String path){
		loadMap(path);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g,int xMin) {
		for(int y = 0;y < height; y++)
			for (int x = 0;x < width; x++) {
				if(getTile(x,y) == Tile.casa1Tile)
				getTile(x,y).draw(g,(int) (x*Tile.TILEWIDTH - xMin),
						(int) (y*Tile.TILEHEIGHT - 0), 10);
				else if( getTile(x,y) == Tile.casaTile)
				getTile(x,y).draw(g,(int) (x*Tile.TILEWIDTH - xMin),
							(int) (y*Tile.TILEHEIGHT - 0), 6);
				else if( getTile(x,y) == Tile.empresaTile)
					getTile(x,y).draw(g,(int) (x*Tile.TILEWIDTH - xMin),
								(int) (y*Tile.TILEHEIGHT - 0), 5);
				else
				getTile(x,y).draw(g,(int) (x*Tile.TILEWIDTH - 0),
						(int) (y*Tile.TILEHEIGHT - 0), 1);
			}
				
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];//Chama o array com todos os tiles do jogo
		if(t == null)
			return Tile.nuloTile;
		return t;
	}
	
	public void loadMap(String path) {
		String file = Utilidades.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utilidades.parseInt(tokens[0]);
		height = Utilidades.parseInt(tokens[1]);
		spawnX = Utilidades.parseInt(tokens[2]);
		spawnY = Utilidades.parseInt(tokens[3]);
			
		tiles= new int[width][height];
		for(int y = 0;y < height; y++)
			for (int x = 0;x < width; x++) {
				tiles[x][y] = Utilidades.parseInt(tokens[(x + y * width + 4)]);
			}
	}

	public void setXOff(int xOff) {
		this.xOff = xOff;
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			System.out.println("oi");;
		}
		if(k == KeyEvent.VK_LEFT) {
		}
		}
	
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT){
		}
		if(k == KeyEvent.VK_LEFT) {
		}
	}
}


