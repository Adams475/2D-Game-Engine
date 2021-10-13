import java.io.Serializable;

public class BountyQuest extends Quest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 915924677073733272L;
	private World world;
	private Item reward;
	private Entity target;
	
	public BountyQuest(Handler handler, String title, String description, String type, Entity target, Item reward, Player player, World world, int exp) {
		super(handler, title, description, type, player, exp);
		this.world = world;
		this.target = target;
		this.reward = reward;
	}

	@Override
	public void checkCompleted() {
		for(int i = 0; i < world.getEntityManager().getEntities().size(); i++) {
			if(!world.getEntityManager().getEntities().contains(target)) {
				completeQuest();
				player.setDisplayBox(reward, this);
				return;
			}
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
		player.addExp(exp);
	}

}
