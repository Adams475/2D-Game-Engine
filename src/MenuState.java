import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
//Dimension of screen(for me) = 1024, 762
public class MenuState extends State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5133242982803095355L;

	private UIManager uiManager;
	
	Font title = new Font("High Tower Text", Font.BOLD, 45);
	Font menuButton = new Font("High Tower Text", Font.BOLD, 30);
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(400, 260, 200, 50, Assets.btn_blank, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().getGameState());
			}}));
		
		uiManager.addObject(new UIImageButton(400, 350, 200, 50, Assets.btn_blank, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				//SettingState settingState = new SettingState(handler);
				LoadGame l = new LoadGame(handler);
				l.loadGame();
				State.setState(handler.getGame().gameState);
				
			}}));
		
		uiManager.addObject(new UIImageButton(400, 440, 200, 50, Assets.btn_blank, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(0);
			}}));
		
	}
	
	public void tick() {
		if(handler.getMouseManager().isLeftPressed()) {
		}
		uiManager.tick();
	}

	public void render(Graphics g) {
		//Draw
		uiManager.render(g);
		g.setFont(title);
		g.drawString("PlaceHolderName", 300, 100);
		
		g.setFont(menuButton);
		if(!uiManager.getObjects().get(0).hovering) {
			g.setColor(Color.WHITE);
			g.drawString("Start", 464, 293);
		}else {
			g.setColor(Color.BLACK);
			g.drawString("Start", 464, 293);
		}
		
		if(!uiManager.getObjects().get(1).hovering) {
			g.setColor(Color.WHITE);
			g.drawString("Settings", 445, 383);
		}else {
			g.setColor(Color.BLACK);
			g.drawString("Settings", 445, 383);
		}
		
		if(!uiManager.getObjects().get(2).hovering) {
			g.setColor(Color.WHITE);
			g.drawString("Quit", 465, 472);
		}else {
			g.setColor(Color.BLACK);
			g.drawString("Quit", 465, 472);
		}
		
		
		
	}

	@Override
	public void init() {
		
		handler.getMouseManager().setUIManager(uiManager);
	}
	
	

}