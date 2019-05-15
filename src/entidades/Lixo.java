package entidades;

import java.awt.Color;
import java.awt.Graphics2D;

public class Lixo extends Entidades{
	
	private int[] lixo;
	private int id;
	
	public Lixo(int id,int x,int y) {
		super(x,y);this.id = id;
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g, float off) {
		//g.setColor(Color.WHITE);
		//g.fillRect((int)x, (int)y, 32, 32);
		if(id == 1)
			g.drawImage(Assets.lixo1, (int)x - (int)off, (int)y, null);
		if(id == 2)
			g.drawImage(Assets.lixo2, (int)x-(int)off, (int)y, null);
		if(id == 3)
			g.drawImage(Assets.lixo3, (int)x-(int)off, (int)y, null);
		if(id == 0)
			g.drawImage(Assets.nulo, (int)x-(int)off, (int)y, null);
	
	}

}
