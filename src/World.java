import java.awt.Graphics;
import java.io.Serializable;

public class World implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6832396738974790262L;
	private transient Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private boolean raining;
	//private RainDrop drops[] = new RainDrop[1000];
	//Entities
	private EntityManager entityManager;
	
	private ItemManager itemManager;
	
	public World(Handler handler, String path) {
		this.handler = handler;
		itemManager = new ItemManager(handler);
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		//for(int i = 0; i < drops.length; i++) {
			//drops[i] = new RainDrop();
		//}
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		itemManager.tick();		
		entityManager.tick();
		
		if(raining) {
//			for(int i = 0; i < drops.length; i++) {
//				drops[i].tick();
//			}
		}
		
	}
	
	public void render(Graphics g) {
		//makes it so only camera is rendered
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);
		
		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()), Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
			}
		}
		//Items
		itemManager.render(g);
		//Entities
		entityManager.render(g);
		
		if(raining) {
//			for(int i = 0; i < drops.length; i++) {
//				drops[i].render(g);
//			}
			
			State.setState(handler.getGame().worldMapState);
		}
		
	}
	
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.grassTile;
		return t;
	}
	
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4] );
			}
		}
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean isRaining() {
		return raining;
	}

	public void setRaining(boolean raining) {
		this.raining = raining;
	}

	
	

}
