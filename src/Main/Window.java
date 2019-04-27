package Main;

import java.awt.Canvas;
// Awt Cont�m todas as classes usadas para criar interfaces, gr�ficos e imagens
//Representa um espa�o em branco na janela onde pode ser  algo
import java.awt.Dimension;
/*"Dimension" encapsula altura e largura
de um componente em apenas 1 objeto*/
import javax.swing.JFrame;


public class Window extends Canvas{
//Extende/herda propriedades/m�todos da classe Canvas 

	private static final long serialVersionUID = 7883803474888262873L;
	/*Garante que se eu fizer alguma altera��o na classe e a salve
	v�rias vezes, todos os arquivos tenham o mesmo ID.
	Por�m, n�o se pode mais remover campos ou m�todos,
	apenas adicionar.*/
	
	public Window (int width, int height, String title, MainStage game) {
		JFrame frame = new JFrame(title);
		/*JFrame � uma biblioteca que vem com o JRE
		 *Este "frame" criado � a moldura da janela*/
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*Clicar no X fecha o jogo E encerra o app*/
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		/*Faz o jogo come�ar no meio da tela*/
		frame.add(game);
		/*Adiciona a classe MainStage � janela*/
		frame.setVisible(true);
		/*Torna a janela vis�vel*/
		game.start();
		//Executa o m�todo "start" criado na classe MainStage
		
	}

}
