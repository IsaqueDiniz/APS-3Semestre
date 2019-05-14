package gameStates;

import main.Janela;
import tileMap.*;
import entidades.Assets;
import entidades.ImageLoader;
import entidades.Player;
import entidades.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Level1 extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	private Prédios p1,p2,p3;
	private Player player;
	private int velX,y,x;
	private SpriteSheet sheet;
	private BufferedImage test;
	
	public Level1(Gerenciador ger) {//Uma vez
		this.ger = ger;
		init();
	}
	
	public void init() {//Uma vez
		
		//test = ImageLoader.loadImage("/Objects/protag4.png");
		//sheet = new SpriteSheet(test);
		Assets.init();
		player = new Player(10,540,32,32,1,"/Objects/protag4.png");
		
		tileMap = new TileMap(30);
		tileMap.setPosition(0, 0);
		
		bg = new Background("/Background/level1Bg.png", 1);
		p1 = new Prédios("/Background/casa1.png");
		p2 = new Prédios("/Background/casa2.png");
		p3 = new Prédios("/Background/casa3.png");
		
	}
	
	
	public void update() {//Loop
		player.update();
		
	}
	
	public void draw(Graphics2D g) {//Loop
		//Prádios e Background
		bg.draw(g);
		p1.draw(g, 600, 216, 64, 64, 6);
		p2.draw(g, 1000, 216, 64, 64, 6);
		p3.draw(g, 1500, 216, 64, 64, 6);
		g.setColor(Color.BLACK);
		g.fillRect(0, 600, 1280, 200);
		
		//Player
		player.draw(g);
		
		
		
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			player.setVelX(16);;
		}
		if(k == KeyEvent.VK_LEFT) {
			player.setVelX(-16);;
		}
		}
	
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			player.setVelX(0);;
		}
		if(k == KeyEvent.VK_LEFT) {
			player.setVelX(0);;
		}
	}
	
}












