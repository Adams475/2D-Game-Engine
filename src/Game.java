import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.Serializable;

public class Game implements Runnable, Serializable {

	//TODO add jump scare with ear-rape
	private transient Display display;
	
	private String title;
	private int width, height;
	
	private boolean running = false;
	private transient Thread thread;
	private GPM gpm;

	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public transient State settingState;
	public transient State questState;
	public transient State worldMapState;
	public transient State skillState;
	
	//input
	private KeyManager keyManager;
	
	//Mouse Manager
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	//Example for importing image:
	//private BufferedImage testImage; 
	//testImage = ImageLoader.loadImage("/textures/bard.png");
	//g.drawImage(testImage, 80, 90, null);	
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;	
		mouseManager = new MouseManager();
		keyManager = new KeyManager(mouseManager, handler);
		
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		//frame mouse listener
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		//canvas mouse listener
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		 
		handler = new Handler(this);
		
		gameCamera = new GameCamera(handler, 0, 0);
		gpm = new GPM(handler);
		skillState = new SkillState(handler);
		worldMapState = new WorldMap(handler);
		setGameState(new GameState(handler));
		questState = new QuestState(handler);
		setSettingState(new SettingState(handler));
		setMenuState(new MenuState(handler));
		
		
		State.setState(menuState);
		
	}
	
	private void tick() {
		
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		//Start Brush
		g = bs.getDrawGraphics();
		//Clear
		g.clearRect(0, 0, width, height);		
		//Draw
		
		if(State.getState() != null) {
			State.getState().render(g);
		} 
		
		//End Draw
		bs.show();
		g.dispose();
	}
	
	
	public void run() {		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >=1) {
				tick();			
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				//System.out.println("Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
			
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
		
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}



	public State getGameState() {
		return gameState;
	}
	
	public State getSettingState() {
		return settingState;
	}
	
	public State getMenuState() {
		return menuState;
	}



	public void setGameState(State gameState) {
		this.gameState = gameState;
	}
	
	public void setSettingState(State settingState) {
		this.settingState = settingState;
	}
	
	public void setMenuState(State menuState) {
		this.menuState = menuState;
	}



	public GPM getGpm() {
		return gpm;
	}
	
	



	public Graphics getG() {
		return g;
	}



	public void setG(Graphics g) {
		this.g = g;
	}



	public void setGpm(GPM gpm) {
		this.gpm = gpm;
	}
	

}
