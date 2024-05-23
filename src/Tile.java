/**
 * @brief Represents a tile in the game world.
 */
public class Tile {
	//Var
	private Bloc bloc;
	private Pnj pnj;
	private Pokemon pokemon;
	private Item item;
	
	private boolean isTpTile;
	private int spawnX;
	private int spawnY;
	private int idTpBiome;
	
	//Cons
	/**
     * @brief Constructs a new Tile object with default values.
     */
	public Tile() {
		super();
		this.isTpTile = false;
	}
	
	//GetSet
	/**
     * @brief Gets the block (terrain) associated with the tile.
     * 
     * @return The block.
     */
	public Bloc getBloc() {
		return bloc;
	}
	/**
     * @brief Sets the block (terrain) associated with the tile.
     * 
     * @param bloc The block to be set.
     */
	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}
	/**
     * @brief Gets the NPC (non-player character) associated with the tile.
     * 
     * @return The NPC.
     */
	public Pnj getPnj() {
		return pnj;
	}
	/**
     * @brief Sets the NPC (non-player character) associated with the tile.
     * 
     * @param pnj The NPC to be set.
     */
	public void setPnj(Pnj pnj) {
		this.pnj = pnj;
	}
	/**
     * @brief Gets the Pokémon associated with the tile.
     * 
     * @return The Pokémon.
     */
	public Pokemon getPokemon() {
		return pokemon;
	}
	/**
     * @brief Sets the Pokémon associated with the tile.
     * 
     * @param pokemon The Pokémon to be set.
     */
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	/**
     * @brief Checks if the tile is a teleportation tile.
     * 
     * @return True if the tile is a teleportation tile, false otherwise.
     */
	public boolean isTpTile() {
		return isTpTile;
	}
	/**
     * @brief Sets whether the tile is a teleportation tile.
     * 
     * @param isTpTile True to set the tile as a teleportation tile, false otherwise.
     */
	public void setTpTile(boolean isTpTile) {
		this.isTpTile = isTpTile;
	}
	/**
     * @brief Gets the X-coordinate of the spawn point associated with the tile.
     * 
     * @return The X-coordinate of the spawn point.
     */
	public int getSpawnX() {
		return spawnX;
	}
	/**
     * @brief Sets the X-coordinate of the spawn point associated with the tile.
     * 
     * @param spawnX The X-coordinate of the spawn point to be set.
     */
	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}
	/**
     * @brief Gets the Y-coordinate of the spawn point associated with the tile.
     * 
     * @return The Y-coordinate of the spawn point.
     */
	public int getSpawnY() {
		return spawnY;
	}
	/**
     * @brief Sets the Y-coordinate of the spawn point associated with the tile.
     * 
     * @param spawnY The Y-coordinate of the spawn point to be set.
     */
	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}
	/**
     * @brief Gets the ID of the biome associated with the teleportation tile.
     * 
     * @return The ID of the biome.
     */
	public int getIdTpBiome() {
		return idTpBiome;
	}

	/**
     * @brief Set the ID of the biome associated with the teleportation tile.
     * 
     * @param The ID of the biome.
     */
	public void setIdTpBiome(int idTpBiome) {
		this.idTpBiome = idTpBiome;
	}
	
	/**
     * @brief Gets the item associated with the tile.
     * 
     * @return The item.
     */
	public Item getItem() {
		return item;
	}
	/**
     * @brief Sets the item associated with the tile.
     * 
     * @param item The item to be set.
     */
	public void setItem(Item item) {
		this.item = item;
	}

	//Meth
	/**
     * @brief Sets the properties of the tile to act as a teleportation tile.
     * 
     * @param idBiome The ID of the biome to teleport to.
     * @param x       The X-coordinate of the spawn point in the target biome.
     * @param y       The Y-coordinate of the spawn point in the target biome.
     */
	public void setTpTile(int idBiome, int x, int y) {
		this.idTpBiome = idBiome;
		this.spawnX = x;
		this.spawnY = y;
		this.isTpTile = true;
	}

	
}
