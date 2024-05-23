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

/**
 * @brief Represents a duel between the player and a Pokémon.
 */
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
	/**
	 * @brief Constructs a Duel with the specified player and Pokémon.
	 * 
	 * @param primaryStage The primary stage of the application.
	 * @param player The player participating in the duel.
	 * @param pokemon The Pokémon opposing the player.
	 */
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
	/**
	 * @brief Checks if the player has won the duel.
	 * 
	 * @return True if the player has won, false otherwise.
	 */
	public boolean isPlayerWin() {
		return this.isPlayerWin;
	}
	/**
	 * @brief Gets the Pokémon opposing the player.
	 * 
	 * @return The opposing Pokémon.
	 */
	public Pokemon getPokemon() {
		return this.pokemon;
	}
	/**
	 * @brief Sets the Pokémon opposing the player.
	 * 
	 * @param p The new opposing Pokémon.
	 */
	public void setPokemon(Pokemon p) {
		this.pokemon = p;
	}
	//Listener
	/**
	 * @brief Checks if the duel is close.
	 * 
	 * @return True if the duel is close, false otherwise.
	 */
	public boolean getIsClose() {
        return this.isClose;
    }
	/**
	 * @brief Sets the state of the duel to close or open.
	 * 
	 * @param b True to close the duel, false to keep it open.
	 */
    public void setIsClose(boolean b) {
        this.isClose = b;
        if (closeChangeListener != null) {
            closeChangeListener.accept(b);
        }
    }
    /**
	 * @brief Sets the listener for changes to the duel's close state.
	 * 
	 * @param listener The listener to be notified of close state changes.
	 */
    public void setCloseChangeListener(Consumer<Boolean> listener) {
        this.closeChangeListener = listener;
    }
	
	//Met
    /**
	 * @brief Proceeds to the next turn in the duel.
	 */
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
	/**
	 * @brief Executes the Pokémon's turn in the duel.
	 */
    private void pokemonTurn() {
    	
    	System.out.println("Tour adverse:");
    	
    	this.player.receiveDamage(pokemon.getAtk());
    	
    	List<Item> inventoryDuel = this.pokemon.getInventoryDuel();
    	
    	if(!inventoryDuel.isEmpty()) {
    		pokemon.useObject(inventoryDuel.get(0).getName());

    	}
    	
    }
    /**
	 * @brief Loads the items available in the player's inventory into the items combo box.
	 */
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
    /**
	 * @brief Handles the use button click event.
	 */
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
    /**
	 * @brief Loads the duel interface.
	 * 
	 * @return The GridPane representing the duel interface.
	 */
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
