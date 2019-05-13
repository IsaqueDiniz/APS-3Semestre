package gameStates;

import main.Janela;
import tileMap.*;
import entidades.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1 extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	private Prédios p1,p2,p3;
	private Player player;
	private int velX,y;
	
	public Level1(Gerenciador ger) {
		this.ger = ger;
		init();
	}
	
	public void init() {
		
		
		
		player = new Player(10,540,32,32,1,"/Objects/protag.png");
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/Tiles/grasstileset.gif");
		tileMap.loadMap("/Mapas/level1-1.map");
		tileMap.setPosition(0, 0);
		
		bg = new Background("/Background/level1Bg.png", 1);
		p1 = new Prédios("/Background/casa1.png");
		p2 = new Prédios("/Background/casa2.png");
		p3 = new Prédios("/Background/casa3.png");
		
	}
	
	
	public void update() {
		player.setVector(velX);
	}
	
	public void draw(Graphics2D g) {
		
		bg.draw(g);
		p1.draw(g, 600, 216, 64, 64, 6);
		p2.draw(g, 1000, 216, 64, 64, 6);
		p3.draw(g, 1500, 216, 64, 64, 6);
		
		player.draw(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 600, 1280, 200);
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			velX = 16;
		}
		if(k == KeyEvent.VK_LEFT) {
			velX = -16;
		}
		}
	
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			velX = 0;
		}
		if(k == KeyEvent.VK_LEFT) {
			velX = 0;
		}
	}
	
}












