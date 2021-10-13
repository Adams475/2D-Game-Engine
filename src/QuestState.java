import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

public class QuestState extends State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8065244158744841032L;
	public Point centerScreen = new Point(Launcher.SCREEN_WIDTH/2, Launcher.SCREEN_HEIGHT/2);
	private UIManager uiManager;
	private int pageIndex = 0;
	private boolean active[] = new boolean[30];
	private int buttonNums[] = new int[30];
	
	public QuestState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		for(int i = 0; i < buttonNums.length; i++) {
			buttonNums[i] = i;
		}
		
		//exit button
		uiManager.addObject(new UIImageButton(20, Launcher.SCREEN_HEIGHT - 8 * 4, 19 * 4, 8 * 4, Assets.questLeft, new ClickListener() {
			
			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
				handler.getWorld().getEntityManager().getPlayer().getInventory()
				.setCurrentInv(handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryAttack());
				
			}}));
		
		//Left Arrow
		
		uiManager.addObject(new UIImageButton(160, 215, 19 * 4, 8 * 4, Assets.questLeft, new ClickListener() {
			
			@Override
			public void onClick() {
				if(pageIndex > 0) {
					pageIndex--;
				}
				
			}}));
		
		//Right Arrow
		
		uiManager.addObject(new UIImageButton(795, 215, 19 * 4, 8 * 4, Assets.questRight, new ClickListener() {

			@Override
			public void onClick() {
				if(pageIndex < 11) {
					pageIndex++;
				}
				
			}}));
		
		//LEFT SIDE
		
		uiManager.addObject(new UIImageButton(148, 298, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 1
			
			
			@Override
			public void onClick() {
				if(!active[buttonNums[0 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(buttonNums[0] + 6 * pageIndex )));
				
			}}));
		
		uiManager.addObject(new UIImageButton(148, 298 + 104, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 2
			
			@Override
			public void onClick() {
				if(!active[buttonNums[1 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(1 + 6 * pageIndex)));
				
			}}));
		
		uiManager.addObject(new UIImageButton(148, 298 + 104 * 2, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 3
			
			@Override
			public void onClick() {
				if(!active[buttonNums[2 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(2 + 6 * pageIndex)));
				
			}}));
		
		//RIGHT SIDE
		
		uiManager.addObject(new UIImageButton(524, 298, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 4
			
			@Override
			public void onClick() {
				if(!active[buttonNums[3 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(3 + 6 * pageIndex)));
				
			}}));
		
		uiManager.addObject(new UIImageButton(524, 298 + 104, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 5
			
			@Override
			public void onClick() {
				if(!active[buttonNums[4 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(4 + 6 * pageIndex)));
				
			}}));
		
		uiManager.addObject(new UIImageButton(524, 298 + 104 * 2, 10 * 4, 10 * 4, Assets.questButton, new ClickListener() { // 6
			
			@Override
			public void onClick() {
				if(!active[buttonNums[5 + 6 * pageIndex]]) {
					return;
				}
				State.setState(new QuestDisplayState(handler, 
						handler.getWorld().getEntityManager().getPlayer().getQuests().get(5 + 6 * pageIndex)));
				
			}}));
		
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.questScreen, centerScreen.x - Assets.questScreen.getWidth() * 4 / 2, 
				centerScreen.y - Assets.questScreen.getWidth() - 20,
				Assets.questScreen.getWidth() * 4 + 1, Assets.questScreen.getHeight() * 4 + 1, null);
		uiManager.render(g);
		
		g.setColor(Color.BLACK);
		
		g.setFont(Assets.font28nBold);
		g.drawString("Page: " + (pageIndex + 1), centerScreen.x - 45, centerScreen.y + 276);
		
		
		
		for(int i = 0 + 6 * pageIndex; i < handler.getWorld().getEntityManager().getPlayer().getQuests().size(); i++) {
			FontHandler.drawFont(g, handler.getWorld().getEntityManager().getPlayer().getQuests().get(i).title, 
					new Rectangle(198, 304 + 104 * i, 300, 0), FontLoader.highTower);
		}
		
	}

	@Override
	public void init() {
		
		handler.getMouseManager().setUIManager(uiManager);
		for(int i = 0; i < active.length; i++) {
			if(i < handler.getWorld().getEntityManager().getPlayer().getQuests().size()) {
				active[i] = true;
				
			} else {
				active[i] = false;
				
			}
		}
	
	}

}
