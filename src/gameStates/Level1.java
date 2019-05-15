package gameStates;

import tileMap.*;
import entidades.Assets;
import entidades.Lixo;
import entidades.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1 extends GameState {
	
	private Background bg,pbg;
	private TileMap tm;
	private Player player;
	private int mSegundos,segundos,minutos,p;
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
		
		player = new Player(10,580,1);
		
		handler = new Handler();
		
		handler.addObject(new Lixo(1,230,580));
		handler.addObject(new Lixo(2,410,580));
		handler.addObject(new Lixo(3,530,580));
		handler.addObject(new Lixo(1,650,580));
		handler.addObject(new Lixo(3,790,580));
		handler.addObject(new Lixo(3,930,580));
		handler.addObject(new Lixo(2,1150,580));
		handler.addObject(new Lixo(2,1430,580));
		handler.addObject(new Lixo(2,1660,580));
		handler.addObject(new Lixo(4,230,580));
		
		
		
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
		
		g.drawString("Preciso ir trabalhar, ir ao restaurante e voltar para casa", 20 - player.getx(), 440);
		
		g.drawString("Tempo: " + this.minutos + ":" + this.segundos+":"+ this.mSegundos,590,25);
		g.drawString("X:" + off,590,60);
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
			handler.removeObject(handler.object.get(0));ger.setP(p+=10);}
			if(off == 210) {
				handler.removeObject(handler.object.get(1));ger.setP(p+=10);}
			if(off == 270) {
				handler.removeObject(handler.object.get(2));ger.setP(p+=10);}
			if(off == 330) {
				handler.removeObject(handler.object.get(3));ger.setP(p+=10);}
			if(off == 390) {
				handler.removeObject(handler.object.get(4));ger.setP(p+=10);}
			if(off == 470) {
				handler.removeObject(handler.object.get(5));ger.setP(p+=10);}
			if(off == 570) {
				handler.removeObject(handler.object.get(6));ger.setP(p+=10);}
			if(off == 710) {
				handler.removeObject(handler.object.get(7));ger.setP(p+=10);}
			if(off == 830) {
				handler.removeObject(handler.object.get(8));ger.setP(p+=10);}
			
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












