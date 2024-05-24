import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * @brief Represents an item in the game.
 */
public class Item {
	private String name;
	private String spritePath;
	private ImageView sprite;
	private int id;
	private boolean isUsableInDuel;
	private boolean isUsableOutDuel;
	
	private boolean isLimited;
	private int nUseRemain;

	//Cons
	/**
     * @brief Constructs an Item object with the given parameters.
     * 
     * @param id The ID of the item.
     * @param name The name of the item.
     * @param spritePath The path to the sprite image of the item.
     * @param isUsableInDuel Indicates whether the item is usable in duels.
     */
	public Item(int id, String name, String spritePath, boolean isUsableInDuel, boolean isUsableOutDuel) {
		super();
		this.id = id;
		this.sprite = new ImageView(new Image (spritePath));
		this.spritePath = spritePath;
		this.name = name;
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		this.isUsableInDuel = isUsableInDuel;
		this.isUsableOutDuel = isUsableOutDuel;
		
		this.isLimited = false;
		this.nUseRemain = 1;
	}
	 /**
     * @brief Constructs an Item object with the given parameters.
     * 
     * @param id The ID of the item.
     * @param name The name of the item.
     * @param spritePath The path to the sprite image of the item.
     * @param isUsableInDuel Indicates whether the item is usable in duels.
     * @param nUse The number of uses of the item.
     */
	public Item(int id, String name, String spritePath, boolean isUsableInDuel, boolean isUsableOutDuel, int nUse) {
		super();
		this.id = id;
		this.sprite = new ImageView(new Image (spritePath));
		this.spritePath = spritePath;
		this.name = name;
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		this.isUsableInDuel = isUsableInDuel;
		this.isUsableOutDuel = isUsableOutDuel;
		
		this.isLimited = true;
		this.nUseRemain = nUse;
	}
	/**
     * @brief Constructs an Item object with the given parameters.
     * 
     * @param id The ID of the item.
     * @param name The name of the item.
     * @param spritePath The path to the sprite image of the item.
     * @param isUsableInDuel Indicates whether the item is usable in duels.
     * @param isLimited Indicates whether the item has limited uses.
     * @param nUse The number of uses of the item.
     */
	public Item(int id, String name, String spritePath, boolean isUsableInDuel, boolean isUsableOutDuel, boolean isLimited, int nUse) {
		super();
		this.id = id;
		this.sprite = new ImageView(new Image (spritePath));
		this.spritePath = spritePath;
		this.name = name;
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		this.isUsableInDuel = isUsableInDuel;
		this.isUsableOutDuel = isUsableOutDuel;
		
		this.isLimited = isLimited;
		this.nUseRemain = nUse;
	}
	
	//GetSet
	/**
     * @brief Gets the name of the item.
     * 
     * @return The name of the item.
     */
	public String getName() {
		return name;
	}
	/**
     * @brief Sets the name of the item.
     * 
     * @param name The name of the item.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * @brief Gets the path to the sprite image of the item.
     * 
     * @return The path to the sprite image of the item.
     */
	public String getSpritePath() {
		return spritePath;
	}
	/**
     * @brief Sets the path to the sprite image of the item.
     * 
     * @param spritePath The path to the sprite image of the item.
     */
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
	/**
     * @brief Gets the sprite image of the item.
     * 
     * @return The sprite image of the item.
     */
	public ImageView getSprite() {
		return sprite;
	}
	/**
     * @brief Sets the sprite image of the item.
     * 
     * @param sprite The sprite image of the item.
     */
	public void setSprite(ImageView sprite) {
		this.sprite = sprite;
	}
	/**
     * @brief Gets the ID of the item.
     * 
     * @return The ID of the item.
     */
	public int getId() {
		return id;
	}
	 /**
     * @brief Sets the ID of the item.
     * 
     * @param id The ID of the item.
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * @brief Checks if the item is usable in duels.
     * 
     * @return True if the item is usable in duels, false otherwise.
     */
	public boolean isUseableInDuel() {
		return isUsableInDuel;
	}
	/**
     * @brief Sets whether the item is usable in duels.
     * 
     * @param isUseableInDuel Indicates whether the item is usable in duels.
     */
	public void setUseableInDuel(boolean isUseableInDuel) {
		this.isUsableInDuel = isUseableInDuel;
	}
	/**
     * @brief Checks if the item is usable out duels.
     * 
     * @return True if the item is usable out duels, false otherwise.
     */
	public boolean isUseableOutDuel() {
		return isUsableOutDuel;
	}
	/**
     * @brief Sets whether the item is usable out duels.
     * 
     * @param isUseableInDuel Indicates whether the item is usable out duels.
     */
	public void setUseableOutDuel(boolean isUseableOutDuel) {
		this.isUsableOutDuel = isUseableOutDuel;
	}
	/**
     * @brief Checks if the item has limited uses.
     * 
     * @return True if the item has limited uses, false otherwise.
     */
	public boolean isLimited() {
		return isLimited;
	}
	/**
     * @brief Sets whether the item has limited uses.
     * 
     * @param isLimited Indicates whether the item has limited uses.
     */
	public void setLimited(boolean isLimited) {
		this.isLimited = isLimited;
	}
	/**
     * @brief Gets the number of remaining uses of the item.
     * 
     * @return The number of remaining uses of the item.
     */
	public int getnUseRemain() {
		return nUseRemain;
	}
	/**
     * @brief Sets the number of remaining uses of the item.
     * 
     * @param nUseRemain The number of remaining uses of the item.
     */
	public void setnUseRemain(int nUseRemain) {
		this.nUseRemain = nUseRemain;
	}

	//Methode
	/**
     * @brief Creates a deep copy of the item.
     * 
     * @return A deep copy of the item.
     */
	public Item deepCopy() {
        return new Item(this.id,new String(this.name),new String(this.spritePath),this.isUsableInDuel, this.isLimited, this.nUseRemain);
    }

	

	
}
