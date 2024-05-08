
public class Tile {
	//Var
	private Bloc bloc;
	private Pnj pnj;
	private Pokemon pokemon;
	private Biome biome;
	
	//Cons
	public Tile() {
		super();
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

	public Biome getBiome() {
		return biome;
	}

	public void setBiome(Biome biome) {
		this.biome = biome;
	}
}
