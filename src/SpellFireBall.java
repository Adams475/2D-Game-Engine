import java.awt.Graphics;
import java.io.Serializable;

public class SpellFireBall extends Creature implements Serializable{

	private static final long serialVersionUID = 1971804220179129277L;
	private Animation right, left, up, down;
	private Animation currentAnim;
	private boolean doneTracking;
	private float cenX, cenY;
	private float tX, tY;
	private double angle;
	private long birthTime = System.currentTimeMillis();

	public SpellFireBall(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		this.health = 999;
		
		right = new Animation(100, Assets.fb_right);
		left = new Animation(100, Assets.fb_left);
		up = new Animation(100, Assets.fb_up);
		down = new Animation(100, Assets.fb_down);
		
		//ignore(?)
		currentAnim = right;
		
	}

	@Override
	public void tick() {
		
		if(System.currentTimeMillis() - birthTime > 2500) {
			handler.getWorld().getEntityManager().getEntities().remove(this);
		}
		
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0, 0).contains(this.x, this.y)) {
			handler.getWorld().getEntityManager().getPlayer().hurt(10);
			active = false;
		}
		
		right.tick();
		left.tick();
		up.tick();
		down.tick();
		
		if(xMove > 0) {
			this.width = 52;
			this.height = 18;
			currentAnim = right;
			
		} else if(xMove < 0) {
			this.width = 52;
			this.height = 18;
			currentAnim = left;
			
		} else if(yMove < 0) {
			this.width = 16;
			this.height = 32;
			currentAnim = up;
			
		} else if(yMove > 0) {
			this.width = 16;
			this.height = 32;
			currentAnim = down;
			
		} 
		
		
		
		trackPlayer();
		move();
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(currentAnim.getCurrentFrame(), (int) (this.x - handler.getGameCamera().getxOffset()), 
				(int) (this.y - handler.getGameCamera().getyOffset() ), width, height, null);
	
	}

	@Override
	public void die() {
		
	}

	@Override
	public void interact() {
		
	}
	
	public void trackPlayer() {
		
		if(doneTracking) {
			return;
		}
		
		cenX = (this.x );
		cenY = (this.y );
		
		tX = handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().width/2 - cenX;
		tY = handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().height - cenY;

		angle = Math.atan(tY/ tX);
		
		
		xMove = (float) (7 * Math.cos(angle));
		yMove = (float) (7 * Math.sin(angle));
		
		if(tX < 0) {
			xMove *= -1;
			yMove *= -1;
		}
		
		
		doneTracking = true;
		
	}

}
