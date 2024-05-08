import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entity {
	//Var
	private ImageView sprite;
	private String spritePath;
	private List<Item> inventory;
	private String name;

	//Cons
	public Entity(String spritePath, String name) {
		this.sprite = new ImageView(new Image (spritePath));
		this.setSpritePath(spritePath);
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		this.inventory = new ArrayList<Item>();
	}
	
	//GetSet
	public ImageView getSprite() {
		return sprite;
	}
	public void setSprite(String spritePath) {
		this.sprite = new ImageView(new Image (spritePath));
		this.setSpritePath(spritePath);
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public Item getInventoryElement(int i) {
		return this.inventory.get(i);
	}
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}
	public String getSpritePath() {
		return spritePath;
	}
	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}
	//Meth
	public boolean inventoryContainsItem(int id) {
		for(Item item : this.getInventory()) {
			if(item.getId() == id) {
				return true;
			}
		}
		return false;
	}



}
