package entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import tileMap.Camera;
import tileMap.TileMap;

public class Player extends Entidades{
	
	private BufferedImage image;
	private Animacao animDir,animEsq;
	private TileMap tm;
	private int evento, pontos;
	
	
	

	public Player(float x, float y,int scale) {
		super(x,y);
		animDir = new Animacao(250, Assets.playerDir);
		animEsq = new Animacao(250, Assets.playerEsq);
	}
	
	public void init() {
		
	}

	public void update() {//Loop
		if(x>=0)
		x += velX;
		else
			x = 10;
		if(x>1250)
				x = 1210;		
		animDir.update();
		animEsq.update();
				
	}

	public void draw(Graphics2D g,float off) {//Loop
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

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
	
	
}
