import java.awt.Graphics;
import java.io.Serializable;

public class IceBallClass extends Creature implements Serializable{
    //This whole thing is a TODO 
	private static final long serialVersionUID = 1971804220179129277L;
	private Animation right = new Animation(125, Assets.ice_shot_right), left = new Animation(125, Assets.ice_shot_left), 
			up = new Animation(125, Assets.ice_shot_up), down = new Animation(125, Assets.ice_shot_down);
	private Animation currentAnim;
	private long birthTime = System.currentTimeMillis();
	private String direction;
	
	public IceBallClass(Handler handler, float x, float y, int width, int height, String direction) {
		super(handler, x, y, width, height);
		
		bounds.width = 0;
		bounds.height = 0;
		this.health = 999;
		
		this.direction = direction;
		
		if(direction == "up") {
			this.x += 8;
			currentAnim = up;
			yMove = -5;
		} else if(direction == "right") {
			this.x += 30;
			this.y += 28;
			currentAnim = right;
			xMove = 5;
		} else if(direction == "down") {
			this.x += 8;
			this.y += 25;
			currentAnim = down;
			yMove = 5;
		} else {
			this.x -= 5;
			this.y += 28;
			currentAnim = left;
			xMove = -5;
		}
		
	}

	@Override
	public void tick() {
		
		checkDestroy();
		tickDirection();
		move();
		dealDamage();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(currentAnim.getCurrentFrame(), (int) (this.x - handler.getGameCamera().getxOffset()), 
				(int) (this.y - handler.getGameCamera().getyOffset() ), width, height, null);
	
	}
	
	private void checkDestroy() {
		if(System.currentTimeMillis() - birthTime > 2500) {
			handler.getWorld().getEntityManager().getEntities().remove(this);
		}
	}
	
	private void tickDirection() {
		if(direction == "right") {
			right.tick();
		} else if(direction == "left") {
			left.tick();
		} else if(direction == "up") {
			up.tick();
		} else {
			down.tick();
		}
	}

	@Override
	public void die() {
		
	}

	@Override
	public void interact() {
		
	}
	
	private void dealDamage() {
		
		for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if(e.equals(this)) {
				continue;
			}
			
			if(e.getCollisionBounds(0, 0).contains(this.x, this.y)) {
				e.hurt(10);
			}
		}
	}
	

}
