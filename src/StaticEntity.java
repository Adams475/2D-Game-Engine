import java.io.Serializable;

public abstract class StaticEntity extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7952496244327318449L;
	public static final int scaleEntity = 4;
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
