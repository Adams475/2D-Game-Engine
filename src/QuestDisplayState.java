import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;	

public class QuestDisplayState extends State implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5816228678404178602L;
	private UIManager uiManager;
	private Quest quest;
	private Rectangle titleRect = new Rectangle(175, 70, 300, 50);
	private Rectangle description1Rect = new Rectangle(70, 140, 420, 560);

	public QuestDisplayState(Handler handler, Quest quest) {
		super(handler);
		this.quest = quest;
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(20, Launcher.SCREEN_HEIGHT - 8 * 4, 19 * 4, 8 * 4, Assets.questLeft, new ClickListener() {
			
			@Override
			public void onClick() {
				State.setState(handler.getGame().questState);
				handler.getMouseManager().setUIManager(null);
				handler.getGame().questState.init();
				
			}}));
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stubs
		uiManager.tick();

	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.bookPage, 0, 0, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT, null);
		FontHandler.drawFont(g, quest.title, titleRect, Assets.fontPlaceHolder);
		FontHandler.drawFont(g, quest.description, description1Rect, FontLoader.highTower);
		uiManager.render(g);
//		g.fillRect(titleRect.x, titleRect.y, titleRect.width, titleRect.height);
//		g.fillRect(description1Rect.x, description1Rect.y, description1Rect.width, description1Rect.height);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
