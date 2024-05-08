import java.util.ArrayList;
import java.util.List;

public class FightingEntity extends Entity{
	//Var
	private double hp;
	private double hpMax;
	private double atk;
	private String duelSpritePath;
	
	//Cons
	public FightingEntity(String spritePath, String name, double hp, double atk, String duelSpritePath) {
		super(spritePath,name);
		this.hpMax = hp;
		this.hp = hp;
		this.atk = atk;
		this.setDuelSpritePath(duelSpritePath);
	}
	//GetSet
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getHpMax() {
		return hpMax;
	}
	public void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}
	public double getAtk() {
		return atk;
	}
	public void setAtk(double atk) {
		this.atk = atk;
	}
	public String getDuelSpritePath() {
		return duelSpritePath;
	}
	public void setDuelSpritePath(String duelSpritePath) {
		this.duelSpritePath = duelSpritePath;
	}
	
	public void receiveDamage(double damage) {
		System.out.println(this.getName() + " recoit " + damage + " dégat");
		this.hp = this.hp - damage;
	}
	public void healing(double heal) {
		double newHp = this.hp + heal;
		this.hp = this.hpMax < newHp ? this.hpMax : newHp;
	}
	
	//Meth
	public boolean isKo() {
		return this.hp <= 0;
	}
	
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
