import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class UIImageButton extends UIObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3273771391866789156L;
	private BufferedImage[] images;
	private ClickListener clicker;
	

	public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
		}else {
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
