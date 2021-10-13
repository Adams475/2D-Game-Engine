import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Animation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -79335626863573145L;
	//variable initialization
	private int speed, index;
	private long lastTime, timer;
	private transient BufferedImage[] frames;
	private boolean playedOnce;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
		playedOnce = false;
	}
	
	//used to reset index if animation isn't fully completed
	public void set(int i) {
		index = i;
	}
	
	public void tick() {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
				playedOnce = true;
			}else {
				playedOnce = false;
			}
		}
	}
	
	//gets frame based on time passed
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	public BufferedImage[] getAllFrames() {
		return frames;
	}
	
	//gets if the animation has been played once, useful for single play animations like attacking
	public boolean hasPlayedOnce() {
		return playedOnce;
	}

}
