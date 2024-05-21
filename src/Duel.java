import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Duel {
	//VAR
	private Player player;
	private Pokemon pokemon;
	private Scene scene;
	private Stage primaryStage;
	
	private boolean isClose;
	private boolean isPlayerWin;
	private Consumer<Boolean> closeChangeListener;
	
	//VarFX;
	private ComboBox<String> itemsBox;
	private Button btnUse;

	
	//Cons
	public Duel(Stage primaryStage, Player player, Pokemon pokemon) {
		this.primaryStage = primaryStage;
		this.player = player;
		this.pokemon = pokemon;
		this.isClose = false;
		
		this.btnUse = new Button("Utiliser");
		this.btnUse.setOnAction(e -> {
	    	 this.handleUseBtn();
	     });
		
		this.scene = new Scene(this.loadDuel(), Constantes.STAGE_HEIGHT , Constantes.STAGE_WIDTH);
		this.primaryStage.setScene(this.scene);
	}
	
	//GetSet
	public boolean isPlayerWin() {
		return this.isPlayerWin;
	}
	public Pokemon getPokemon() {
		return this.pokemon;
	}
	public void setPokemon(Pokemon p) {
		this.pokemon = p;
	}
	//Listener
	public boolean getIsClose() {
        return this.isClose;
    }

    public void setIsClose(boolean b) {
        this.isClose = b;
        if (closeChangeListener != null) {
            closeChangeListener.accept(b);
        }
    }

    public void setCloseChangeListener(Consumer<Boolean> listener) {
        this.closeChangeListener = listener;
    }
	
	//Met
    public void nextTurn() {
    	
    	if(pokemon.isKo()) {
			System.out.println("Victoire");
			this.isPlayerWin = true;
			this.setIsClose(true);
		}
		else {

			this.pokemonTurn();
			
			if (this.player.isKo()) {
				System.out.println("Defaite");
				this.isPlayerWin = false;
				this.setIsClose(true);
			}
			else {
				System.out.println("\nTour joueur:");
				this.scene.setRoot(this.loadDuel());
			    this.primaryStage.setScene(this.scene);
			}
			
		}
    }
    
    private void pokemonTurn() {
    	
    	System.out.println("Tour adverse:");
    	
    	this.player.receiveDamage(pokemon.getAtk());
    	
    	List<Item> inventoryDuel = this.pokemon.getInventoryDuel();
    	
    	if(!inventoryDuel.isEmpty()) {
    		pokemon.useObject(inventoryDuel.get(0).getName());

    	}
    	
    }
    
    private void loadItemBox() {
    	ComboBox<String> comboBox = new ComboBox<>();
    	
    	if(this.player.getInventory().isEmpty()) {
    		comboBox.getItems().add("vide");
    	}
    	else {
    		for(Item item : this.player.getInventory()) {
    			
    			if(item.isUseableInDuel()) {
    				comboBox.getItems().add(item.getName());
    			}
    	    	
    	    }  
    	}
    	
    	 this.itemsBox = comboBox;	    
    }
    
    public void handleUseBtn() {
    	
    	if(this.itemsBox.getValue() != null) {
    		
    		if(!this.itemsBox.getValue().equals("vide")) {
    			
    			this.player.useObject(this.itemsBox.getValue().toString());
            	//this.nextTurn();
            	this.scene.setRoot(this.loadDuel());
			    this.primaryStage.setScene(this.scene);
    		}	
    	}		
    }
    
	public GridPane loadDuel() {
	
		GridPane gridPane = new GridPane();
	
	    for (int row = 0; row < 3; row++) {
	        for (int col = 0; col < 2; col++) {
	            
		       	 Rectangle border = new Rectangle(Constantes.STAGE_WIDTH/2, Constantes.STAGE_HEIGHT/3);
		         border.setFill(null);
		         border.setStroke(Color.BLACK); 
		         border.setStrokeWidth(1); 
	      
	        	
		         gridPane.add(border, col, row);
	        }
	    }
	    
	    //ImgPokemon
	    ImageView img = new ImageView(new Image(this.pokemon.getDuelSpritePath()));
		img.setFitHeight(Constantes.STAGE_HEIGHT/3);
		img.setFitWidth(Constantes.STAGE_WIDTH/2);
		gridPane.add(img, 1, 0);
		
		//ImgPlayer
		ImageView imgPlayer = new ImageView(new Image(this.player.getDuelSpritePath()));
		imgPlayer.setFitHeight(Constantes.STAGE_HEIGHT/3);
		imgPlayer.setFitWidth(Constantes.STAGE_WIDTH/2);
		gridPane.add(imgPlayer, 0, 1);
		
		//HpPokemon
		Label hpPoke = new Label(this.pokemon.getHp() + " / " + this.pokemon.getHpMax());
		gridPane.add(hpPoke, 0, 0);
		
		//HpPlayer
		Label hpPlayer = new Label(this.player.getHp() + " / " + this.player.getHpMax());
		gridPane.add(hpPlayer, 1, 1);
		
		//Atk
		 Button buttonAtk = new Button("Attaque");
	     buttonAtk.setOnAction(e -> {
	          pokemon.receiveDamage(this.player.getAtk());
	          this.nextTurn();
	      });
	     gridPane.add(buttonAtk, 0,2);
	     
	     //UseItem
	     GridPane gridItem = new GridPane();
	     for (int col = 0; col < 2; col++) {
	     
	       	 Rectangle border = new Rectangle(Constantes.STAGE_WIDTH/4, Constantes.STAGE_HEIGHT/3);
	         border.setFill(null);
	         border.setStroke(Color.BLACK); 
	         border.setStrokeWidth(1); 
      
        	
	         gridItem.add(border, col, 0);    
	     }
	     
	     this.loadItemBox();
	     gridItem.add(this.itemsBox,0,0);
	     
	     gridItem.add(this.btnUse,1,0);
	     gridPane.add(gridItem, 1, 2);
	     
	     
	     
	    return gridPane;
	}

}
