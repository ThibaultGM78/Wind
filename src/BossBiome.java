
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
				this.getTile(i, j).setBloc(Constantes.BLOC_4.deepCopy());
			}
		}
		
		this.getTile(5, 5).setBloc(Constantes.BLOC_5.deepCopy());
		this.getTile(5, 5).setTpTile(0, 3, 2);
		
	}
	
	

}
