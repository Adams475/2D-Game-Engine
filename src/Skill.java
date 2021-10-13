import java.awt.image.BufferedImage;

public class Skill {
	
	public BufferedImage[] animation;
	private Handler handler;
	public int damageInc;
	public int animDec;
	public String type;
	public int critInc;
	
	public Skill(Handler handler) {
		this.handler = handler;
	}
	
	public Skill(Handler handler, String type, BufferedImage[] animation) {
		this.handler = handler;
		this.type = type;
		this.animation = animation;
	}
	
	public Skill(Handler handler, String type, int damageInc, int animDec) {
		this.handler = handler;
		this.type = type;
		this.damageInc = damageInc;
		this.animDec = animDec;
	}
	
	public Skill(Handler handler, String type, int critInc) {
		this.handler = handler;
		this.type = type;
		this.critInc = critInc;
	}
	
	

}
