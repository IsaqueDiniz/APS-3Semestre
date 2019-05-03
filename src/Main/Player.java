package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;

	public Player(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds(){//A hitbox do player
		return new Rectangle (x,y,32,32);
	}

	public void tick() {
		x += velX;
		y += velY;
		//Métodos clamp para o player não sair da tela
		x = MainStage.clamp(x,0,MainStage.WIDTH-37);
		y = MainStage.clamp(y,0,MainStage.HEIGHT-60);
		
		collision();
	}
	private void collision(){
		for(int i = 0;i < handler.object.size();i++ ) {//Loop de leitura e atualização de todos os objetos no jogo
			
			GameObject tempObject = handler.object.get(i);//Instancia o que será a collision box do player
			
			if(tempObject.getId()==ID.InimigoBasico) {//se o objeto criado é um inimigo:
				if(getBounds().intersects(tempObject.getBounds())) {
					//getBounds() retorna o retângulo da hitbox do player
					
					//Se este objeto colidir:
				HUD.HEALTH -= 2;//A barra de vida diminui
				}
			}
		}
	}
	

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	}
	
	

}
