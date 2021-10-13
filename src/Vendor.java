import java.io.Serializable;

public abstract class Vendor extends Creature implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5539251797163630112L;
	protected Inventory inventory;
	
	public Vendor(Handler handler, float x, float y, int width, int height, Inventory inventory) {
		super(handler, x, y, width, height);
		this.inventory = inventory;
	}
	
	//GETTERS / SETTERS
	public Inventory getInv(){
		return inventory;
	}
	
	public void setInv(Inventory i) {
		inventory = i;
	}
	
}
