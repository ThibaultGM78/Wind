

public class VillageBiome extends Biome{
	
	public VillageBiome(int spawnX, int spawnY) {
		super(11 * 2, 11 * 2, spawnX, spawnY);
	}
	
	public void initBiome() {
		int i = 0;
		int j = 0;
		for( i = 0; i < this.getWidth(); i++) {
			for(j = 0; j < this.getHeight(); j++) {
				this.setTile(i,j,new Tile());
				this.getTile(i, j).setBloc(Constantes.BLOC_0.deepCopy());
			}
		}
		
		//Foret
		for( i = 0; i < 4; i++) {
			for(j = 0; j < 2; j++) {
				this.getTile(j, i).setBloc(Constantes.BLOC_2.deepCopy());
			}
		}
		for( i = 0; i < 4; i++) {
			for(j = 5; j < 7; j++) {
				this.getTile(j, i).setBloc(Constantes.BLOC_2.deepCopy());
			}
		}
		this.getTile(1, 4).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(2, 4).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(2, 0).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(3, 0).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(4, 0).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(2, 1).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(4, 1).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(4, 4).setBloc(Constantes.BLOC_2.deepCopy());
		this.getTile(5, 4).setBloc(Constantes.BLOC_2.deepCopy());
		
		//Barriere
		//this.getTile(3, 4).setBloc(Constantes.BLOC_3.deepCopy());
		
		//BossBiome
		this.getTile(3, 1).setBloc(Constantes.BLOC_5.deepCopy());
		this.getTile(3, 1).setBiome(new BossBiome(1,1));
		
		//Pnj
		String[] dialog = {"Bonjour, prend ce present."};
		this.getTile(5, 5).setPnj(new Pnj("./vieux.png",dialog,"vieux"));
		this.getTile(5, 5).getPnj().getInventory().add(Constantes.ITEM_BALL.deepCopy());
		
		//Poke
		this.getTile(6, 6).setPokemon(new Pokemon("./dracofeu2.png","Dracofeu",40,15,"./dracofeu.png"));
		this.getTile(6,6).getPokemon().getInventory().add(Constantes.ITEM_POTION.deepCopy());
		this.getTile(6,6).getPokemon().setReward(Constantes.ITEM_KEY.deepCopy());

	}
}
