package tileMap;

public class Camera {
	
	private float xOffset,yOffset;
	
	public Camera(float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}
	
	public void move(float xQtd,float yQtd) {
		xOffset += xQtd;
		yOffset += yQtd;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	

}
