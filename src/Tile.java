
public class Tile {
	//Var
	private Bloc bloc;
	private Pnj pnj;
	private FightingEntity pokemon;
	
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

	public FightingEntity getPokemon() {
		return pokemon;
	}

	public void setPokemon(FightingEntity pokemon) {
		this.pokemon = pokemon;
	}
}
