//Main Class

package Main;

//awt cont�m classes para uso de gr�ficos e imagens

import java.awt.Canvas;//Canvas � uma classe cujos componentes representam �reas retangulares vazias da tela
import java.awt.Color;//Encapsula cores RGB em um determinado espa�o
import java.awt.Graphics;//Classe base para que a aplica��o possa "desenhar" gr�ficos em componentes
import java.awt.image.BufferStrategy;
//image=Super-classe daquelas que representam imagens
/*BufferStrategy() Usado para determinar quantos buffersser�o utilizados*/
//awt cont�m todas as classes usadas para criar interfaces


public class MainStage extends Canvas implements Runnable {
	//A main agora � tratada como uma subclasse de Canvas
	//"Runnable" � implementado para que se possa iniciar o thread em que o jogo roda
	
	private int segundos = 0;
	private int minutos = 0;
	private int horas = 0;

	private static final long serialVersionUID = 6264063573776638777L;
	//Serializa��o da classe
	public static final int WIDTH=1280,HEIGHT= WIDTH/16*9;
	//Define os campos de largura e altura da inst�ncia de Window
	
	private Thread thread;//O jogo vai rodar inteiramente em um thread
	private boolean running = false;//Vari�vel usada para inicializar o jogo em si
	
	private Handler handler;//Declara a classe Handler
	private HUD hud;//Barra de vida
	private Spawner spawn;
	
	public MainStage(){//Constructor
		handler = new Handler();
		//Instancia um handler que ir� ler e atualizar os objetos a serem renderizados
		
		this.addKeyListener(new KeyInput(handler));
		//Diz para o jogo "ouvir" os inputs
		
		new Window(WIDTH, HEIGHT, "The game.", this);
		//Instancia/roda a janela do jogo
		//Inst�ncia da janela do jogo
		//Ao cri�-la, o m�todo start() � chamado
		
		hud = new HUD();
		spawn = new Spawner(handler, hud);
		
		handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler ));
		//O handler diciona um player � janela no centro
		//handler.addObject(new InimigoBasico(32,32, ID.InimigoBasico));
	}
	
	public synchronized void start() {//� chamado na classe Window para inicializar o thread
	//M�todo usado em Window
		thread = new Thread(this);//Instancia o private thread chamado nesta classe
		thread.start();//Inicia o thread
		running = true;//Diz que o thread est� on e chama o m�todo run() em while(running)
	}
	
	public synchronized void stop() {
		try {//Se podemos fazer, fa�a...
			thread.join();//Para o thread
			running = false;//Diz que o thread est� off
		}catch(Exception e){//...Se n�o, mostre-me o erro
			e.printStackTrace();//Reporta erros no console
		}
		}
	
	public void run() {
	//Game loop - A velocidade na qual o jogo roda
	//O loop configura uma velocidade constante em que o jogo vai operar al�m de renderiz�-lo
	//Ele impede o pc de executar cada loop o mais r�pido poss�vel e o limita
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;//Quantos ticks por segundo
		double ns = 1000000000 / amountOfTicks;//Quanto tempo em nanosegundos 1 frame tem
		double delta = 0;
		//Diferen�a em nanosegundos entre o sistema e o �ltimo tick
		//Quando este valor � >1, o tick � chamado e a diferen�a volta a ser 0
		long timer = System.currentTimeMillis();//Timer para a pr�xima vez que o frame vai atualizar
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();//O segundo no tempo em que estamos, literalmente o presente
			delta += (now - lastTime) / ns;
			/*Diferen�a entre o nanosegundo atual e o nanosegundo em 
			que o loop foi executado*/
			lastTime = now;
			while(delta >= 1) {//Atualiza o frame
				tick();//Atualiza os GameObjects
				delta--;
			}
			if(running)
			/*O jogo atualiza apenas, se j� tiver passado tempo o suficiente para
			completar outro loop*/
				render();//Chama o m�todo render()
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {//Intervalo em que o fps vai atualizar, no caso a cada 1000ns
				timer += 1000;
				
				System.out.println("frames" + frames);
				frames = 0;
			}
			
		}
		stop();
	}
	
	private void tick(){//Onde rola a l�gica do jogo
		handler.tick();//Executa o m�todo criado na classe Handler
		hud.tick();
		spawn.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();//Criado um buffer strategy
		if(bs == null){
			this.createBufferStrategy(3);//Quantos buffers haver�o
			return;
		}
		
		//limpa e chama um objeto gr�fico "g"
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);//Setta a cor da tela para preto
		g.fillRect(0, 0, WIDTH, HEIGHT);//Pega os valores definidos para o tamanho da tela em "final int"
		
		handler.render(g);//Renderiza os GameObjects na tela chamando o m�todo handler
		
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
		new MainStage();//Criada nova inst�ncia que vai chamar o Constructor
	}

}
