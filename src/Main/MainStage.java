//Main Class

package Main;

//awt contém classes para uso de gráficos e imagens

import java.awt.Canvas;//Canvas é uma classe cujos componentes representam áreas retangulares vazias da tela
import java.awt.Color;//Encapsula cores RGB em um determinado espaço
import java.awt.Graphics;//Classe base para que a aplicação possa "desenhar" gráficos em componentes
import java.awt.image.BufferStrategy;
//image=Super-classe daquelas que representam imagens
/*BufferStrategy() Usado para determinar quantos buffersserão utilizados*/
//awt contém todas as classes usadas para criar interfaces


public class MainStage extends Canvas implements Runnable {
//O que é "implements" e "runnable"?
	
	private static final long serialVersionUID = 6264063573776638777L;
	public static final int WIDTH=1280,HEIGHT= WIDTH/16*9;
	//Define os campos de largura e altura da instância de Window
	
	private Thread thread;//O jogo vai rodar inteiramente em um thread
	private boolean running = false;//Variável usada para inicializar o jogo em si
	private Handler handler;//Declara a classe Handler
	private HUD hud;
	
	public MainStage(){//Constructor
		handler = new Handler();
		//Instancia a classe handler
		this.addKeyListener(new KeyInput(handler));
		//Diz para o jogo "ouvir" os inputs
		new Window(WIDTH, HEIGHT, "The game.", this);
		hud = new HUD();
		//Instância da janela do jogo
		//Ao criá-la, o método start() é chamado
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
		//Adiciona um player á janela no centro
		handler.addObject(new InimigoBasico(WIDTH/2-32, HEIGHT/2-32, ID.InimigoBasico));
	}
	
	public synchronized void start() {//É chamado na classe Window para inicializar o thread
	//Método usado em Window
		thread = new Thread(this);//Seleciona o private thread criado nesta classe
		thread.start();//Inicia o thread
		running = true;//Diz que o thread está on e chama o método run() em while(running)
	}
	
	public synchronized void stop() {
		try {//Se podemos fazer, faça...
			thread.join();//Para o thread
			running = false;//Diz que o thread está off
		}catch(Exception e){//...Se não, mostre-me o erro
			e.printStackTrace();//Reporta erros no console
		}
		}
	
	public void run() {
	//Game loop - A velocidade na qual o jogo roda
	//O loop configura uma velocidade constante em que o jogo vai operar além de renderizá-lo
	//Ele impede o pc de executar cada loop o mais rápido possível e o limita
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;//Quantos ticks por segundo
		double ns = 1000000000 / amountOfTicks;//Quanto tempo em nanosegundos 1 frame tem
		double delta = 0;
		//Diferença em nanosegundos entre o sistema e o último tick
		//Quando este valor é >1, o tick é chamado e a diferença volta a ser 0
		long timer = System.currentTimeMillis();//Timer para a próxima vez que o frame vai atualizar
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();//O segundo no tempo em que estamos, literalmente o presente
			delta += (now - lastTime) / ns;
			/*Diferença entre o nanosegundo atual e o nanosegundo em 
			que o loop foi executado*/
			lastTime = now;
			while(delta >= 1) {//Atualiza o frame
				tick();//Atualiza os GameObjects
				delta--;
			}
			if(running)
			/*O jogo atualiza apenas, se já tiver passado tempo o suficiente para
			completar outro loop*/
				render();//Chama o método render()
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {//Intervalo em que o fps vai atualizar, no caso a cada 1000ns
				timer += 1000;
				System.out.println("FPS" + frames);
				frames = 0;
			}
			
		}
		stop();
	}
	
	private void tick(){//Onde rola a lógica do jogo
		handler.tick();//Executa o método criado na classe Handler
		hud.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();//Criado um buffer strategy
		if(bs == null){
			this.createBufferStrategy(3);//Quantos buffers haverão
			return;
		}
		
		//limpa e chama um objeto gráfico "g"
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);//Setta a cor da tela para preto
		g.fillRect(0, 0, WIDTH, HEIGHT);//Pega os valores definidos para o tamanho da tela em "final int"
		
		handler.render(g);//Renderiza os GameObjects na tela chamando o método handler
		
		hud.render(g);//Renderiza o hud
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max ) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}
	
	public static void main (String args[]) {
		new MainStage();//Criada nova instância que vai chamar o Constructor
	}

}
