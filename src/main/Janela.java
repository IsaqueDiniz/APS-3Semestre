package main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.*;

import javax.swing.JPanel;

import gameStates.Audio;
import gameStates.Gerenciador;

public class Janela extends JPanel implements Runnable, KeyListener{

	//dimensions
	public static final int WIDTH = 800, HEIGHT = 600, SCALE = 1;
	
	//game thread
	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	//image
	private BufferedImage image;
	private Graphics2D g;
	
	private Gerenciador ger;
	
	private Audio audio;
	
	public Janela(){
		super();
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		requestFocus();
		
	}
	public void addNotify()
	{
		super.addNotify();
		if (thread==null)
		{
			thread = new Thread(this);
			addKeyListener(this);
			thread.start();
		}
	}
	public void start()
	{
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;
		ger = new Gerenciador();
		audio = new Audio();
		audio.playSong("Resources/Audio/faixa5.wav");
	}
	public void run()
	{
		
		start();
		
		long start;
		long elapsed;
		long wait;
		
		while (running)
		{
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed/1000000;
			if (wait<0)
			{
				
			wait = 5;
			}
			try {
				thread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	private void update()
	{
		ger.update();
	}
	private void draw()
	{
		ger.draw(g);
	}
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT *SCALE, null);
		g2.dispose();
	}
	public void keyPressed(KeyEvent key) {
		ger.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) {	
		ger.keyReleased(key.getKeyCode());
	}
	public void keyTyped(KeyEvent key) {

	}
}
