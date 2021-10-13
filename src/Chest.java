import java.awt.Graphics;
import java.io.Serializable;

public class Chest extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4095869842042066014L;
	private boolean opened = false;
	
	Item item;
	
	public Chest(Handler handler, float x, float y, int width, int height, Item item) {
		super(handler, x, y, width, height);
		bounds.height = height * 4 - 20;
		bounds.width = width * 4;
		this.item = item;
		health = 1;
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		if(!opened) {
			g.drawImage(Assets.chestClosed, (int) (x - handler.getGameCamera().getxOffset()), 
					(int) (y - handler.getGameCamera().getyOffset()), width * 4, height * 4, null);
			
		} else {
			g.drawImage(Assets.chestOpen, (int) (x - handler.getGameCamera().getxOffset()), 
					(int) (y - handler.getGameCamera().getyOffset()), width * 4, height * 4, null);
		
		}
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		
		if(!opened) {
			opened = !opened;

		} else {
			return;
		}
		
		handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this.item);
		
	}

}
