package gameStates;

import main.Janela;
import tileMap.*;

import java.awt.*;

public class Level1 extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	
	public Level1(Gerenciador ger) {
		this.ger = ger;
		init();
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tiles/grasstileset.gif");
		tileMap.loadMap("/Mapas/level1-1.map");
		tileMap.setPosition(0, 0);
		
		bg = new Background("/Background/level1Bg.png", 1);
		
	}
	
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		bg.draw(g);
		
		// draw tilemap
		tileMap.draw(g);
		
	}
	
	public void keyPressed(int k) {}
	
	public void keyReleased(int k) {}
	
}












