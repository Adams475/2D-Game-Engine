import java.awt.Graphics;
import java.io.Serializable;

public class SettingState extends State implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1800723601701893477L;
	private UIManager uiManager;

	public SettingState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(100, 100, 150, 50, Assets.btn_inc_pos, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().getMenuState());
				State.getState().init();
			}}));
	}
		
	public void tick() {
		
		uiManager.tick();
	}

	public void render(Graphics g) {
		uiManager.render(g);
		
	}

	@Override
	public void init() {
		handler.getMouseManager().setUIManager(uiManager);
		
	}
	
	

}