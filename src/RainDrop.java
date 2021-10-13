import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class RainDrop implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3055537654019903787L;
	int x;
	int y;
	int yspeed;
	int length;
	Random r;
	
	public RainDrop() {
		
		r = new Random();
		
		length = r.nextInt(5) + 5;
		x = r.nextInt(Launcher.SCREEN_WIDTH);
		y = -500 + r.nextInt(500);
		yspeed = r.nextInt(5) + 6;
		
	}
	
	public void tick() {
		
		y = y + yspeed;
		
		if(y > Launcher.SCREEN_HEIGHT) {
			y = -200 + r.nextInt(100);
		}
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		if(yspeed > 8) {
			g.drawLine(x, y, x, y + length);
			g.drawLine(x + 1, y, x + 1, y + length);
		} else {
			g.drawLine(x, y, x, y + length);
		}
		
		
	}

}
