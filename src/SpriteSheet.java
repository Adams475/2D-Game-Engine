import java.awt.image.BufferedImage;
import java.io.Serializable;

public class SpriteSheet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8285647099821811541L;
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet) {
		
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
		
	}

}
