import java.awt.Graphics;

public class SkillState extends State{

	private static final long serialVersionUID = -8479080241939924883L;
	private UIManager uiManager;
	
	
	public SkillState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(400, 260, 200, 50, Assets.btn_blank, new ClickListener() {

			@Override
			public void onClick() {
				if(handler.getWorld().getEntityManager().getPlayer().getSkillManager().getSkillPoints() > 0) {
					handler.getWorld().getEntityManager().getPlayer().getSkillManager().setSkillPoints(handler.getWorld().getEntityManager().getPlayer().getSkillManager().getSkillPoints() - 1);
					handler.getWorld().getEntityManager().getPlayer().getSkillManager().addMeleeSkill();
					State.setState(handler.getGame().gameState);
				}
			}}));
		
		uiManager.addObject(new UIImageButton(400, 460, 200, 50, Assets.btn_blank, new ClickListener() {

			@Override
			public void onClick() {
				if(handler.getWorld().getEntityManager().getPlayer().getSkillManager().getSkillPoints() > 0) {
					handler.getWorld().getEntityManager().getPlayer().getSkillManager().setSkillPoints(handler.getWorld().getEntityManager().getPlayer().getSkillManager().getSkillPoints() - 1);
					handler.getWorld().getEntityManager().getPlayer().getSkillManager().addCritSkill();
					State.setState(handler.getGame().gameState);
				}
			}}));
		
		

		
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

	@Override
	public void init() {
		handler.getMouseManager().setUIManager(uiManager);
		
	}

}
