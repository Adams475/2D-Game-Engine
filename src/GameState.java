import java.awt.Graphics;
import java.io.Serializable;

public class GameState extends State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6274011441332270906L;
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/intro house.txt");
		handler.setWorld(world);
		new EntityAdder(handler, world.getEntityManager());

	}
	
	public void tick() {
		handler.getWorld().tick();
		handler.getGPM().tick();

	}

	public void render(Graphics g) {
		handler.getWorld().render(g);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	

}
