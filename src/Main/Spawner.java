package Main;

public class Spawner {
	
	private Handler handler;
	private HUD hud;//Mesmo sendo static, a vari�vel HEALTH na classe HUD, ela � instanciada para prevenir erros
	private int[] gameState = {0,1,2,3,4,5,6,7,8};
	private int state;
	private MenuState menuState;
	
	public void tick() {
		
	}
	
	public void loadState (int state) {
		if (state == 0) {
			//Load Menu
		}
		if (state == 1) {
			//Load Level1
		}
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
}
