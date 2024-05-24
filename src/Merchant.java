import java.util.List;

public class Merchant extends Pnj {
	//Var
	private int[] prices;

	//Cons
	public Merchant(String spritePath, String[] dialog, String name, List<Item> items, int[] prices) {
		super(spritePath, dialog, name);
		this.prices = prices;
		
		this.setInventory(items);
		
	}

	//GetSet
	public int[] getPrices() {
		return prices;
	}
	public void setPrices(int[] prices) {
		this.prices = prices;
	}
	
	
	

}
