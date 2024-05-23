import java.util.ArrayList;
import java.util.List;
/**
 * @brief Represents a fighting entity with health, attack power, and a duel sprite.
 */
public class FightingEntity extends Entity{
	//Var
	private double hp;
	private double hpMax;
	private double atk;
	private String duelSpritePath;
	
	//Cons
	/**
	 * @brief Constructs a FightingEntity with the specified attributes.
	 * 
	 * @param spritePath The path to the sprite image.
	 * @param name The name of the fighting entity.
	 * @param hp The maximum health points of the fighting entity.
	 * @param atk The attack power of the fighting entity.
	 * @param duelSpritePath The path to the duel sprite image.
	 */
	public FightingEntity(String spritePath, String name, double hp, double atk, String duelSpritePath) {
		super(spritePath,name);
		this.hpMax = hp;
		this.hp = hp;
		this.atk = atk;
		this.setDuelSpritePath(duelSpritePath);
	}
	//GetSet
	/**
	 * @brief Gets the current health points of the fighting entity.
	 * 
	 * @return The current health points.
	 */
	public double getHp() {
		return hp;
	}
	/**
	 * @brief Sets the current health points of the fighting entity.
	 * 
	 * @param hp The new health points.
	 */
	public void setHp(double hp) {
		this.hp = hp;
	}
	/**
	 * @brief Gets the maximum health points of the fighting entity.
	 * 
	 * @return The maximum health points.
	 */
	public double getHpMax() {
		return hpMax;
	}
	/**
	 * @brief Sets the maximum health points of the fighting entity.
	 * 
	 * @param hpMax The new maximum health points.
	 */
	public void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}
	/**
	 * @brief Gets the attack power of the fighting entity.
	 * 
	 * @return The attack power.
	 */
	public double getAtk() {
		return atk;
	}
	/**
	 * @brief Sets the attack power of the fighting entity.
	 * 
	 * @param atk The new attack power.
	 */
	public void setAtk(double atk) {
		this.atk = atk;
	}
	/**
	 * @brief Gets the path to the duel sprite image.
	 * 
	 * @return The duel sprite path.
	 */
	public String getDuelSpritePath() {
		return duelSpritePath;
	}
	/**
	 * @brief Sets the path to the duel sprite image.
	 * 
	 * @param duelSpritePath The new duel sprite path.
	 */
	public void setDuelSpritePath(String duelSpritePath) {
		this.duelSpritePath = duelSpritePath;
	}
	/**
	 * @brief Reduces the health points of the fighting entity by the specified damage.
	 * 
	 * @param damage The amount of damage to deal.
	 */
	public void receiveDamage(double damage) {
		System.out.println(this.getName() + " recoit " + damage + " dégat");
		this.hp = this.hp - damage;
	}
	/**
	 * @brief Heals the fighting entity by the specified amount.
	 * 
	 * @param heal The amount of health points to restore.
	 */
	public void healing(double heal) {
		double newHp = this.hp + heal;
		this.hp = this.hpMax < newHp ? this.hpMax : newHp;
	}
	
	//Meth
	/**
	 * @brief Checks if the fighting entity is knocked out (health points are 0 or less).
	 * 
	 * @return True if the entity is knocked out, false otherwise.
	 */
	public boolean isKo() {
		return this.hp <= 0;
	}
	/**
	 * @brief Gets a list of items in the inventory that can be used during a duel.
	 * 
	 * @return A list of useable items in the duel.
	 */
	public List<Item> getInventoryDuel() {
		
		List<Item> inventoryDuel = new ArrayList<Item>();
		
		for(Item item : this.getInventory()) {
			if(item.isUseableInDuel()) {
				inventoryDuel.add(item);
			}
		}
		
		return inventoryDuel;
	}

	//Object
	/**
	 * @brief Uses an item by name, applying its effects to the fighting entity.
	 * 
	 * @param item The name of the item to use.
	 */
	public void useObject(String item) {
		
		System.out.println(this.getName() + " utilise : " + item);
		
    	if(item.equals(Constantes.ITEM_POTION.getName())) {
    		
    		double currentHp = this.getHp();
    		
    		this.healing(40);
    		System.out.println(currentHp + " -> " +this.getHp());
    		
    		this.itemDegradation(Constantes.ITEM_POTION.getName());
    	}
		
		
	}

}
