package entidades;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String s) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(s));
	
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
