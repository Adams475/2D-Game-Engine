
public class SkillList {
	
	Handler handler;
	//melee skills
	
	public Skill melee1 = new Skill(handler, "melee", 5, 0);
	public Skill crit1 = new Skill(handler, "crit", 1, 0);
	
	
	public SkillList(Handler handler){
		this.handler = handler;
	}
	


}
