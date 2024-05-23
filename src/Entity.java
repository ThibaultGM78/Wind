import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * @brief Represents an entity in the game with a sprite, inventory, and a name.
 */
public class Entity {
	//Var
	private ImageView sprite;
	private String spritePath;
	private List<Item> inventory;
	private String name;

	//Cons
	/**
	 * @brief Constructs an Entity with the specified sprite path and name.
	 * 
	 * @param spritePath The path to the sprite image.
	 * @param name The name of the entity.
	 */
	public Entity(String spritePath, String name) {
		this.sprite = new ImageView(new Image (spritePath));
		this.setSpritePath(spritePath);
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		this.inventory = new ArrayList<Item>();
		this.name = name;
	}
	
	//GetSet
	/**
	 * @brief Gets the sprite of the entity.
	 * 
	 * @return The sprite ImageView.
	 */
	public ImageView getSprite() {
		return sprite;
	}
	/**
	 * @brief Sets the sprite of the entity.
	 * 
	 * @param spritePath The path to the new sprite image.
	 */
	public void setSprite(String spritePath) {
		this.sprite = new ImageView(new Image (spritePath));
		this.setSpritePath(spritePath);
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
	}
	/**
	 * @brief Gets the inventory of the entity.
	 * 
	 * @return The inventory list.
	 */
	public List<Item> getInventory() {
		return inventory;
	}
	/**
	 * @brief Gets an item from the inventory at a specified index.
	 * 
	 * @param i The index of the item to retrieve.
	 * @return The item at the specified index.
	 */
	public Item getInventoryElement(int i) {
		return this.inventory.get(i);
	}
	/**
	 * @brief Sets the inventory of the entity.
	 * 
	 * @param inventory The new inventory list.
	 */
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}
	/**
	 * @brief Gets the sprite path of the entity.
	 * 
	 * @return The sprite path.
	 */
	public String getSpritePath() {
		return spritePath;
	}
	/**
	 * @brief Sets the sprite path of the entity.
	 * 
	 * @param spritePath The new sprite path.
	 */
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
	/**
	 * @brief Gets the name of the entity.
	 * 
	 * @return The name of the entity.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @brief Sets the name of the entity.
	 * 
	 * @param name The new name of the entity.
	 */
	public void setName(String name) {
		this.name = name;
	}
	//Meth
	/**
	 * @brief Checks if the inventory contains an item with the specified id.
	 * 
	 * @param id The id of the item to check for.
	 * @return True if the item is found, false otherwise.
	 */
	public boolean inventoryContainsItem(int id) {
		for(Item item : this.getInventory()) {
			if(item.getId() == id) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @brief Degrades an item by name, reducing its remaining uses or removing it from the inventory if uses are depleted.
	 * 
	 * @param name The name of the item to degrade.
	 */
	public void itemDegradation(String name) {
		
		int i = 0;
		while(i < this.getInventory().size()) {
			System.out.println(i);
			if(this.getInventory().get(i).getName().equals(name)) {
				break;
			}
			i++;
		}
		
		if(this.getInventory().get(i).isLimited()) {
			this.getInventory().get(i).setnUseRemain(this.getInventory().get(i).getnUseRemain() - 1);
			System.out.println( name + " a encore " + this.getInventory().get(i).getnUseRemain() + " utilisation");
			
			if(this.getInventory().get(i).getnUseRemain() < 1) {
				this.getInventory().remove(i);
			}
			
 		}
		else {
			System.out.println("L'utilisation de " + name + " est infini");
		}
				
	}

}
