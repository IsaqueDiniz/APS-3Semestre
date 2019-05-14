package entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Player extends Entidades{
	
	private BufferedImage image;
	private Animacao animDir,animEsq;
	
	
	public Player(int x, int y, int w, int h,int scale, String s) {
		
		this.x = x; this.y = y; width = w ; height = h; this.scale=scale;
		
		/*try {
			image = ImageIO.read(
				getClass().getResourceAsStream(s)
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		animDir = new Animacao(150, Assets.playerDir);
		animEsq = new Animacao(150, Assets.playerEsq);
	}
	
	public void init() {
		
	}

	public void update() {//Loop
		x += velX;
		animDir.update();
		animEsq.update();
	}

	public void draw(Graphics2D g) {//Loop
		//g.fillRect(x, y, 64, 64);
		
		/*width = image.getWidth();
		height = image.getHeight();
		g.drawImage(image, (int)x, (int)y,width*scale,height*scale, null); funcionando*/
		
		//g.drawImage(ImageLoader.loadImage("/Objects/protag4.png"), x, y, null); funcionando
		
		//g.drawImage(Assets.playerDir[0], x, y, null);//funcionando
		g.drawImage(getFrame(), (int)x, (int)y, null);//erros - Null pointers
	}
	
	private BufferedImage getFrame() {
		if(velX < 0)
			return animEsq.getCurrentFrame();
		else if (velX > 0)
			return animDir.getCurrentFrame();
		else
			return Assets.playerDir[0];
	}
	
}
