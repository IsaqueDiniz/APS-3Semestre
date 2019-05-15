//Posição
//Sprite

package entidades;

import java.awt.Graphics2D;

public abstract class Entidades {
	
	protected float x;
	protected float y;
	protected int velX;
	protected float velY;
	
	protected int width;
	protected int height;
	protected int scale;
	
	public abstract void update();
	public abstract void draw(Graphics2D g);
	
	public Entidades() {
		
	}
	
	public float getx() { return (float)x; }
	public float gety() { return (float)y; }
	public float getWidth() { return width; }
	public float getHeight() { return height; }
	
	public void setVector(float velX) {
		x += velX;
	}
	
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}

}
