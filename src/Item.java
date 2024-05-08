import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
	private String name;
	private String spritePath;
	private ImageView sprite;
	private int id;
	private boolean isUseableInDuel;

	//Cons
	public Item(int id, String name, String spritePath, boolean isUsableInDuel) {
		super();
		this.id = id;
		this.sprite = new ImageView(new Image (spritePath));
		this.spritePath = spritePath;
		this.name = name;
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
	}
	
	//GetSet
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpritePath() {
		return spritePath;
	}

	public void setSpritePath(String spritePath) {
		this.spritePath = spritePath;
	}

	public ImageView getSprite() {
		return sprite;
	}

	public void setSprite(ImageView sprite) {
		this.sprite = sprite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public boolean isUseableInDuel() {
		return isUseableInDuel;
	}

	public void setUseableInDuel(boolean isUseableInDuel) {
		this.isUseableInDuel = isUseableInDuel;
	}
	
	//Methode
	public Item deepCopy() {
        return new Item(this.id,new String(this.name),new String(this.spritePath),this.isUseableInDuel);
    }

	

	
}
