/**
 * @brief Represents a non-player character (NPC) entity in the game.
 */
public class Pnj extends Entity{

	private String[] dialog;
	
	//Cons
	/**
     * @brief Constructs a Pnj object with the specified sprite, dialog, and name.
     * 
     * @param spritePath The file path of the sprite image for the NPC.
     * @param dialog     An array of strings representing the dialogues spoken by the NPC.
     * @param name       The name of the NPC.
     */
	public Pnj(String spritePath, String[] dialog, String name) {
		super(spritePath,name);
		this.dialog = dialog;
	}
	
	//Meth
	/**
     * @brief Gets the dialogues spoken by the NPC.
     * 
     * @return An array of strings representing the dialogues spoken by the NPC.
     */
	public String[] getDialog() {
		return dialog;
	}
	
}
