package gameStates;

import gameStates.Menu;

public class Gerenciador {
	
	private GameState[] gameStates;
	private int currentState,p;
	
	public static final int TOTALSTATES = 3;
	public static final int OPCOES = -1;
	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
	public static final int RESULTADO = 2;
	
	public Gerenciador()
	{
		gameStates = new GameState[TOTALSTATES];
		
		currentState = MENU;
		loadState(currentState);
	
	}
	private void loadState(int state)
	{
		if(state ==MENU)
			gameStates[state] = new Menu(this);
		if(state == LEVEL1)
			gameStates[state] = new Level1(this);
		if(state == RESULTADO)
			gameStates[state] = new Resultado(this,p);
		
	}
	private void unloadState(int state)
	{
		gameStates[state] = null;
	}
	public void setState(int state)
	{
		unloadState(currentState);
		currentState = state;
		loadState(state);
		
	}
	
	public void update()
	{
		try{
		gameStates[currentState].update();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void draw(java.awt.Graphics2D g)
	{
		try{
		gameStates[currentState].draw(g);
		}catch(Exception e){
		e.printStackTrace();
		}
	}
	public void keyPressed(int k)
	{
		gameStates[currentState].keyPressed(k);
	}
	public void keyReleased(int k)
	{
		gameStates[currentState].keyReleased(k);
	}
	public void setP(int p) {
		this.p = p;
	}
}
