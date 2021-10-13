import java.io.Serializable;

public class GrassTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6676376260342399328L;

	public GrassTile(int id) {
		super(Assets.grass, id);
		
	}

}
