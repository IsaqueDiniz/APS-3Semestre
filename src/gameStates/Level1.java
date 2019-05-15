package gameStates;

import main.Janela;
import tileMap.*;
import entidades.Assets;
import entidades.ImageLoader;
import entidades.Lixo;
import entidades.Player;
import entidades.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Level1 extends GameState {
	
	private Background bg;
	private TileMap tm;
	private Player player;
	private int mSegundos,segundos,minutos;
	private float off;
	private Handler handler;
	
	public Level1(Gerenciador ger) {//Uma vez
		this.ger = ger;
		init();
		
	}
	
	public void init() {//Uma vez
		
		
		//test = ImageLoader.loadImage("/Objects/protag4.png");
		//sheet = new SpriteSheet(test);
		Assets.init();
		
		player = new Player(10,580,32,32,1);
		handler = new Handler();
		handler.addObject(new Lixo(1,60,580));
		handler.addObject(new Lixo(2,120,580));
		handler.addObject(new Lixo(3,180,580));
		
		
		
		tm = new TileMap("Resources/Mapas/level1.txt");
		bg = new Background("/Background/level1Bg.png", 1);
		/*p1 = new Prédios("/Background/casa1.png");
		p2 = new Prédios("/Background/casa2.png");
		p3 = new Prédios("/Background/casa3.png");*/
		
	}
	
	
	public void update() {//Loop
		this.mSegundos++;
		if(this.mSegundos == 60) {
			this.mSegundos = 0;
			this.segundos++;
		}
		if(this.segundos == 60) {
			this.segundos = 0;
			this.minutos++;
		}
		tm.update();
		player.update();
		//handler.update();
		
	}
	
	public void draw(Graphics2D g) {//Loop
		off = player.getx();
		//Background
		bg.draw(g);
		
		//Chão
		/*g.setColor(Color.BLACK);
		g.fillRect(0, 600, 1280, 200);*/
		
		tm.draw(g,(int)player.getx());
		
		
		//Player
		player.draw(g,0);
		
		handler.draw(g, off);
		
		
		
		/*p1.draw(g, 600, 216, 64, 64, 6);
		p2.draw(g, 1000, 216, 64, 64, 6);
		p3.draw(g, 1500, 216, 64, 64, 6);*/
		
		//g.drawImage(Assets.building1, x, y,256,256, null);
		g.setColor(Color.WHITE);
		
		g.drawString("Preciso ir trabalhar, ir ao restaurante e voltar para casa", 20 - player.getx(), 440);
		
		g.drawString("Tempo: " + this.minutos + ":" + this.segundos+":"+ this.mSegundos,590,25);
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			player.setVelX(20);
			//bg.setPosition(x, 0);
		}
		if(k == KeyEvent.VK_LEFT) {
			player.setVelX(-20);
			//bg.setPosition(x, 0);
		}
		if(k == KeyEvent.VK_E) {
			player.setEvento(1);
			System.out.println(player.getx());
			
			if(player.getx() < 30)
				ger.setState(Gerenciador.RESULTADO);
		}
		}
	
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_RIGHT) {
			player.setVelX(0);
		}
		if(k == KeyEvent.VK_LEFT) {
			player.setVelX(0);
		}
		if(k == KeyEvent.VK_E) {
			player.setEvento(0);
		}
	}
	
}












