
public class Pnj extends Entity{

	private String[] dialog;
	
	//Cons
	public Pnj(String spritePath, String[] dialog, String name) {
		super(spritePath,name);
		this.dialog = dialog;
	}
	
	//Meth
	public String[] getDialog() {
		return dialog;
	}
	
}
