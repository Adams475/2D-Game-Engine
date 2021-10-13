
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1147827366269609042L;
	//Static Variables
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile stoneTile = new StoneTile(4);
	public static Tile rockTile = new RockTile(2);
	public static Tile bushTile = new BushTile(3);
	public static Tile FloorTile = new FloorTile(Assets.floorWood, 5);
	public static Tile StoneWallTile = new StoneWallTile(Assets.stoneWall, 6);
	public static Tile woodWallTile1 = new WoodWallTile1(Assets.indoorWallBottom, 7);
	public static Tile woodWallTile2 = new WoodWallTile2(Assets.indoorWallTop, 8);
	
	//Class
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected transient BufferedImage texture;
	protected final int id;

	//assigns ids to the tiles
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	//updates tiles
	public void tick() {
		
	}
	
	//renders tiles
	public void render(Graphics g, int x, int y, int width, int height) {
		g.drawImage(texture, x, y, width, height, null);
	}
	
	//getters
	public boolean isSolid() {
		return false;
		
	}
	
	public int getId() {
		return id;
	}
}
