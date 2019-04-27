package Main;

import java.awt.Canvas;
// Awt Contém todas as classes usadas para criar interfaces, gráficos e imagens
//Representa um espaço em branco na janela onde pode ser  algo
import java.awt.Dimension;
/*"Dimension" encapsula altura e largura
de um componente em apenas 1 objeto*/
import javax.swing.JFrame;


public class Window extends Canvas{
//Extende/herda propriedades/métodos da classe Canvas 

	private static final long serialVersionUID = 7883803474888262873L;
	/*Garante que se eu fizer alguma alteração na classe e a salve
	várias vezes, todos os arquivos tenham o mesmo ID.
	Porém, não se pode mais remover campos ou métodos,
	apenas adicionar.*/
	
	public Window (int width, int height, String title, MainStage game) {
		JFrame frame = new JFrame(title);
		/*JFrame é uma biblioteca que vem com o JRE
		 *Este "frame" criado é a moldura da janela*/
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*Clicar no X fecha o jogo E encerra o app*/
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		/*Faz o jogo começar no meio da tela*/
		frame.add(game);
		/*Adiciona a classe MainStage á janela*/
		frame.setVisible(true);
		/*Torna a janela visível*/
		game.start();
		//Executa o método "start" criado na classe MainStage
		
	}

}
