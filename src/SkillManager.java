import java.util.ArrayList;

public class SkillManager {

	private Handler handler;
	private int skillPoints = 10;
	private ArrayList<Skill> skills = new ArrayList<Skill>();
	private SkillList skillList = new SkillList(handler);
	
	public SkillManager(Handler handler) {
		this.handler = handler;
		skills.add(skillList.melee1);
		
	}
	
	public void tick() {
		updatePlayerValues();
	}
	
	private void updatePlayerValues() {
		
		for(int i = 0; i < skills.size(); i++) {
			
			if(skills.get(i).type.equals("melee")) {
				handler.getWorld().getEntityManager().getPlayer().setSkillAttack(skills.get(i).damageInc + i * 5);
			}
			
			if(skills.get(i).type.equals("crit")) {
				handler.getWorld().getEntityManager().getPlayer().setSkillCrit(skills.get(i).critInc + i * 1);
			}
			
			
		}
	}
	
	public void addMeleeSkill() {
		skills.add(skillList.melee1);
	}
	
	public void addCritSkill() {
		skills.add(skillList.crit1);
	}

	public int getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}

	public ArrayList<Skill> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skill> skills) {
		this.skills = skills;
	}

	public SkillList getSkillList() {
		return skillList;
	}

	public void setSkillList(SkillList skillList) {
		this.skillList = skillList;
	}
	
	
	
	
}
