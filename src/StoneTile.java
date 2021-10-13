import java.io.Serializable;

public class StoneTile extends Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2758563608961820106L;

	public StoneTile(int id) {
		super(Assets.stone, id);
		
	}

}
