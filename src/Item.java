import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Item {
	
	static Animation coinSpin1 = new Animation(125, Assets.coin_spin);
	static Animation iceBallUp = new Animation(125, Assets.ice_shot_up);
	static Animation iceBallRight = new Animation(125, Assets.ice_shot_right);
	static Animation iceBallDown = new Animation(125, Assets.ice_shot_down);
	static Animation iceBallLeft = new Animation(125, Assets.ice_shot_left);
	
	//Universal Item Types

	/* Item Id List
	 * 0 - Coin
	 * 3 - Nothing
	 * 4 - Basic Chestplate
	 * 5 - Basic Sword
	 * 6 - Blue Sword
	 * 7 - Basic Shield
	 * 8 - Health Potion
	 * 9 - Mana Potion
	 * 10 - Swiftness Potion
	 * 
	 */

	/* Item Type Structuring:
	 * -1 - Nothing
	 * 0 - Staffs
	 * 1 - Swords
	 * 2 - Bombs
	 * 3 - 
	 * 10 - Shields
	 * 11 - Armor
	 * 12 -
	 * 20 - Health Potion
	 * 21 - Speed Potion
	 * 22 - 
	 * 99 - coin
	 * 
	 */
	//Syntax for constructor:
	//(texture, name, id, type, width, height, armor value, attack value, gold value, description, animation boolean, animation)
	
	public static Item[] items = new Item[256];
	
	public static Item coinItem = new Item(Assets.coin, "coin", 0, 99, 10, 10, 0, 0, 1, "", true, coinSpin1);
	
	public static Item nothing = new Item(Assets.nothing, "nothing", 3, -1,
			10, 10, 0, 0, 0, "");
	
	public static Item swordStarter = new Item(Assets.swordStarter, "Basic Sword", 5, 1,
			14, 22, 0, 5, 5, "A rusty old thing, its seen better days. This is alex's sword. Wooohoo");
	
	public static Item blueSword = new Item(Assets.swordBlue, "Blue Sword", 6, 1, 
			14, 22, 0, 100, 5, "A blue sword. It seems to shimmer when you look at it.");
	
	public static Item armorStarter = new Item(Assets.chestPlate, "chestPlate", 4, 11,
			14, 22, 10, 0, 5, "Standard leather armor. Comfortable but not invincible.");
	
	public static Item shieldStarter = new Item(Assets.shieldStarter, "Basic Shield", 7, 10, 
			14, 22, 5, 0, 1, "A basic shield. It's been through some things.");
	
	public static Item crystalWand = new Item(Assets.crystalWandA, "Crystal Wand", 11, 0, 14, 22, 0, 34, 20, "wand");
	
	public static Item hpPotion = new Item(Assets.healthPotion, "Health Potion", 8, 20, 14, 22, 0, 0, 5, "fix");
	public static Item mpPotion = new Item(Assets.manaPotion, "Mana Potion", 9, 20, 14, 22, 0, 0, 5, "fix");
	public static Item spPotion = new Item(Assets.swiftPotion, "Speed Potion", 10, 20, 14, 22, 0, 0, 5, "fix");
	
	
	//Class
	public static final int ITEMWIDTH = 2, ITEMHEIGHT = 2;

	protected transient Handler handler;
	protected Animation projectile;
	protected transient BufferedImage texture;
	protected String name;
	protected int id;
	protected int wid, hei;
	protected Rectangle bounds;
	protected transient Animation anim;
	protected int type;
	protected int armorValue;
	protected int attackValue;
	protected int goldValue;
	protected String description;
	protected int x, y, count;
	protected boolean pickedUp = false;
	protected boolean hasAnimation;
	//Items With Animation
	public Item(BufferedImage texture, String name, int id, 
			int type, int wid, int hei, int armorValue, int attackValue, int goldValue, String description, boolean hasAnimation, Animation anim) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		this.wid = wid;
		this.hei = hei;
		this.type = type;
		this.armorValue = armorValue;
		this.attackValue = attackValue;
		this.goldValue = goldValue;
		this.description = description;
		this.hasAnimation = hasAnimation;
		this.anim = anim;
		
		bounds = new Rectangle(x, y, wid * ITEMWIDTH, hei * ITEMHEIGHT);		
		
		items[id] = this;
	}
	//Items without Animation
	public Item(BufferedImage texture, String name, int id, 
			int type, int wid, int hei, int armorValue, int attackValue, int goldValue, String description) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		this.wid = wid;
		this.hei = hei;
		this.type = type;
		this.armorValue = armorValue;
		this.attackValue = attackValue;
		this.goldValue = goldValue;
		this.description = description;
		
		bounds = new Rectangle(x, y, wid * ITEMWIDTH, hei * ITEMHEIGHT);		
		
		items[id] = this;
	}
	public Item(BufferedImage texture, String name, int id, 
			int type, int wid, int hei, int armorValue, int attackValue, int goldValue, String description, Animation projectile) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		this.wid = wid;
		this.hei = hei;
		this.type = type;
		this.armorValue = armorValue;
		this.attackValue = attackValue;
		this.goldValue = goldValue;
		this.description = description;
		this.projectile = projectile;
		
		bounds = new Rectangle(x, y, wid * ITEMWIDTH, hei * ITEMHEIGHT);		
		
		items[id] = this;
	}
	
	public void tick() {
		anim.tick();
		if(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	public void render(Graphics g) {
		if(handler == null) {
			return;
		}
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y) {
		if(hasAnimation) {
			g.drawImage(anim.getCurrentFrame(), x, y, wid*ITEMWIDTH, hei*ITEMHEIGHT, null);
			
		} else {
			g.drawImage(texture, x, y, wid*ITEMWIDTH, hei*ITEMHEIGHT, null);
		}
	}
	
	
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		bounds.x = x;
		bounds.y = y;
	}
	
	
	public Item createNew(int x, int y) {
		Item i = new Item(texture, name, id, type, wid, hei, armorValue, attackValue, goldValue, description, hasAnimation, anim);
		i.setPosition(x, y);
		return i;
	}
	
	public Item createNew(int count) {
		Item i = new Item(texture, name, id, type, wid, hei, armorValue, attackValue, goldValue, description, hasAnimation, anim);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
	
}
