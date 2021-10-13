import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class LongWall extends StaticEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6962304384035089403L;
	private Random rand;

	public LongWall(Handler handler, float x, float y) {
		super(handler, x, y, 200 * scaleEntity, 14 * scaleEntity);
		
		bounds.x -= 4;
		rand = new Random();
		
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void die() {
		for (int i = 0; i <= rand.nextInt(10) + 1; i++) {
			handler.getWorld().getItemManager().addItem(Item.coinItem.createNew((int)x + rand.nextInt(25), (int)y + rand.nextInt(25)));
		}

	}


	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.bush, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}
	
	public void interact() {
		handler.getWorld().getEntityManager().getPlayer().getInventory().coins += 1;
		
	}



}


