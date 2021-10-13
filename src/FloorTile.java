import java.awt.image.BufferedImage;
import java.io.Serializable;

public class FloorTile extends Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8541167863747801443L;

	public FloorTile(BufferedImage texture, int id) {
		super(texture, id);
		
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
