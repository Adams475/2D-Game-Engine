import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class LoadingZone extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966275475769257799L;
	//rectangle for loading zone
	private Rectangle r;
	//enter point for player
	private Point enter;
	//exit point used for exit loading zone
	private Point exit;
	//will always be main world getting saved
	private World previousWorld;
	//world moving too
	private World world;
	//enter texture
	private transient BufferedImage enterTexture;
	//exit texture
	private transient BufferedImage exitTexture;
	
	public LoadingZone(Handler handler, float x, float y, int width, int height, Point enter, Point exit, World world) {
		super(handler, x, y, width, height);
	
		//sets up hitbox
		r = new Rectangle( (int) x, (int) y, width, height );
		//removes hitbox
		bounds.width = 0;
		bounds.height = 0;
		//defining variables
		this.enter = enter;
		this.exit = exit;
		this.world = world;
		previousWorld = handler.getWorld();
		
		
	}

	@Override
	public void tick() {
		
		//if player intersects rectangle
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).intersects(r)) {
			//sets to new world
			handler.setWorld(world);
			//adds a loading zone to exit the new world
			world.getEntityManager().addEntity(new LoadingZone(handler, exit.x, exit.y,  100, 100, new Point((int) x + width/2 - 24 , (int) y + height/2), new Point(-100, -100), previousWorld) {/**
				 * 
				 */
				private static final long serialVersionUID = 6221521699129413690L;

			{
				if(exitTexture != null) {
					setEnterTexture(Assets.stairs);
				}
			}});
			//sets the player's x and y to the proper enter point/exit point
			handler.getWorld().getEntityManager().getPlayer().x = enter.x;
			handler.getWorld().getEntityManager().getPlayer().y = enter.y;			
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		//if loading zone is given a texture use it else use a rectangle
		if(enterTexture != null) {
			g.drawImage(enterTexture, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, width, null);
		} else {
			g.fillRect((int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height);
		}
		
	}

	//implemented methods
	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}
	
	//getters and setters
	public BufferedImage getEnterTexture() {
		return enterTexture;
	}

	public void setEnterTexture(BufferedImage enterTexture) {
		this.enterTexture = enterTexture;
	}

	public BufferedImage getExitTexture() {
		return exitTexture;
	}

	public void setExitTexture(BufferedImage exitTexture) {
		this.exitTexture = exitTexture;
	}

	
	
	

}
