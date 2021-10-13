public class GPM {

	//Stands for game progression manager
	
	private String gameStage = "tutorial";
	private Handler handler;
	
	public GPM(Handler handler) {
		this.handler = handler;
	}
	
	public void tick() {
		
		
	}

	public String getGameStage() {
		return gameStage;
	}

	public void setGameStage(String gameStage) {
		this.gameStage = gameStage;
	}
	
	

}
