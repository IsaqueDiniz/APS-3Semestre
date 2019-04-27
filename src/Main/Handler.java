package Main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {//Mant�m, atualiza e renderiza TODOS os GameObjects
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	//Cria uma lista chamada object de TODOS os GameObjects
	
	public void tick() {//Atualiza os objetos
		for (int i=0 ; i < object.size() ; i++) {
		//Este for ir� fazer a leitura de cada objeto na tela, um de cada vez
		//Object.size representa o total de objetos na tela
			GameObject tempObject = object.get(i);
			//Instancia um objeto tempor�rio e pega o i como seu id
			
			tempObject.tick();//Executa este m�todo(?)
		}
	}
	
	public void render(Graphics g) {//Renderiza os objetos
		for (int i=0 ; i < object.size() ; i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);//Executa este m�todo(?)
		}
	}
	
	public void addObject(GameObject object) {//Adiciona um objeto a lista
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {//Adiciona um objeto a lista
		this.object.remove(object);
	}

}
