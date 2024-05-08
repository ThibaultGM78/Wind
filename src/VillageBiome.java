

public class VillageBiome extends Biome{
	
	public VillageBiome() {
		super();
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
		
		this.getTile(3, 3).setBloc(Constantes.BLOC_1.deepCopy());
		
		String[] dialog = {"Bonjour, prend ce present."};
		this.getTile(5, 5).setPnj(new Pnj("./vieux.png",dialog,"vieux"));
		this.getTile(5, 5).getPnj().getInventory().add(Constantes.ITEM_BALL.deepCopy());
		
		this.getTile(6, 6).setPokemon(new FightingEntity("./dracofeu2.png","Dracofeu",40,15,"./dracofeu.png"));

	}
}
