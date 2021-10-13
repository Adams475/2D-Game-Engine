import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class WizardVendor extends Vendor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6773429649239157818L;
	private Inventory inventory;
	private int width, height;
	private transient BufferedImage texture;
	private boolean close;

	public WizardVendor(Handler handler, float x, float y, int width, int height, Inventory inventory) {
		super(handler, x, y, width, height, inventory);
		this.width = width * 4;
		this.height = height * 4;
		this.bounds.width = width * 4;
		this.bounds.height = height * 4;
		this.inventory = inventory;
		this.texture = Assets.mageM_idle[3];
		
	}

	@Override
	public void tick() {
		
		checkPlayer();
		
		if(close && handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			this.getInv().setActive(true);
			State.setState(new VendorState(handler, this.inventory));
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkPlayer() {
		
		if(Math.abs(handler.getWorld().getEntityManager().getPlayer().getX() - x + 20) < 100 && Math.abs(handler.getWorld().getEntityManager().getPlayer().getY() - y + 20) < 150) {
			close = true;
		} else {
			close = false;
		}
		
	}

}
