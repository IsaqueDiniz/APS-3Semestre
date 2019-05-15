package gameStates;

import tileMap.*;
import entidades.Assets;
import entidades.KeyInput;
import entidades.Lixo;
import entidades.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Level1 extends GameState {
	
	private Background bg,pbg;
	private TileMap tm;
	private Player player;
	private int mSegundos,segundos,minutos,p,status;
	private float off;
	private Handler handler;
	private KeyInput keyInput;
	
		public Level1(Gerenciador ger) {//Uma vez
		this.ger = ger;
		init();
		
	}
	
	public void init() {//Uma vez
		
		
		//test = ImageLoader.loadImage("/Objects/protag4.png");
		//sheet = new SpriteSheet(test);
		Assets.init();
		
		
		player = new Player(10,450,1);
		handler = new Handler();
		
		handler.addObject(new Lixo(1,230,450));
		handler.addObject(new Lixo(2,410,450));
		handler.addObject(new Lixo(3,530,450));
		handler.addObject(new Lixo(1,650,450));
		handler.addObject(new Lixo(3,790,450));
		handler.addObject(new Lixo(3,930,450));
		handler.addObject(new Lixo(2,1150,450));
		handler.addObject(new Lixo(2,1430,450));
		handler.addObject(new Lixo(2,1540,450));
		handler.addObject(new Lixo(4,230,450));
		
		
		
		tm = new TileMap("Resources/Mapas/level1.txt");
		//pbg = new Background("/Background/parallaxBg.png", 1);
		bg = new Background("/Background/level1Bg.png", 1);
		/*p1 = new Prédios("/Background/casa1.png");
		p2 = new Prédios("/Background/casa2.png");
		p3 = new Prédios("/Background/casa3.png");*/
		p = player.getPontos();
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
		
		handler.update();
		
		//System.out.println(handler.object.size());
	}
	
	public void draw(Graphics2D g) {//Loop
		off = player.getx();
		//Background
		//bg.setPosition(-off*0.3, 0);
		bg.draw(g);
		//pbg.setPosition(-off*2, 0);
		//pbg.draw(g);
		
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
		
		//g.drawString("", 20 - player.getx(), 440);
		
		g.drawString("Tempo: " + this.minutos + ":" + this.segundos+":"+ this.mSegundos,400,25);
		g.drawString("X:" + off,400,60);
		//g.drawString("Pontuação: ", 540, 200);
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
			if(off == 110) {
				handler.removeObject(handler.object.get(0));
				System.out.print(handler.object.get(0).gety());
				if(handler.object.get(0).gety() == 730)
					ger.setP(p+=10);}
			if(off == 210) {
				handler.removeObject(handler.object.get(1));
				if(handler.object.get(1).gety() == 600)
					ger.setP(p+=10);}
			if(off == 270) {
				handler.removeObject(handler.object.get(2));
				if(handler.object.get(2).gety() == 600)
					ger.setP(p+=10);}
			if(off == 330) {
				handler.removeObject(handler.object.get(3));
				if(handler.object.get(3).gety() == 600)
					ger.setP(p+=10);}
			if(off == 390) {
				handler.removeObject(handler.object.get(4));
				if(handler.object.get(4).gety() == 600)
					ger.setP(p+=10);}
			if(off == 470) {
				handler.removeObject(handler.object.get(5));
				if(handler.object.get(5).gety() == 600)
					ger.setP(p+=10);}
			if(off == 570) {
				handler.removeObject(handler.object.get(6));
				if(handler.object.get(6).gety() == 600)
					ger.setP(p+=10);}
			if(off == 710) {
				handler.removeObject(handler.object.get(7));
				if(handler.object.get(7).gety() == 600)
					ger.setP(p+=10);}
			if(off == 770) {
				handler.removeObject(handler.object.get(8));
				if(handler.object.get(8).gety() == 600)
					ger.setP(p+=10);}
			
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












