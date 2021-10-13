import java.io.Serializable;

public class BushTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7766845925312160803L;

	public BushTile(int id) {
		super(Assets.bush, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}