//Posição
//Sprite

package entidades;

import java.awt.Graphics2D;

public abstract class Entidades {
	
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	
	protected int width;
	protected int height;
	protected int scale;
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
	public Entidades() {
		
	}
	
	public int getx() { return (int)x; }
	public int gety() { return (int)y; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public void setVector(int velX) {
		x += velX;
	}
	
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}

}
