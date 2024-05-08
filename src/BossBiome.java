
public class BossBiome extends Biome{

	public BossBiome(int spawnX, int spawnY) {
		super(11, 11, spawnX, spawnY);
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
		
		this.getTile(3, 1).setBloc(Constantes.BLOC_5.deepCopy());
		this.getTile(3, 1).setBiome(new VillageBiome(1,1));
	}
	
	

}
