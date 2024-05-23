import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @brief Represents a block in the game.
 */
public class Bloc {
	//Var
	private boolean isSolid;
	private String spritePath;
	private ImageView sprite;
	private int id;
	
	//Cons
	/**
	 * @brief Constructs a Bloc with specified id, sprite path, and solidity.
	 * 
	 * @param id Id of the block.
	 * @param spritePath Path to the sprite image.
	 * @param isSolid Whether the block is solid.
	 */
	public Bloc(int id, String spritePath, boolean isSolid) {
		this.isSolid = isSolid;
		this.id = id;
		this.spritePath = new String(spritePath);
		this.sprite = new ImageView(new Image (spritePath));
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		
	}
	/**
	 * @brief Copy constructor for Bloc.
	 * 
	 * @param b The block to copy.
	 */
	public Bloc(Bloc b){
		this.isSolid = b.isSolid();
		this.id = b.getId();
		this.sprite = b.getSprite();
	}

	//GetSet
	/**
	 * @brief Checks if the block is solid.
	 * 
	 * @return True if the block is solid, false otherwise.
	 */
	public boolean isSolid() {
		return isSolid;
	}
	/**
	 * @brief Sets the solidity of the block.
	 * 
	 * @param isSolid True to make the block solid, false to make it non-solid.
	 */
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	/**
	 * @brief Gets the id of the block.
	 * 
	 * @return The id of the block.
	 */
	public int getId() {
		return id;
	}
	/**
	 * @brief Gets the sprite of the block.
	 * 
	 * @return The sprite of the block.
	 */
	public ImageView getSprite() {
		return sprite;
	}
	/**
	 * @brief Sets the sprite of the block.
	 * 
	 * @param sprite The new sprite of the block.
	 */
	public void setSprite(ImageView sprite) {
		this.sprite = sprite;
	}
	//Methode
	/**
	 * @brief Creates a deep copy of the block.
	 * 
	 * @return A new Bloc object that is a deep copy of this block.
	 */
	public Bloc deepCopy() {
        return new Bloc(this.id, new String(this.spritePath), this.isSolid);
    }
}
