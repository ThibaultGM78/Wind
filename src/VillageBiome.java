

public class VillageBiome extends Biome{
	
	public VillageBiome() {
		super(11 * 2, 11 * 2,0);
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
		for( i = 0; i < 2; i++) {
			for(j = 6; j < 22; j++) {
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
		
		//Water
	
		for(i = 0; i < 6; i++) {
			this.getTile(i, 11).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 8; i++) {
			this.getTile(i, 12).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 9; i++) {
			this.getTile(i, 13).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 14).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 15).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 16).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 17).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 18).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 10; i++) {
			this.getTile(i, 19).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 11; i++) {
			this.getTile(i, 20).setBloc(Constantes.BLOC_6.deepCopy());
		}
		for(i = 0; i < 13; i++) {
			this.getTile(i, 21).setBloc(Constantes.BLOC_6.deepCopy());
		}
		
		//Chemin
		for(i = 7; i < 17; i++) {
			this.getTile(11, i).setBloc(Constantes.BLOC_4.deepCopy());
		}
		this.getTile(10, 16).setBloc(Constantes.BLOC_4.deepCopy());
		for(i = 3; i < 12; i++) {
			this.getTile(i, 9).setBloc(Constantes.BLOC_4.deepCopy());
		}
		for(i = 5; i < 9; i++) {
			this.getTile(3, i).setBloc(Constantes.BLOC_4.deepCopy());
		}
		
		//Ponton
		for(i = 4; i < 10; i++) {
			this.getTile(i, 16).setBloc(Constantes.BLOC_7.deepCopy());
		}
	
		//Barriere
		this.getTile(3, 4).setBloc(Constantes.BLOC_3.deepCopy());
		
		//BossBiome
		this.getTile(3, 0).setBloc(Constantes.BLOC_5.deepCopy());
		this.getTile(3, 0).setTpTile(1, 5, 1);
		
		//Pnj
		String[] dialog = {"Pikachu à volé les clé du portail."};
		this.getTile(5, 5).setPnj(new Pnj("file:img/vieux.png",dialog,"vieux"));
		this.getTile(5, 5).getPnj().getInventory().add(Constantes.ITEM_BALL.deepCopy());
		
		//Poke
		this.getTile(4, 16).setPokemon(new Pokemon("file:img/pikachu2.png","Pikachu",30,10,"file:img/pikachu.png"));
		this.getTile(4,16).getPokemon().setReward(Constantes.ITEM_KEY.deepCopy());
		
		//house
		this.getTile(11, 5).setBloc(Constantes.BLOC_8.deepCopy());
		this.getTile(11, 5).setTpTile(2, 5, 1);
		

	}
}
