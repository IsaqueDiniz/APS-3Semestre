package Main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {//Players, Inimigos, Npcs, Moedas, Objetos
	
	protected int x,y;
	//Posição do objeto
	//Acessível apenas por classes filhas, como player e inimigo
	protected ID id;
	//Tipo do objeto
	protected int velX, velY;
	//Velocidade do objeto no jogo
	
	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	//Os retângulos serão usados para detectar colisões
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX () {
		return x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setId (ID id) {
		this.id = id;
	}
	
	public ID getId () {
		return id;
	}
	
	public void setVelX (int velX) {
		this.velX = velX;
	}
	
	public int getVelX () {
		return velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelY () {
		return velY;
	}

}
