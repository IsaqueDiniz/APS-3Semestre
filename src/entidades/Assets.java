package entidades;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage player;
	public static BufferedImage[] playerEsq;
	public static BufferedImage[] playerDir;
	public static final int width = 64;
	public static final int height = 64;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Objects/protag4.png"));
		
		player = sheet.crop(0, 0, width, height);
		
		playerDir = new BufferedImage[2];
		playerEsq = new BufferedImage[2];
		
		playerDir[0] = sheet.crop(0, 0, width, height);
		playerDir[1] = sheet.crop(width, 0, width, height);
		playerEsq[0] = sheet.crop(0, height, width, height);
		playerEsq[1] = sheet.crop(width, height, width, height);
	}

}
