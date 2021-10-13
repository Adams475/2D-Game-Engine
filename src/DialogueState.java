import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class DialogueState extends State implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6853112787133431152L;
	private Creature creature;
	private BufferedImage background;
	private Rectangle dialogueBox = new Rectangle(468, 135, 418, 100);
	private Rectangle text1 = new Rectangle(115, 702 - Assets.btn_text[0].getHeight() * 2, 
			Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight());
	private Rectangle text2 = new Rectangle(115, 702 - Assets.btn_text[0].getHeight(), Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight());
	private Rectangle text3 = new Rectangle(115, 702, Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight());
	private Rectangle[] options = {text1, text2, text3};
	private UIManager uiManager;
	private ArrayList<Quest> giveableQuests;
	private ArrayList<String> questOptions = new ArrayList<String>() {/**
		 * 
		 */
		private static final long serialVersionUID = -3203183283527586242L;

	{		
		add("Yes");
		add("No");
		add("(Walk away)");
	}};
	private int dialogueIndex = 0;
	
	public DialogueState(Handler handler, Creature creature, BufferedImage background, ArrayList<Quest> giveableQuests) {
		super(handler);
		
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		this.background = background;
		this.creature = creature;
		this.giveableQuests = giveableQuests;
		
		//left arrow		
//		uiManager.addObject(new UIImageButton(475, 360, 19 * 4, 8 * 4, Assets.questLeft, new ClickListener() {
//			
//		
//			@Override
//			public void onClick() {
//				if(dialogueIndex > 0) {
//					dialogueIndex--;
//				}
//				
//			}}));
//		
//		//Right Arrow
//		uiManager.addObject(new UIImageButton(800, 360, 19 * 4, 8 * 4, Assets.questRight, new ClickListener() {
//
//			@Override
//			public void onClick() {
//				if(dialogueIndex < creature.dialogueList.size() - 1) {
//					dialogueIndex++;
//				}
//				
//			}}));
		
		//top text
		uiManager.addObject(new UIImageButton(115, 702 - Assets.btn_text[0].getHeight() * 2, 
				Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight(), Assets.btn_text, new ClickListener() {

			@Override
			public void onClick() {
				if(!giveableQuests.isEmpty()) {
					handler.getWorld().getEntityManager().getPlayer().getQuests().add(giveableQuests.get(0));
					creature.giveableQuests.clear();
				} else {
					if(dialogueIndex < creature.dialogueList.size() - 2) {
						dialogueIndex++;
					} else {
						State.setState(handler.getGame().gameState);
						handler.getMouseManager().setUIManager(null);
					}
				}
				
			}}));
		//middle text
		uiManager.addObject(new UIImageButton(115, 702 - Assets.btn_text[0].getHeight(), Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight(), Assets.btn_text, new ClickListener() {

			@Override
			public void onClick() {
				creature.giveableQuests.clear();
				
			}}));
		//bottom text
		uiManager.addObject(new UIImageButton(115, 702, Assets.btn_text[0].getWidth(),  Assets.btn_text[0].getHeight(), Assets.btn_text, new ClickListener() {

			@Override
			public void onClick() {
				State.setState(handler.getGame().gameState);
				handler.getMouseManager().setUIManager(null);
				
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics g) {
		//first layer
		//g.drawImage(background, 0, 0, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT, null);

		g.drawImage(Assets.conversationUI, 0, 0, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT, null);
		g.setColor(Color.WHITE);
		
		if(giveableQuests.isEmpty()) {
			FontHandler.drawFont(g, creature.dialogueList.get(dialogueIndex), dialogueBox, FontLoader.highTower);
		} else {
			FontHandler.drawFont(g, "I have a quest for you. " + giveableQuests.get(0).description + ". Would you like to accept?   ", dialogueBox, FontLoader.highTower);
		}
		
		uiManager.render(g);
		if(giveableQuests.isEmpty()) {
			for(int i = 0; i < 3; i++) {
				FontHandler.drawFont(g, creature.dialogueOptions.get(i + dialogueIndex * 3), options[i], FontLoader.bigF);
			}
		} else {
			for(int i = 0; i < 3; i++) {
				FontHandler.drawFont(g, questOptions.get(i), options[i], FontLoader.bigF);
			}
		}
	}

	@Override
	public void init() {
		handler.getMouseManager().setUIManager(uiManager);
		
	}

}
