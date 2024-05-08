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
	public final static Bloc BLOC_0 = new Bloc(0,"./dirt.jpg", false);
	public final static Bloc BLOC_1 = new Bloc(1,"./rouge.jpg", true);
	public final static Bloc BLOC_2 = new Bloc(2, "./tree.jpg", true);
	public final static Bloc BLOC_3 = new Bloc(3, "./gate.jpg", true);
	public final static Bloc BLOC_4 = new Bloc(4, "./stone.jpg", false);
	public final static Bloc BLOC_5 = new Bloc(4, "./nether.jpg", false);
 	
	
	//Item
	public final static Item ITEM_BALL = new Item(0,"Pokeball", "./pokeball.png",false);
	public final static Item ITEM_POTION = new Item(1,"Potion", "./potion.png",true,1);
	public final static Item ITEM_KEY = new Item(2,"Clé", "./key.png",false);
	
}
