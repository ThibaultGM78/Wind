/**
 * @brief Represents a Pok�mon entity in the game.
 */
public class Pokemon extends FightingEntity{
	//Var
	private Item reward;
	
	//Cons
	 /**
     * @brief Constructs a Pok�mon object with the specified sprite, name, health, attack, and duel sprite.
     * 
     * @param spritePath     The file path of the sprite image for the Pok�mon.
     * @param name           The name of the Pok�mon.
     * @param hp             The health points (HP) of the Pok�mon.
     * @param atk            The attack power of the Pok�mon.
     * @param duelSpritePath The file path of the sprite image used during duels for the Pok�mon.
     */
	public Pokemon(String spritePath, String name, double hp, double atk, String duelSpritePath) {
		super(spritePath, name, hp, atk, duelSpritePath);
		
	}

	//GetSet
	 /**
     * @brief Gets the reward item associated with defeating the Pok�mon.
     * 
     * @return The reward item.
     */
	public Item getReward() {
		return reward;
	}
	/**
     * @brief Sets the reward item associated with defeating the Pok�mon.
     * 
     * @param reward The reward item to be set.
     */
	public void setReward(Item reward) {
		this.reward = reward;
	}
	
	

	
}
