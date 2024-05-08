

public abstract class Biome {
	//Var
	private int height;
	private int width;
	private int spawnX;
	private int spawnY;

	private Tile[][] tiles; 
	//private Extends Entity[][] entities;
	 
	//Super
	public Biome (int height, int width, int spawnX, int spawnY){
		
		this.height = height;
		this.width = width;
		this.tiles = new Tile[this.height][this.width];
		
		this.spawnX = spawnX;
		this.spawnY = spawnY;
		
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
	
	public int getSpawnX() {
		return spawnX;
	}
	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}
	public int getSpawnY() {
		return spawnY;
	}
	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
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
		
			if(this.getTile(x, y).getBloc().getId() == 3 && p.inventoryContainsItem(Constantes.ITEM_KEY.getId())) {
				this.getTile(x, y).setBloc(Constantes.BLOC_0.deepCopy());
			}
			
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
