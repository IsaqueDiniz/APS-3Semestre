//Posição
//Sprite

package entidades;

import java.awt.Graphics2D;

public abstract class Entidades {
	
	protected float x;
	protected float y;
	protected float velX;
	protected float velY;
	
	protected int width;
	protected int height;
	protected int scale;
	
	public abstract void update();
	public abstract void draw(Graphics2D g,float off);
	
	public Entidades(float x, float y) {
		this.x = x;this.y=y;
	}
	
	public float getx() { return (float)x; }
	public float gety() { return (float)y; }
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getWidth() { return width; }
	public float getHeight() { return height; }
	
	public void setVector(float velX) {
		x += velX;
	}
	
	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}

}
