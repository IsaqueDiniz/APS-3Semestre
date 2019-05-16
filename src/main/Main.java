package main;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args)
	{
		JFrame window = new JFrame("5 minutos");
		window.setContentPane(new Janela());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}

}