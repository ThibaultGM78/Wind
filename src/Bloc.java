import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Bloc {
	//Var
	private boolean isSolid;
	private String spritePath;
	private ImageView sprite;
	private int id;
	
	//Cons
	public Bloc(int id, String spritePath, boolean isSolid) {
		this.isSolid = isSolid;
		this.id = id;
		this.spritePath = new String(spritePath);
		this.sprite = new ImageView(new Image (spritePath));
		this.sprite.setFitHeight(Constantes.CASE_HEIGHT);
		this.sprite.setFitWidth(Constantes.CASE_WIDTH);
		
	}
	
	public Bloc(Bloc b){
		this.isSolid = b.isSolid();
		this.id = b.getId();
		this.sprite = b.getSprite();
	}

	//GetSet
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	public int getId() {
		return id;
	}

	public ImageView getSprite() {
		return sprite;
	}

	public void setSprite(ImageView sprite) {
		this.sprite = sprite;
	}
	//Methode
	public Bloc deepCopy() {
        return new Bloc(this.id, new String(this.spritePath), this.isSolid);
    }
}
