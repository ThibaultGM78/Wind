

public class Player extends FightingEntity{
	//Var
	private int direction;
	private int posX;
	private int posY;
	
	//Cons
	public Player() {
		super("./player_south.png","Sacha",50,10,"./duel_player.png");
		
		this.getInventory().add(Constantes.ITEM_POTION.deepCopy());
	}

	//GetSet
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getDirection() {
		return this.direction;
	}
	
	//Meth
	public void setDirection(int i) {
		
		this.direction = i;
		switch(i) {
			case Constantes.DIRECTION_NORTH:
				this.setSprite("player_north.png");
				break;
			case Constantes.DIRECTION_EAST:
				this.setSprite("player_east.png");
				break;
			case Constantes.DIRECTION_SOUTH:
				this.setSprite("player_south.png");
				break;
			case Constantes.DIRECTION_WEST:
				this.setSprite("player_west.png");
				break;
			default:
				break;
		}
	}

	//meth
	@Override
	public String toString() {
		return "X: " + this.getPosX() + ",Y :" + this.getPosY();
	}

	
}
