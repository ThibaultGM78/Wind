

public abstract class Biome {
	//Var
	private int height;
	private int width;

	private Tile[][] tiles; 
	//private Extends Entity[][] entities;
	 
	//Super
	public Biome (){
		
		this.height = 11 * 4;
		this.width = 11 * 4;
		this.tiles = new Tile[this.height][this.width];
		
		this.initBiome();
	}
	//GetSet
	public Tile getTile(int i, int j) {
		return this.tiles[i][j];
	}
	public void setTile(int i, int j, Tile t) {
		this.tiles[i][j] = t;
	}
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	//Meth
	public boolean isTileExist(int x, int y) {

		if(x < 0 || y < 0) {
			System.out.println("Bloque");
			return false;
		}
		if(x >= this.width || y >= this.height) {
			System.out.println("Bloque");
			return false;
		}
		return true;
	}
	
	public boolean moveIsPossible(int x, int y, Player p) {
		
		if(!this.isTileExist(x, y)) {
			System.out.println("Bloque");
			return false;
		}
		if(this.getTile(x, y).getBloc().isSolid()) {
		
			System.out.println("Bloque");
			return false;

		}
		if(this.getTile(x,y).getPnj() != null || this.getTile(x, y).getPokemon() != null) {
			return false;
		}
		
		
		return true;
	}

	//Abstract
	public abstract void initBiome();
}
