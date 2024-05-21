import javafx.scene.input.KeyCode;

public class Constantes {
	public final static int NUMBER_OF_ROW = 11;
	public final static int NUMBER_OF_COL = 11;

	public final static int CASE_HEIGHT = 48;
	public final static int CASE_WIDTH = CASE_HEIGHT;
	
	public final static int STAGE_HEIGHT = NUMBER_OF_ROW * CASE_HEIGHT;
	public final static int STAGE_WIDTH = NUMBER_OF_COL * CASE_WIDTH;
	
	public final static KeyCode KEY_INVENTORY = KeyCode.E;
	public final static KeyCode KEY_MOVE_TOP = KeyCode.Z;
	public final static KeyCode KEY_MOVE_BOTTOM = KeyCode.S;
	public final static KeyCode KEY_MOVE_LEFT = KeyCode.Q;
	public final static KeyCode KEY_MOVE_RIGHT = KeyCode.D;
	public final static KeyCode KEY_INTERACTION = KeyCode.F;
	
	public final static int DIRECTION_NORTH = 0;
	public final static int DIRECTION_EAST = 1;
	public final static int DIRECTION_SOUTH = 2;
	public final static int DIRECTION_WEST = 3;
	
	//Bloc
	public final static Bloc BLOC_0 = new Bloc(0,"file:img/dirt.jpg", false);
	public final static Bloc BLOC_1 = new Bloc(1,"file:img/rouge.jpg", true);
	public final static Bloc BLOC_2 = new Bloc(2, "file:img/tree.jpg", true);
	public final static Bloc BLOC_3 = new Bloc(3, "file:img/gate.jpg", true);
	public final static Bloc BLOC_4 = new Bloc(4, "file:img/stone.jpg", false);
	public final static Bloc BLOC_5 = new Bloc(5, "file:img/nether.jpg", false);
	public final static Bloc BLOC_6 = new Bloc(6, "file:img/water.jpg", true);
	public final static Bloc BLOC_7 = new Bloc(7, "file:img/plank.jpg", false);
	public final static Bloc BLOC_8 = new Bloc(8, "file:img/house.jpg", false);
	public final static Bloc BLOC_9 = new Bloc(9, "file:img/carpet.jpg", false);
	public final static Bloc BLOC_10 = new Bloc(10, "file:img/door.jpg", false);
	public final static Bloc BLOC_11 = new Bloc(11, "file:img/graystone.jpg", false);
	
	//Item
	public final static Item ITEM_BALL = new Item(0,"Pokeball", "file:img/pokeball.png",false);
	public final static Item ITEM_POTION = new Item(1,"Potion", "file:img/potion.png",true,1);
	public final static Item ITEM_KEY = new Item(2,"Clé", "file:img/key.png",false);

	//Biome
	public final static Biome BIOME_VILLAGE = new VillageBiome();
	public final static Biome BIOME_BOSS = new BossBiome();
	public final static Biome BIOME_HOUSE = new HouseBiome();
	
	
	//EndGame
	public final static int NO_WIN = 0;
	public final static int WIN_DRACO = 1;
}
