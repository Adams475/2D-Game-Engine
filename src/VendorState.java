
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class VendorState extends State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5759118731862727095L;
	private UIManager uiManager;
	private Inventory inventory;
	private int centerScreenX = 1024/2, centerScreenY = 768/2;
	private int topLeftX = centerScreenX - (Assets.vendorScreen.getWidth() * 4 / 2), topLeftY = centerScreenY - (Assets.vendorScreen.getHeight() * 4 / 2);
	private Rectangle clickBounds = new Rectangle(centerScreenX - 1, 278, 338, 200);
	private Rectangle clickBoundsPlayer = new Rectangle(centerScreenX - 270 - 278/2, 278, 338, 200);
	private int highX = 0, highY = -50, highXP = 0, highYP = -50;
	
	public VendorState(Handler handler, Inventory inventory) {
		super(handler);
		this.inventory = inventory;
		inventory.init();
		inventory.setActive(true);
		handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(true);
		inventory.setCurrentInv(inventory.getInventoryAttack());
		
		this.inventory.setyOffset(88);
		this.inventory.setxOffset(178);	
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		//Sell Button
		uiManager.addObject(new UIImageButton( (topLeftX + 72 * 4) , (topLeftY + 111 * 4), 22 * 4, 11 * 4, Assets.btn_sell, new ClickListener() {

			@Override
			public void onClick() {
				int i = 0;
				for(int x = 0; x < 5; x++) {
					for(int y = 0; y < 3; y++) {
						if(x == highXP && y == highYP) {
							System.out.println(x + ", " + y);
							System.out.println(handler.getWorld().getEntityManager().getPlayer().getInventory().getCurrentInv().get(i).name);
							System.out.println(i);
							if(handler.getWorld().getEntityManager().getPlayer().getInventory().getCurrentInv().get(i) != Item.nothing) {
								inventory.addItem(handler.getWorld().getEntityManager().getPlayer().getInventory().getCurrentInv().get(i));
								handler.getWorld().getEntityManager().getPlayer().getInventory().coins += handler.getWorld().getEntityManager().getPlayer().getInventory().getCurrentInv().get(i).goldValue;
								handler.getWorld().getEntityManager().getPlayer().getInventory().setNothing(i, x, y);
							}
							
						}
						i++;
					}
					
				}
			}}));
		
		//BuyButton
		uiManager.addObject(new UIImageButton( (topLeftX + 174 * 4), (topLeftY + 111 * 4), 22 * 4, 11 * 4, Assets.btn_buy, new ClickListener() {

			@Override
			public void onClick() {
				int i = 0;
				for(int x = 0; x < 5; x++) {
					for(int y = 0; y < 3; y++) {
						if(x == highX && y == highY) {
							if(inventory.getCurrentInv().get(i) != Item.nothing && handler.getWorld().getEntityManager().getPlayer().getInventory().coins >= inventory.getCurrentInv().get(i).goldValue) {
								handler.getWorld().getEntityManager().getPlayer().getInventory().addItem(inventory.getCurrentInv().get(i));
								handler.getWorld().getEntityManager().getPlayer().getInventory().coins -= inventory.getCurrentInv().get(i).goldValue;
								inventory.setNothing(i, x, y);
							}
							
						}
						i++;
					}
					
				}
			}}));
		
		//Sword tab
		uiManager.addObject(new UIImageButton( (centerScreenX + 368), (topLeftY + 156), 14 * 4, 18 * 4, Assets.btn_sword, new ClickListener() {

			@Override
			public void onClick() {
				inventory.setDisplay(0);
				inventory.setCurrentInv(inventory.getInventoryAttack());
				handler.getWorld().getEntityManager().getPlayer().getInventory().setDisplay(0);
				handler.getWorld().getEntityManager().getPlayer().getInventory().setCurrentInv(handler.getWorld().getEntityManager().
						getPlayer().getInventory().getInventoryAttack());
			}}));
		
		//Armor Tab
		uiManager.addObject(new UIImageButton( (centerScreenX + 368), (topLeftY + 156 + 18 * 4), 14 * 4, 18 * 4, Assets.btn_armor, new ClickListener() {

			@Override
			public void onClick() {
				inventory.setDisplay(1);
				inventory.setCurrentInv(inventory.getInventoryArmor());
				handler.getWorld().getEntityManager().getPlayer().getInventory().setDisplay(1);
				handler.getWorld().getEntityManager().getPlayer().getInventory().setCurrentInv(handler.getWorld().getEntityManager().
						getPlayer().getInventory().getInventoryArmor());
			}}));
		
		//Potions Tab
		uiManager.addObject(new UIImageButton( (centerScreenX + 368), (topLeftY + 156 + 18 * 4 + 18 * 4), 14 * 4, 18 * 4, Assets.btn_potions, new ClickListener() {

			@Override
			public void onClick() {
				inventory.setDisplay(2);
				inventory.setCurrentInv(inventory.getInventoryPotions());
				handler.getWorld().getEntityManager().getPlayer().getInventory().setDisplay(2);
				handler.getWorld().getEntityManager().getPlayer().getInventory().setCurrentInv(handler.getWorld().getEntityManager().
						getPlayer().getInventory().getInventoryPotions());
			}}));
		
		//Exit button
		uiManager.addObject(new UIImageButton(852, 109, 26*4, 32*4, Assets.btn_exit, new ClickListener() {

			@Override
			public void onClick() {
				handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(false);
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}}));
		
	}

	

	public void tick() {
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			inventory.sort();
			handler.getWorld().getEntityManager().getPlayer().getInventory().sort();
		}
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
			handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(false);
			handler.getMouseManager().setUIManager(null);
			State.setState(handler.getGame().gameState);
		}
		
		if(handler.getMouseManager().isLeftPressed()) {
			if(clickBounds.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())) {
				highX = (int) ( Math.floor( (handler.getMouseManager().getMouseX() - clickBounds.x) / (17 * 4) ) );
				highY = (int) ( Math.floor( (handler.getMouseManager().getMouseY() - clickBounds.y)  / (17 * 4) ) );
				
			}
			
			if(clickBoundsPlayer.contains(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY())) {
				highXP = (int) ( Math.floor( (handler.getMouseManager().getMouseX() - clickBoundsPlayer.x) / (17 * 4) ) );
				highYP = (int) ( Math.floor( (handler.getMouseManager().getMouseY() - clickBoundsPlayer.y)  / (17 * 4) ) );
				
			}
		}
		
		uiManager.tick();
		inventory.tick();
		
	}



	@Override
	public void render(Graphics g) {
		
		//Base Inventory Screen
		g.drawImage(Assets.vendorScreen, centerScreenX - (Assets.vendorScreen.getWidth() * 4 / 2), centerScreenY - (Assets.vendorScreen.getHeight() * 4 / 2), Assets.vendorScreen.getWidth() * 4, Assets.vendorScreen.getHeight() * 4, null);
		
		
		//UI Buttons
		uiManager.render(g);
	
		if(inventory.getDisplay() == 0) {
			g.drawImage(Assets.btn_sword[1], centerScreenX + 368, topLeftY + 156, 14 * 4, 18 * 4, null);
		} else if(inventory.getDisplay() == 1) {
			g.drawImage(Assets.btn_armor[1], centerScreenX + 368, topLeftY + 156 + 18 * 4, 14 * 4, 18 * 4, null);
		} else {
			g.drawImage(Assets.btn_potions[1], centerScreenX + 368, topLeftY + 156 + 18 * 8, 14 * 4, 18 * 4, null);
		}
		
		g.setColor(Color.YELLOW);
		g.setFont(Assets.fontPlaceHolder);
		g.drawString(Integer.toString(handler.getWorld().getEntityManager().getPlayer().getInventory().getCoins()), 420, 620);
		g.setColor(Color.WHITE);
		g.setFont(Assets.font28nBold);
		g.drawString("Gold", 359, 620);
		
		inventory.render(g);
		
		int i = 0;
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 3; y++) {
				g.drawImage(handler.getWorld().getEntityManager().getPlayer().getInventory().getCurrentInv().get(i).texture, 
						clickBoundsPlayer.x + inventory.invSlotDist * x + 9, clickBoundsPlayer.y + inventory.invSlotDist * y + 9, 48, 48, null);
				i++;
			}
		}
		
		g.drawImage(Assets.itemHighlighter, ( clickBounds.x + inventory.invSlotDist * highX + 4 + 1), ( clickBounds.y + inventory.invSlotDist * highY + 4) , 14*4, 14*4, null);
		g.drawImage(Assets.itemHighlighter, ( clickBoundsPlayer.x + inventory.invSlotDist * highXP + 4 + 1), ( clickBoundsPlayer.y + inventory.invSlotDist * highYP + 4) , 14*4, 14*4, null);
		g.setColor(Color.black);
		
		
	}



	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
