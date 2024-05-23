
/**
 * @brief Represents the player entity in the game.
 */
public class Player extends FightingEntity{
	//Var
	private int direction;
	private int posX;
	private int posY;
	
	//Cons
	 /**
     * @brief Constructs a Player object with default attributes.
     */
	public Player() {
		super("file:img/player_south.png","Sacha",50,10,"file:img/duel_player.png");
		
		this.getInventory().add(Constantes.ITEM_POTION.deepCopy());
		this.getInventory().add(Constantes.ITEM_POTION.deepCopy());
	}

	//GetSet
	/**
     * @brief Gets the X-coordinate position of the player.
     * 
     * @return The X-coordinate position of the player.
     */
	public int getPosX() {
		return posX;
	}
	/**
     * @brief Sets the X-coordinate position of the player.
     * 
     * @param posX The X-coordinate position of the player.
     */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
     * @brief Gets the Y-coordinate position of the player.
     * 
     * @return The Y-coordinate position of the player.
     */
	public int getPosY() {
		return posY;
	}
	/**
     * @brief Sets the Y-coordinate position of the player.
     * 
     * @param posY The Y-coordinate position of the player.
     */
	public void setPosY(int posY) {
		this.posY = posY;
	}
	/**
     * @brief Gets the direction the player is facing.
     * 
     * @return The direction the player is facing.
     */
	public int getDirection() {
		return this.direction;
	}
	
	//Meth
	/**
     * @brief Sets the direction the player is facing.
     * 
     * @param i The direction the player is facing.
     */
	public void setDirection(int i) {
		
		this.direction = i;
		switch(i) {
			case Constantes.DIRECTION_NORTH:
				this.setSprite("file:img/player_north.png");
				break;
			case Constantes.DIRECTION_EAST:
				this.setSprite("file:img/player_east.png");
				break;
			case Constantes.DIRECTION_SOUTH:
				this.setSprite("file:img/player_south.png");
				break;
			case Constantes.DIRECTION_WEST:
				this.setSprite("file:img/player_west.png");
				break;
			default:
				break;
		}
	}

	//meth
	/**
     * @brief Returns a string representation of the player's position.
     * 
     * @return A string representation of the player's position.
     */
	@Override
	public String toString() {
		return "X: " + this.getPosX() + ",Y :" + this.getPosY();
	}

	
}
