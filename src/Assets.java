import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Assets implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3696428539177278541L;
	private static final int width = 16, height = 16;
	//public static final Font titleFont = new Font("High Tower Text", Font.BOLD, 60);
	
	//Stand-alone
	public static BufferedImage dirt, grass, stone, tree, rock, bush, 
	wood, coin, chestClosed, chestOpen, displayBoxRed, speechBubble, 
	vendorScreen, floorWood, stoneWall, stairs, tableTop, conversationUI, healthPotion, manaPotion, swiftPotion, crystalWandA,
	indoorWallTop, indoorWallBottom;
	//Player walk
	public static BufferedImage[] player_down, player_up, player_right, player_left, player_idle;
	public static BufferedImage[] player_down_bs, player_up_bs, player_right_bs, player_left_bs, player_idle_bs;
	//Player attack
	public static BufferedImage[] player_attack_down, player_attack_up, player_attack_right, player_attack_left;
	public static BufferedImage[] player_attack_downB, player_attack_rightB,  player_attack_upB,  player_attack_leftB;
	//Archer Female
	public static BufferedImage[] archF_down, archF_up, archF_right, archF_left, archF_idle;
	//Mage Male
	public static BufferedImage[] mageM_down, mageM_up, mageM_right, mageM_left, mageM_idle;
	public static BufferedImage[] mageM_downA, mageM_upA, mageM_rightA, mageM_leftA, mageM_idleA;
	//Fireball
	public static BufferedImage[] fb_left, fb_right, fb_up, fb_down;
	//Start Menu UI
	public static BufferedImage[] btn_start, btn_blank, btn_inc_pos, questLeft, questRight, questButton;
	//vendor UI
	public static BufferedImage[] btn_sell, btn_buy, btn_sword, btn_armor, btn_potions, btn_exit, btn_text;
	//Coin Spin :))
	public static BufferedImage[] coin_spin;
	public static BufferedImage[] ice_shot_up, ice_shot_down, ice_shot_left, ice_shot_right;
	

	public static BufferedImage inventoryScreen, itemHighlighter, nothing, heartFull, heartHalf, heartFourth, heartThreeFourths, heartEmpty;
	public static Font font28, font28nBold, fontPlaceHolder;
	public static BufferedImage parchment, tlCorner, trCorner, blCorner, brCorner, vertLine, horzLine;
	public static BufferedImage swordStarter, test, chestPlate, swordBlue, swordRed, swordGreen, swordBlack;
	public static BufferedImage tabHighlightSword, tabHighlightShield, tabHighlightPotion, tabHighlightQuest;
	public static BufferedImage questScreen, bookPage, questMark, expBar, face, expLeft, expMid, expRight;
	public static BufferedImage coin1, coin2, coin3, coin4;
	public static BufferedImage shieldStarter;
	
	static Animation coinSpin1 = new Animation(125, Assets.coin_spin);
	static Animation iceBallUp = new Animation(125, Assets.ice_shot_up);
	static Animation iceBallRight = new Animation(125, Assets.ice_shot_right);
	static Animation iceBallDown = new Animation(125, Assets.ice_shot_down);
	static Animation iceBallLeft = new Animation(125, Assets.ice_shot_left);
	
	
	public static void init() {
		
		//Load Sprite Sheets
		SpriteSheet sheetWorld = new SpriteSheet(ImageLoader.loadImage("/textures/Overworld.png"));
		SpriteSheet sheetCharacter = new SpriteSheet(ImageLoader.loadImage("/textures/character.png"));
		SpriteSheet overworldSpecial = new SpriteSheet(ImageLoader.loadImage("/textures/overworldSpecial.png"));
		SpriteSheet cave = new SpriteSheet(ImageLoader.loadImage("/textures/cave.png"));
		SpriteSheet menuUI = new SpriteSheet(ImageLoader.loadImage("/textures/uiMenu.png"));
		SpriteSheet invUI = new SpriteSheet(ImageLoader.loadImage("/textures/invMenu.png"));
		SpriteSheet objectSheet = new SpriteSheet(ImageLoader.loadImage("/textures/objects.png"));
		SpriteSheet parchmentSheet = new SpriteSheet(ImageLoader.loadImage("/textures/parchment.png"));
		SpriteSheet weaponsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/weapons.png"));
		SpriteSheet sw = new SpriteSheet(ImageLoader.loadImage("/textures/sword.png"));
		SpriteSheet overlayItems = new SpriteSheet(ImageLoader.loadImage("/textures/objects.png"));
		SpriteSheet blueSwordSwing = new SpriteSheet(ImageLoader.loadImage("/textures/swordSwingBlue.png"));
		SpriteSheet rangerFemale = new SpriteSheet(ImageLoader.loadImage("/textures/ranger_f.png"));
		SpriteSheet mageMale = new SpriteSheet(ImageLoader.loadImage("/textures/mage_m.png"));
		SpriteSheet castAnim = new SpriteSheet(ImageLoader.loadImage("/textures/mtt.png"));
		SpriteSheet fireBall = new SpriteSheet(ImageLoader.loadImage("/textures/fireball_0.png"));
		SpriteSheet vendorUI = new SpriteSheet(ImageLoader.loadImage("/textures/vendorUi.png"));
		SpriteSheet indoors = new SpriteSheet(ImageLoader.loadImage("/textures/Inner.png"));
		SpriteSheet bookPageSheet = new SpriteSheet(ImageLoader.loadImage("/textures/bookPage.png"));
		SpriteSheet invUIpat2 = new SpriteSheet(ImageLoader.loadImage("/textures/invUi.png"));
		SpriteSheet cvUI = new SpriteSheet(ImageLoader.loadImage("/textures/converstionUI.png"));
		SpriteSheet sheetCharacterBs = new SpriteSheet(ImageLoader.loadImage("/textures/characterBasicShield.png"));
		//303 225
		
		//more overlay
		expBar = objectSheet.crop(0, 226, 78, 53);
		face = objectSheet.crop(0, 280, 15, 15);
		expLeft = objectSheet.crop(22, 280, 3, 4);
		expMid = objectSheet.crop(25, 280, 2, 4);
		expRight = objectSheet.crop(27, 280, 3, 4);
		
		//walls
		indoorWallTop = indoors.crop(0, 48, 16, 16);
		indoorWallBottom = indoors.crop(0, 80, 16, 16);
		
		//shields
		shieldStarter = sw.crop(0, 18, 16, 14);
		
		//wands
		crystalWandA = sw.crop(18, 17, 15, 15);
		
		//Potions
		healthPotion = sw.crop(0, 32, 16, 16);
		manaPotion = sw.crop(16, 32, 16, 16);
		swiftPotion = sw.crop(32, 32, 16, 16);
		
		//ice projectile
		ice_shot_up = new BufferedImage[4];
		ice_shot_up[0] = sw.crop(4, 65, 7, 10);
		ice_shot_up[1] = sw.crop(20, 65, 7, 10);
		ice_shot_up[2] = sw.crop(36, 65, 7, 10);
		ice_shot_up[3] = sw.crop(52, 65, 7, 10);
		
		ice_shot_right = new BufferedImage[4];
		ice_shot_right[0] = sw.crop(4, 91, 10, 7);
		ice_shot_right[1] = sw.crop(16, 91, 10, 7);
		ice_shot_right[2] = sw.crop(29, 91, 10, 7);
		ice_shot_right[3] = sw.crop(41, 91, 10, 7);
		
		ice_shot_left = new BufferedImage[4];
		ice_shot_left[0] = sw.crop(4, 99, 10, 7);
		ice_shot_left[1] = sw.crop(17, 99, 10, 7);
		ice_shot_left[2] = sw.crop(29, 99, 10, 7);
		ice_shot_left[3] = sw.crop(41, 99, 10, 7);
		
		ice_shot_down = new BufferedImage[4];
		ice_shot_down[0] = sw.crop(4, 78, 7, 10);
		ice_shot_down[1] = sw.crop(20, 78, 7, 10);
		ice_shot_down[2] = sw.crop(36, 78, 7, 10);
		ice_shot_down[3] = sw.crop(52, 78, 7, 10);
		
		
		
		//Quest Menu
		questMark = indoors.crop(380, 204, 7, 17);
		
		btn_text = new BufferedImage[2];
		btn_text[1] = bookPageSheet.crop(77, 555, 794, 66);
		btn_text[0] = bookPageSheet.crop(77, 632, 794, 66);
		
		conversationUI = cvUI.crop(0, 0, Launcher.SCREEN_WIDTH, Launcher.SCREEN_HEIGHT);
		
		questLeft = new BufferedImage[2];
		questRight = new BufferedImage[2];
		questButton = new BufferedImage[2];
		
		questLeft[0] = indoors.crop(313, 206, 20, 9);
		questLeft[1] = indoors.crop(313, 215, 20, 9);
		
		questRight[0] = indoors.crop(335, 206, 20, 9);
		questRight[1] = indoors.crop(335, 215, 20, 9);
		
		questButton[0] = indoors.crop(359, 204, 10, 10);
		questButton[1] = indoors.crop(359, 214, 10, 10);
		
		bookPage = bookPageSheet.crop(0, 0, 627, 409);
		
		questScreen = indoors.crop(303, 225, 200, 135);
		
		
		//Floor Tiles
		floorWood = indoors.crop(0, 16, 16, 16);
		stoneWall = sheetWorld.crop(367, 15, 16, 16);
		stairs = indoors.crop(0, 240, 32, 32);
		tableTop = indoors.crop(225, 112, 27, 45);
		
		//Vendor screen
		vendorScreen = vendorUI.crop(363, 0, 224, 139);
		
		//Vendor Buttons
		btn_sell = new BufferedImage[2];
		btn_buy = new BufferedImage[2];
		btn_sword = new BufferedImage[2];
		btn_potions = new BufferedImage[2];
		btn_armor = new BufferedImage[2];
		btn_exit = new BufferedImage[2];
		
		btn_sell[0] = vendorUI.crop(515, 145, 22, 11);
		btn_sell[1] = vendorUI.crop(515, 156, 22, 11);
		
		btn_buy[0] = vendorUI.crop(537, 145, 22, 11);
		btn_buy[1] = vendorUI.crop(537, 156, 22, 11);
		
		btn_sword[1] = invUI.crop(467, 275, 481-467, 293-275);
		btn_sword[0] = invUI.crop(488, 275, 481-467, 293-275);
		
		btn_armor[1] = invUI.crop(467, 293, 481-467, 293-275);
		btn_armor[0] = invUI.crop(488, 293, 481-467, 293-275);
		
		btn_potions[1] = invUI.crop(467, 311, 481-467, 293-275);
		btn_potions[0] = invUI.crop(488, 311, 481-467, 293-275);
		
		btn_exit[1] = vendorUI.crop(541, 168, 26, 32);
		btn_exit[0] = vendorUI.crop(515, 168, 26, 32); 
		
		//Coin spin
		coin_spin = new BufferedImage[4];
		coin_spin[0] = objectSheet.crop(2, 66, 11, 11);
		coin_spin[1] = objectSheet.crop(18, 66, 11, 11);
		coin_spin[2] = objectSheet.crop(38, 66, 11, 11);
		coin_spin[3] = objectSheet.crop(51, 66, 11, 11);
		
		//Fireball
		fb_left = new BufferedImage[8];
		fb_right = new BufferedImage[8];
		fb_up = new BufferedImage[8];
		fb_down = new BufferedImage[8];

		fb_left[0] = fireBall.crop(2, 22, 52, 18);
		fb_left[1] = fireBall.crop(65, 22, 52, 18);
		fb_left[2] = fireBall.crop(130, 22, 52, 18);
		fb_left[3] = fireBall.crop(195, 22, 52, 18);
		fb_left[4] = fireBall.crop(258, 22, 52, 18);
		fb_left[5] = fireBall.crop(322, 22, 52, 18);
		fb_left[6] = fireBall.crop(385, 22, 52, 18);
		fb_left[7] = fireBall.crop(450, 22, 52, 18);
		
		fb_right[0] = fireBall.crop(10, 277, 56, 18);
		fb_right[1] = fireBall.crop(72, 277, 56, 18);
		fb_right[2] = fireBall.crop(136, 277, 56, 18);
		fb_right[3] = fireBall.crop(194, 277, 56, 18);
		fb_right[4] = fireBall.crop(268, 277, 56, 18);
		fb_right[5] = fireBall.crop(328, 277, 56, 18);
		fb_right[6] = fireBall.crop(393, 277, 56, 18);
		fb_right[7] = fireBall.crop(456, 277, 56, 18);
		
		fb_up[0] = fireBall.crop(24, 140, 16, 32);
		fb_up[1] = fireBall.crop(87, 140, 16, 32);
		fb_up[2] = fireBall.crop(152, 140, 16, 32);
		fb_up[3] = fireBall.crop(216, 140, 16, 32);
		fb_up[4] = fireBall.crop(281, 140, 16, 32);
		fb_up[5] = fireBall.crop(344, 140, 16, 32);
		fb_up[6] = fireBall.crop(408, 140, 16, 32);
		fb_up[7] = fireBall.crop(472, 140, 16, 32);
		
		fb_down[0] = fireBall.crop(24, 403, 16, 32);
		fb_down[1] = fireBall.crop(87, 403, 16, 32);
		fb_down[2] = fireBall.crop(152, 403, 16, 32);
		fb_down[3] = fireBall.crop(216, 403, 16, 32);
		fb_down[4] = fireBall.crop(281, 403, 16, 32);
		fb_down[5] = fireBall.crop(344, 403, 16, 32);
		fb_down[6] = fireBall.crop(408, 403, 16, 32);
		fb_down[7] = fireBall.crop(472, 403, 16, 32);
		
		//Speech Bubble
		speechBubble = objectSheet.crop(309, 96, 52, 47);
		
		//Chest
		chestClosed = objectSheet.crop(149, 0, 22, 17);
		chestOpen = objectSheet.crop(229, 23, 22, 17);
		
		//Display text box
		displayBoxRed = invUIpat2.crop(387, 98, 102, 39);
		
		//Highlighters for tabs
		tabHighlightSword = invUI.crop(144, 138, 13, 17);
		tabHighlightShield = invUI.crop(144, 156, 13, 17);
		tabHighlightPotion = invUI.crop(144, 174, 13, 17);
		tabHighlightQuest = invUI.crop(144, 192, 13, 17);
		
		//Font
		font28 = FontLoader.highTower;
		font28nBold = FontLoader.highTowernBold;
		fontPlaceHolder = new Font("Times New Roman", Font.BOLD, 28);
		
		//Mage Male Walking
		mageM_up = new BufferedImage[3];
		mageM_down = new BufferedImage[3];
		mageM_left = new BufferedImage[3];
		mageM_right = new BufferedImage[3];
		mageM_idle = new BufferedImage[4];
		
		mageM_up[0] = mageMale.crop(2, 2, 27, 33);
		mageM_up[1] = mageMale.crop(34, 0, 27, 33);
		mageM_up[2] = mageMale.crop(68, 2, 27, 33);
		
		mageM_right[0] = mageMale.crop(2, 38, 27, 33);
		mageM_right[1] = mageMale.crop(34, 36, 27, 33);
		mageM_right[2] = mageMale.crop(68, 38, 27, 33);
		
		mageM_down[0] = mageMale.crop(2, 74, 27, 33);
		mageM_down[1] = mageMale.crop(34, 72, 27, 33);
		mageM_down[2] = mageMale.crop(68, 74, 27, 33);
		
		mageM_left[0] = mageMale.crop(2, 110, 27, 33);
		mageM_left[1] = mageMale.crop(34, 108, 27, 33);
		mageM_left[2] = mageMale.crop(68, 110, 27, 33);
		
		mageM_idle[2] = mageMale.crop(34, 0, 27, 33);
		mageM_idle[0] = mageMale.crop(34, 36, 27, 33);
		mageM_idle[3] = mageMale.crop(34, 72, 27, 33);
		mageM_idle[1] = mageMale.crop(34, 108, 27, 33);
		
		//Mage Male Attack
		mageM_upA = new BufferedImage[4];
		mageM_downA = new BufferedImage[4];
		mageM_leftA = new BufferedImage[4];
		mageM_rightA = new BufferedImage[4];

		mageM_upA[0] = castAnim.crop(128, 162, 14, 17);
		mageM_upA[1] = castAnim.crop(146, 162, 14, 17);
		mageM_upA[2] = castAnim.crop(164, 162, 14, 17);
		mageM_upA[3] = castAnim.crop(182, 162, 14, 17);
		
		mageM_rightA[0] = castAnim.crop(126, 182, 14, 17);
		mageM_rightA[1] = castAnim.crop(144, 182, 14, 17);
		mageM_rightA[2] = castAnim.crop(162, 182, 14, 17);
		mageM_rightA[3] = castAnim.crop(180, 182, 14, 17);
		
		mageM_downA[0] = castAnim.crop(128, 202, 14, 17);
		mageM_downA[1] = castAnim.crop(146, 202, 14, 17);
		mageM_downA[2] = castAnim.crop(164, 202, 14, 17);
		mageM_downA[3] = castAnim.crop(182, 202, 14, 17);
		
		mageM_leftA[0] = castAnim.crop(130, 223, 14, 17);
		mageM_leftA[1] = castAnim.crop(148, 223, 14, 17);
		mageM_leftA[2] = castAnim.crop(166, 223, 14, 17);
		mageM_leftA[3] = castAnim.crop(184, 223, 14, 17);
		
		//Ranger Female Walking
		archF_up = new BufferedImage[3];
		archF_down = new BufferedImage[3];
		archF_left = new BufferedImage[3];
		archF_right = new BufferedImage[3];
		archF_idle = new BufferedImage[4];
		
		archF_up[0] = rangerFemale.crop(2, 2, 27, 33);
		archF_up[1] = rangerFemale.crop(34, 0, 27, 33);
		archF_up[2] = rangerFemale.crop(68, 2, 27, 33);
		
		archF_right[0] = rangerFemale.crop(2, 38, 27, 33);
		archF_right[1] = rangerFemale.crop(34, 36, 27, 33);
		archF_right[2] = rangerFemale.crop(68, 38, 27, 33);
		
		archF_down[0] = rangerFemale.crop(2, 74, 27, 33);
		archF_down[1] = rangerFemale.crop(34, 72, 27, 33);
		archF_down[2] = rangerFemale.crop(68, 74, 27, 33);
		
		archF_left[0] = rangerFemale.crop(2, 110, 27, 33);
		archF_left[1] = rangerFemale.crop(34, 108, 27, 33);
		archF_left[2] = rangerFemale.crop(68, 110, 27, 33);
		
		archF_idle[2] = rangerFemale.crop(34, 0, 27, 33);
		archF_idle[0] = rangerFemale.crop(34, 36, 27, 33);
		archF_idle[3] = rangerFemale.crop(34, 72, 27, 33);
		archF_idle[1] = rangerFemale.crop(34, 108, 27, 33);
		
		//Overlay Images
		heartFull = overlayItems.crop(65, 3, 12, 11);
		heartThreeFourths = overlayItems.crop(81, 3, 12, 11);
		heartHalf = overlayItems.crop(97, 3, 12, 11);
		heartFourth = overlayItems.crop(113, 3, 12, 11);
		heartEmpty = overlayItems.crop(129, 3, 12, 11);
		
		//Weapons
		swordStarter = sw.crop(65, 0, width, height);
		swordBlue = sw.crop(0, 0, width, height);
		swordRed = sw.crop(17, 0, width, height);
		swordGreen = sw.crop(33, 0, width, height);
		swordBlack = sw.crop(49, 0, width, height);
		test = weaponsSheet.crop(1, 1, 48, 48);
		chestPlate = sheetCharacter.crop(100, 50, width, height);
		
		//Parchment
		parchment = parchmentSheet.crop(0, 0, 512, 512);
		
		//Inventory Screen
		inventoryScreen = invUI.crop(5, 99, 119, 172);	
		itemHighlighter = invUI.crop(127, 141, 14, 14);
		nothing = cave.crop(200, 200, 2, 2);
		//Introduction Menu Assets
			
		//Arrays
		btn_start = new BufferedImage[2];
		btn_blank = new BufferedImage[2];
		btn_inc_pos = new BufferedImage[2];
		
		//Blank Button
		btn_blank[0] = menuUI.crop(16, 126, 278, 54);
		btn_blank[1] = menuUI.crop(16, 203, 278, 54);
		
		//Vertical incremental buttons
		btn_inc_pos[0] = menuUI.crop(461, 18, 68, 30);
		btn_inc_pos[1] = menuUI.crop(461, 71, 68, 30);
		
		//433, 320, 14, 22
		
		//Player Movement Animations
		
		//Arrays
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_idle = new BufferedImage[4];

		player_down_bs = new BufferedImage[2];
		player_up_bs = new BufferedImage[2];
		player_left_bs = new BufferedImage[3];
		player_right_bs = new BufferedImage[3];
		player_idle_bs = new BufferedImage[4];
		
		player_attack_down = new BufferedImage[4];
		player_attack_up = new BufferedImage[4];
		player_attack_left = new BufferedImage[4];
		player_attack_right = new BufferedImage[4];
		
		player_attack_downB = new BufferedImage[4];
		player_attack_leftB = new BufferedImage[4];
		player_attack_rightB = new BufferedImage[4];
		player_attack_upB = new BufferedImage[4];
		
		//Walking
		player_down_bs[0] = sheetCharacterBs.crop(17, 7, 15, 20);
		player_down_bs[1] = sheetCharacterBs.crop(49, 7, 15, 20);
		player_up_bs[0] = sheetCharacterBs.crop(16, 70, 15, 21);
		player_up_bs[1] = sheetCharacterBs.crop(48, 70, 15, 21);
		player_right_bs[0] = sheetCharacterBs.crop(18, 39, 15, 21);
		player_right_bs[1] = sheetCharacterBs.crop(34, 38, 15, 21);
		player_right_bs[2] = sheetCharacterBs.crop(50, 39, 15, 21);
		player_left_bs[0] = sheetCharacterBs.crop(17, 103, 15, 21);
		player_left_bs[1] = sheetCharacterBs.crop(33, 102, 15, 21);
		player_left_bs[2] = sheetCharacterBs.crop(49, 103, 15, 21);
		//Idle
		player_idle_bs[0] = sheetCharacterBs.crop(33, 6, 15, 21);
		player_idle_bs[1] = sheetCharacterBs.crop(32, 69, 15, 22);
		player_idle_bs[2] = sheetCharacterBs.crop(34, 38, 15, 21);
		player_idle_bs[3] = sheetCharacterBs.crop(33, 102, 15, 21);
		
		//Walking
		player_down[0] = sheetCharacter.crop(17, 7, 15, 20);
		player_down[1] = sheetCharacter.crop(49, 7, 15, 20);
		player_up[0] = sheetCharacter.crop(16, 70, 15, 21);
		player_up[1] = sheetCharacter.crop(48, 70, 15, 21);
		player_right[0] = sheetCharacter.crop(18, 39, 15, 21);
		player_right[1] = sheetCharacter.crop(34, 38, 15, 21);
		player_right[2] = sheetCharacter.crop(50, 39, 15, 21);
		player_left[0] = sheetCharacter.crop(17, 103, 15, 21);
		player_left[1] = sheetCharacter.crop(33, 102, 15, 21);
		player_left[2] = sheetCharacter.crop(49, 103, 15, 21);
		//Idle
		player_idle[0] = sheetCharacter.crop(33, 6, 15, 21);
		player_idle[1] = sheetCharacter.crop(32, 69, 15, 22);
		player_idle[2] = sheetCharacter.crop(34, 38, 15, 21);
		player_idle[3] = sheetCharacter.crop(33, 102, 15, 21);
		//Swing Sword
		player_attack_down[0] = sheetCharacter.crop(7, 134, 16, 26);
		player_attack_down[1] = sheetCharacter.crop(41, 134, 16, 26);
		player_attack_down[2] = sheetCharacter.crop(72, 134, 16, 26);
		player_attack_down[3] = sheetCharacter.crop(104, 134, 16, 26);		
		player_attack_up[0] = sheetCharacter.crop(7, 166, 16, 26);
		player_attack_up[1] = sheetCharacter.crop(41, 166, 16, 26);
		player_attack_up[2] = sheetCharacter.crop(72, 166, 16, 26);
		player_attack_up[3] = sheetCharacter.crop(104, 166, 16, 26);	
		player_attack_right[0] = sheetCharacter.crop(8, 199, 20, 26);
		player_attack_right[1] = sheetCharacter.crop(41, 199, 20, 26);
		player_attack_right[2] = sheetCharacter.crop(73, 199, 20, 26);
		player_attack_right[3] = sheetCharacter.crop(105, 199, 20, 26);
		player_attack_left[0] = sheetCharacter.crop(8, 230, 20, 26);
		player_attack_left[1] = sheetCharacter.crop(33, 230, 20, 26);
		player_attack_left[2] = sheetCharacter.crop(68, 230, 20, 26);
		player_attack_left[3] = sheetCharacter.crop(101, 230, 20, 26);	
		
		player_attack_downB[0] = blueSwordSwing.crop(7, 134, 16, 26);
		player_attack_downB[1] = blueSwordSwing.crop(41, 134, 16, 26);
		player_attack_downB[2] = blueSwordSwing.crop(72, 134, 16, 26);
		player_attack_downB[3] = blueSwordSwing.crop(104, 134, 16, 26);		
		player_attack_upB[0] = blueSwordSwing.crop(7, 166, 16, 26);
		player_attack_upB[1] = blueSwordSwing.crop(41, 166, 16, 26);
		player_attack_upB[2] = blueSwordSwing.crop(72, 166, 16, 26);
		player_attack_upB[3] = blueSwordSwing.crop(104, 166, 16, 26);	
		player_attack_rightB[0] = blueSwordSwing.crop(8, 199, 20, 26);
		player_attack_rightB[1] = blueSwordSwing.crop(41, 199, 20, 26);
		player_attack_rightB[2] = blueSwordSwing.crop(73, 199, 20, 26);
		player_attack_rightB[3] = blueSwordSwing.crop(105, 199, 20, 26);
		player_attack_leftB[0] = blueSwordSwing.crop(8, 230, 20, 26);
		player_attack_leftB[1] = blueSwordSwing.crop(33, 230, 20, 26);
		player_attack_leftB[2] = blueSwordSwing.crop(68, 230, 20, 26);
		player_attack_leftB[3] = blueSwordSwing.crop(101, 230, 20, 26);
		
		
		//Tiles
		grass = sheetWorld.crop(0, 0, width, height);
		dirt = sheetWorld.crop(32, 512, width, height);
		stone = cave.crop(112, 48, 15, 15);
		
		//Stand alone Entities (Probably will re-do)
		rock = overworldSpecial.crop(0, 0, width, height);
		bush = cave.crop(173, 39, 15, 14);
		tree = sheetWorld.crop(512, 18, 15, 30);
		
		//Items
		wood = sheetWorld.crop(433, 320, 14, 22);
		coin = objectSheet.crop(2, 66, 11, 11);
	}

}
