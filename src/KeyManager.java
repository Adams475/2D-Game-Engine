import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

public class KeyManager implements KeyListener, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2871542074448460297L;
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, attackDown, attackUp, attackLeft, attackRight;
	public boolean leftClick;
	MouseManager mouseManager;
	public transient Handler handler;
	
	public KeyManager(MouseManager mouseManager, Handler handler) {
		this.handler = handler;
		this.mouseManager = mouseManager;
		keys = new boolean[512];
		justPressed = new boolean[keys.length];
		cantPress= new boolean[keys.length];
	}
	
	public void tick() {
		
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if (justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		if(keyJustPressed(KeyEvent.VK_E)) {
			
		}
		
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		attackDown = keys[KeyEvent.VK_DOWN];
		attackUp = keys[KeyEvent.VK_UP];
		attackLeft = keys[KeyEvent.VK_LEFT];
		attackRight = keys[KeyEvent.VK_RIGHT];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length) {
			return;
		}
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	

}
