package gameStates;

import java.awt.Graphics2D;
import java.util.LinkedList;

import entidades.Entidades;

public class Handler {//Mantém, atualiza e renderiza TODOS os GameObjects
	
	LinkedList<Entidades> object = new LinkedList<Entidades>();
	
	public void update() {
		for (int i=0 ; i < object.size() ; i++) {
			Entidades tempObject = object.get(i);
			tempObject.update();
		}
	}
	
	public void draw(Graphics2D g, float off) {
		for (int i=0 ; i < object.size() ; i++) {
			Entidades tempObject = object.get(i);
			
			tempObject.draw(g, (int)off);
		}
	}
	
	public void addObject(Entidades object) {
		this.object.add(object);
	}
	
	public void removeObject(Entidades object) {
		object.setY(object.gety()+150);;
	}

}
