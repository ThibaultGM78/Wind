
public class Pokemon extends FightingEntity{
	//Var
	private Item reward;
	
	//Cons
	public Pokemon(String spritePath, String name, double hp, double atk, String duelSpritePath) {
		super(spritePath, name, hp, atk, duelSpritePath);
		
	}

	//GetSet
	public Item getReward() {
		return reward;
	}
	public void setReward(Item reward) {
		this.reward = reward;
	}
	
	

	
}
