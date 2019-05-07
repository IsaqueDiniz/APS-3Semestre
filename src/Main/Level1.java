package Main;

public class Level1 {
	
	private Handler handler;
	private HUD hud;
	
	public Level1() {
		hud = new HUD();
		handler.addObject(new Player(1280/2-32, 720/2-32, ID.Player, handler ));
	}
}
