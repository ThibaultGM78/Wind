
public class HouseBiome extends Biome {

	public HouseBiome() {
		super(Constantes.NUMBER_OF_ROW, Constantes.NUMBER_OF_COL, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initBiome() {
		
		int i = 0;
		int j = 0;
		for( i = 0; i < this.getWidth(); i++) {
			for(j = 0; j < this.getHeight(); j++) {
				this.setTile(i,j,new Tile());
				this.getTile(i, j).setBloc(Constantes.BLOC_9.deepCopy());
			}
		}
		
		for( i = 1; i < 11; i++) {
			this.getTile(5, i).setBloc(Constantes.BLOC_7.deepCopy());
		}
		for( i = 0; i < 11; i++) {
			this.getTile(i, 5).setBloc(Constantes.BLOC_7.deepCopy());
		}
		this.getTile(5, 0).setBloc(Constantes.BLOC_10.deepCopy());
		this.getTile(5, 0).setTpTile(0, 11, 6);
		
		//PNJ
		String[] dialog = {"S'il te plait, aide mon ami bloqué dans la grotte"};
		this.getTile(1, 2).setPnj(new Pnj("file:img/vieux.png",dialog,"vieux"));
	
		//Loot
		this.getTile(8, 2).setItem(Constantes.ITEM_POTION.deepCopy());
	}

}
