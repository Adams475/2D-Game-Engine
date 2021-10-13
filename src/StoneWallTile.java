import java.awt.image.BufferedImage;
import java.io.Serializable;

public class StoneWallTile extends Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827009135588928308L;

	public StoneWallTile(BufferedImage texture, int id) {
		super(texture, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}


}
