
public class BossBiome extends Biome{

	public BossBiome() {
		super(11, 11,1);
	}
	@Override
	public void initBiome() {
		
		int i, j;
		
		for( i = 0; i < this.getWidth(); i++) {
			for(j = 0; j < this.getHeight(); j++) {
				this.setTile(i,j,new Tile());
				this.getTile(i, j).setBloc(Constantes.BLOC_11.deepCopy());
			}
		}
		
		//Enter
		this.getTile(5, 0).setBloc(Constantes.BLOC_5.deepCopy());
		this.getTile(5, 0).setTpTile(0, 3, 1);
		
		this.getTile(1, 1).setBloc(Constantes.BLOC_6.deepCopy());
		this.getTile(1, 2).setBloc(Constantes.BLOC_6.deepCopy());
		this.getTile(1, 3).setBloc(Constantes.BLOC_6.deepCopy());
		this.getTile(2, 2).setBloc(Constantes.BLOC_6.deepCopy());
		
		this.getTile(8, 6).setBloc(Constantes.BLOC_6.deepCopy());
		this.getTile(9, 6).setBloc(Constantes.BLOC_6.deepCopy());
		this.getTile(9, 7).setBloc(Constantes.BLOC_6.deepCopy());
		
		this.getTile(2, 8).setBloc(Constantes.BLOC_6.deepCopy());
	
		//Papi
		String[] dialog = {"A l'aide ... Bat le dracofeu"};
		this.getTile(7, 3).setPnj(new Pnj("./vieux.png",dialog,"vieux"));
		
		//Boss
		this.getTile(5,7).setPokemon(new Pokemon("./dracofeu2.png","Dracofeu",40,15,"./dracofeu.png"));
		this.getTile(5,7).getPokemon().getInventory().add(Constantes.ITEM_POTION.deepCopy());
		
	}
	
	

}
