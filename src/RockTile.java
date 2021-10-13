import java.io.Serializable;

public class RockTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4355092253065402502L;

	public RockTile(int id) {
		super(Assets.rock, id);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
