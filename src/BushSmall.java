import java.awt.Graphics;
import java.util.Random;

public class BushSmall extends StaticEntity {
	
	private Random rand;

	public BushSmall(Handler handler, float x, float y) {
		super(handler, x, y, 16 * scaleEntity, 14 * scaleEntity);
		
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


