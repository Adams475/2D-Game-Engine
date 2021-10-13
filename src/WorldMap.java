import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class WorldMap extends State {
	
	private Handler handler;
	private int width;
	private int height;
	private int[][] tiles;
	
	public WorldMap(Handler handler) {
		super(handler);
		this.handler = handler;
		init();
	}

	@Override
	public void tick() {
		
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {
			State.setState(handler.getGame().gameState);
		}
		
	}

	@Override
	public void render(Graphics g) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(g, (int) (x * 4 + (Launcher.SCREEN_WIDTH / 2) - ( (width * 4) / 2) ), 
						(int) (y * 4 + (Launcher.SCREEN_HEIGHT / 2) - ( (width*4) / 2) ), 8, 8);
			}
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
		
		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4] );
			}
		}
		
	}

	@Override
	public void init() {
		//loadWorld("res/worlds/world1.txt");
		
	}
	
	
	
	

}
