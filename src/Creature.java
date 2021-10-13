import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Creature extends Entity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121256062980048132L;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected float speed;
	protected float xMove, yMove;
	protected boolean isTalkedTo = false;
	protected boolean talks = false;
	protected ArrayList<ArrayList<String>> masterList = new ArrayList<ArrayList<String>>();
	protected ArrayList<ArrayList<String>> masterListD = new ArrayList<ArrayList<String>>();
	protected ArrayList<String> dialogueList = new ArrayList<String>();
	protected ArrayList<Quest> giveableQuests = new ArrayList<Quest>();
	protected ArrayList<String> dialogueOptions = new ArrayList<String>() {/**
		 * 
		 */
		private static final long serialVersionUID = 5515189782192590234L;

	{
		add("placeholder");
		add("placeholder");
		add("placeholder");
		
	}};
	
	protected boolean hasQuest = false;
	protected int expGive;
	
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		health = 100;
		
	}
	
	public void move() {
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();	
	}
	
	public void moveX() {
		if (xMove > 0) {//going right
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
			
		} else if (xMove < 0) { //going left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}else {
				x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
			}
		}
		
		
	}
	
	public void moveY() {
		if(yMove < 0) {//up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
			y += yMove;
			} else {
				y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
			}
			
		} else if (yMove > 0) {//down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_WIDTH;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
				!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
				y += yMove;
			}else {
				y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		
		return handler.getWorld().getTile(x, y).isSolid();
		
	}
	
	protected void drawHealth(Graphics g) {
//		g.setColor(Color.red);
//		g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - 40 - handler.getGameCamera().getyOffset()), 100, 20);
//		g.setColor(Color.green);
//		g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - 40 - handler.getGameCamera().getyOffset()), health, 20);
		
		
		
	}
	
	protected void updateQuests() {
		
		if(!talks) {
			return;
		}
		
		switch(handler.getGPM().getGameStage()) {
		case "tutorial":
			this.dialogueList = masterList.get(0);
			this.dialogueOptions = masterListD.get(0);
			break;
			
		case "sword stage":
			this.dialogueList = masterList.get(1);
			this.dialogueOptions = masterListD.get(1);
			break;
			
		case "post quest stage":
			this.dialogueList = masterList.get(2);
			this.dialogueOptions = masterListD.get(2);
			break;
			
		}
	}
	
	//GETTERS / SETTERS
	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
