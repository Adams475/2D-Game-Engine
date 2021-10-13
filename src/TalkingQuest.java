import java.io.Serializable;

public class TalkingQuest extends Quest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5531148279930888878L;
	private Creature creature;
	private Item reward;
	private String description;
	private String type;
	
	public TalkingQuest(Handler handler, String title, String description, Creature creature, Item reward, String type, Player player, int exp) {
		super(handler, title, description, type, player, exp);
		this.creature = creature;
		this.reward = reward;
		System.out.println(creature);
	}

	@Override
	public void completeQuest() {
		player.getCompletedQuests().add(this);
		player.removeQuest(this);
		giveReward();
	}

	@Override
	public void giveReward() {
		player.getInventory().addItem(reward);
		
	}

	@Override
	public void checkCompleted() {
		
		if(creature.isTalkedTo) {
			player.setDisplayBox(reward, this);
			completeQuest();
		}
		
		
		
	}

}
