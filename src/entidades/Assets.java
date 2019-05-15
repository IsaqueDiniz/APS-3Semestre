package entidades;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage ground,player,casa1,nulo;
	public static BufferedImage[] playerDir,playerEsq;
	public static final int width = 64;
	public static final int height = 64;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Tiles/spriteSheet.png"));
		
		nulo = sheet.crop(width*6, 0, width, height);
		ground = sheet.crop(width*5, 0, width, height);
		casa1 = sheet.crop(width*2, 0, width*3, height*2);
		
		
		//Player Animations
		player = sheet.crop(0, 0, width, height);
		playerDir = new BufferedImage[2];
		playerEsq = new BufferedImage[2];
		playerDir[0] = sheet.crop(0, 0, width, height);
		playerDir[1] = sheet.crop(width, 0, width, height);
		playerEsq[0] = sheet.crop(0, height, width, height);
		playerEsq[1] = sheet.crop(width, height, width, height);
	}

}
