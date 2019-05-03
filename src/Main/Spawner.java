package Main;

public class Spawner {
	
	private Handler handler;
	private HUD hud;//Mesmo sendo static, a variável HEALTH na classe HUD, ela é instanciada para prevenir erros
	
	private int gameTimerKeep = 0;
	
	public Spawner(Handler handler,HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		gameTimerKeep++;
	}
	
	

}
