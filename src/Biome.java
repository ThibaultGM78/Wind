
/**
 * @brief Represents a biome in the game.
 */
public abstract class Biome {
	//Var
	private int height;
	private int width;
	private int id;

	private Tile[][] tiles; 
	//private Extends Entity[][] entities;
	 
	//Super
	/**
	 * @brief Constructs a biome.
	 * 
	 * @param height Height of the biome.
	 * @param width Width of the biome.
	 * @param id Id of the biome.
	 */
	public Biome (int height, int width, int id){
		
		this.height = height;
		this.width = width;
		this.id = id;
		this.tiles = new Tile[this.height][this.width];
		
		this.initBiome();
	}
	//GetSet
	/**
	 * @brief Gets a tile from the biome.
	 * 
	 * @param i X coordinate of the tile to retrieve.
	 * @param j Y coordinate of the tile to retrieve.
	 * @return The tile at the specified coordinates.
	 */
	public Tile getTile(int i, int j) {
		return this.tiles[i][j];
	}
	/**
	 * @brief Sets a tile in the biome.
	 * 
	 * @param i X coordinate of the tile to modify.
	 * @param j Y coordinate of the tile to modify.
	 * @param t The new tile to set.
	 */
	public void setTile(int i, int j, Tile t) {
		this.tiles[i][j] = t;
	}
	/**
	 * @brief Gets the height of the biome.
	 * 
	 * @return The height of the biome.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @brief Gets the width of the biome.
	 * 
	 * @return The width of the biome.
	 */
	public int getWidth() {
		return width;
	}
	
	//Meth
	/**
	 * @brief Checks if a tile exists at the specified coordinates.
	 * 
	 * @param x X coordinate of the tile.
	 * @param y Y coordinate of the tile.
	 * @return True if the tile exists, false otherwise.
	 */
	public boolean isTileExist(int x, int y) {

		if(x < 0 || y < 0) {
			System.out.println("Bloque");
			return false;
		}
		if(x >= this.width || y >= this.height) {
			System.out.println("Bloque");
			return false;
		}
		return true;
	}
	/**
	 * @brief Checks if a move is possible to the specified coordinates for the player.
	 * 
	 * @param x X coordinate to move to.
	 * @param y Y coordinate to move to.
	 * @param p The player attempting the move.
	 * @return True if the move is possible, false otherwise.
	 */
	public boolean moveIsPossible(int x, int y, Player p) {
		
		if(!this.isTileExist(x, y)) {
			System.out.println("Bloque");
			return false;
		}
		if(this.getTile(x, y).getBloc().isSolid()) {
		
			if(this.getTile(x, y).getBloc().getId() == 3 && p.inventoryContainsItem(Constantes.ITEM_KEY.getId())) {
				this.getTile(x, y).setBloc(Constantes.BLOC_0.deepCopy());
			}
			
			System.out.println("Bloque");
			return false;

		}
		if(this.getTile(x,y).getPnj() != null || this.getTile(x, y).getPokemon() != null || this.getTile(x, y).getItem() != null) {
			return false;
		}
		
		
		return true;
	}

	//Abstract
	/**
	 * @brief Initializes the biome.
	 */
	public abstract void initBiome();
}
