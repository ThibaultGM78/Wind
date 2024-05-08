
public class Tile {
	//Var
	private Bloc bloc;
	private Pnj pnj;
	private Pokemon pokemon;
	
	private boolean isTpTile;
	private int spawnX;
	private int spawnY;
	private int idTpBiome;
	
	//Cons
	public Tile() {
		super();
		this.isTpTile = false;
	}
	
	//GetSet
	public Bloc getBloc() {
		return bloc;
	}

	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}

	public Pnj getPnj() {
		return pnj;
	}

	public void setPnj(Pnj pnj) {
		this.pnj = pnj;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public boolean isTpTile() {
		return isTpTile;
	}

	public void setTpTile(boolean isTpTile) {
		this.isTpTile = isTpTile;
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

	public int getIdTpBiome() {
		return idTpBiome;
	}

	public void setIdTpBiome(int idTpBiome) {
		this.idTpBiome = idTpBiome;
	}

	//Meth
	public void setTpTile(int idBiome, int x, int y) {
		this.idTpBiome = idBiome;
		this.spawnX = x;
		this.spawnY = y;
		this.isTpTile = true;
	}
	
}
