/**
 * @brief Represents a Pokémon entity in the game.
 */
public class Pokemon extends FightingEntity{
	//Var
	private Item reward;
	
	//Cons
	 /**
     * @brief Constructs a Pokémon object with the specified sprite, name, health, attack, and duel sprite.
     * 
     * @param spritePath     The file path of the sprite image for the Pokémon.
     * @param name           The name of the Pokémon.
     * @param hp             The health points (HP) of the Pokémon.
     * @param atk            The attack power of the Pokémon.
     * @param duelSpritePath The file path of the sprite image used during duels for the Pokémon.
     */
	public Pokemon(String spritePath, String name, double hp, double atk, String duelSpritePath) {
		super(spritePath, name, hp, atk, duelSpritePath);
		
	}

	//GetSet
	 /**
     * @brief Gets the reward item associated with defeating the Pokémon.
     * 
     * @return The reward item.
     */
	public Item getReward() {
		return reward;
	}
	/**
     * @brief Sets the reward item associated with defeating the Pokémon.
     * 
     * @param reward The reward item to be set.
     */
	public void setReward(Item reward) {
		this.reward = reward;
	}
	
	

	
}
