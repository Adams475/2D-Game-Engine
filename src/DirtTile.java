import java.io.Serializable;

public class DirtTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2459088576363585650L;

	public DirtTile(int id) {
		super(Assets.dirt, id);
	}
	
	@Override
	public boolean isSolid() {
		return false;
	}

}
