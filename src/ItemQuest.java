import java.io.Serializable;

public class ItemQuest extends Quest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4764841542791528160L;
	private Item item;
	private Item reward;

	public ItemQuest(Handler handler, String title, String description, Item item, Item reward, String type, Player player, int exp) {
		super(handler, title, description, type, player, exp);
		this.item = item;
		this.reward = reward;
		
	}

	@Override
	public void checkCompleted() {
		if(player.getInventory().contains(item)) {
			completeQuest();
			player.setDisplayBox(reward, this);
		}
		
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

	

}
