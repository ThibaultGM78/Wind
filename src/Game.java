import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @brief Represents the game logic and UI.
 */
public class Game {
	//Variable
	private Scene mapScene;
	private Scene inventoryScene;
	private Scene duelScene;
	private Biome biome;
	private Player player;
	private Stage primaryStage;
	
	//Cons
	/**
     * @brief Constructs the game with the specified primary stage.
     * 
     * @param primaryStage The primary stage of the game.
     */
	public Game(Stage primaryStage) {
		super();
		
		this.player = new Player();
		this.primaryStage = primaryStage;
		
		this.goToSpawnPoint();
		
        this.mapScene = new Scene(this.loadBiome(), Constantes.STAGE_HEIGHT , Constantes.STAGE_WIDTH);
        this.mapScene.setOnKeyPressed(e -> {
	       	 if(e.getCode().equals(Constantes.KEY_INVENTORY)) {
	       	        System.out.println("Inventaire ouvert");        
	       	        //this.primaryStage.setScene(this.getPlayer().getInventoryScene());
	       	        this.inventoryScene.setRoot(this.loadInventory());
	       	        this.primaryStage.setScene(this.inventoryScene);
	       	    }
	       	 else if(e.getCode().equals(Constantes.KEY_MOVE_TOP)){
		 	        this.playerMoveTop();
		       	 }
	       	 else if(e.getCode().equals(Constantes.KEY_MOVE_BOTTOM)){
	 	 	        this.playerMoveBottom();
	 	       	 }
	       	 else if(e.getCode().equals(Constantes.KEY_MOVE_LEFT)){
	  	 	        this.playerMoveLeft();
	  	       	 }
	       	 else if(e.getCode().equals(Constantes.KEY_MOVE_RIGHT)){
	  	 	        this.playerMoveRight();
	  	       	 }
	       	 else if(e.getCode().equals(Constantes.KEY_INTERACTION)) {
	       		 this.playerInteraction();
	       	 }
	    });
        
        
        this.inventoryScene = new Scene(this.loadInventory(), Constantes.STAGE_HEIGHT, Constantes.STAGE_WIDTH); 
        this.inventoryScene.setOnKeyPressed(e -> {
	       	 if (e.getCode().equals(Constantes.KEY_INVENTORY)) {
	 	        System.out.println("Inventaire fermé");
	 	        this.primaryStage.setScene(this.mapScene);
	       	 }
        });
        
        Label emptyLabel = new Label("");
        this.duelScene = new Scene(emptyLabel, Constantes.STAGE_HEIGHT, Constantes.STAGE_WIDTH); 
        this.duelScene.setOnKeyPressed(e -> {
	       	 if (e.getCode().equals(Constantes.KEY_INVENTORY)) {
	 	        System.out.println("Hello");
	       	 }
        });
        
        //Controle Scene
        Label control = new Label();
        control.setAlignment(Pos.CENTER);
        control.setText(" ZQSD pour se deplacer.\n F pour interagir.\n E pour l'inventaire.\n Appuyer sur F pour commenceer à jouer");
        
        Scene controlScene = new Scene(control, Constantes.STAGE_HEIGHT , Constantes.STAGE_WIDTH);
        controlScene.setOnKeyPressed(e -> {
	       	 if (e.getCode().equals(Constantes.KEY_INTERACTION)) {
	       		this.primaryStage.setScene(this.mapScene);
	       	 } 
        });
        
        this.primaryStage.setTitle("GAME");
        this.primaryStage.setScene(controlScene);
        this.primaryStage.show();
	}
		
	//GetSet
    /**
     * @brief Gets the minimum row view.
     * 
     * @return The minimum row view.
     */
	public int getMinRowView() {
		return (int) Math.ceil(Constantes.NUMBER_OF_ROW / 2);
	}
	/**
     * @brief Gets the maximum row view.
     * 
     * @return The maximum row view.
     */
	public int getMaxRowView() {
		return this.biome.getWidth() - this.getMinRowView() - 1;
	}
	/**
     * @brief Gets the minimum column view.
     * 
     * @return The minimum column view.
     */
	public int getMinColView() {
		return (int) Math.ceil(Constantes.NUMBER_OF_COL / 2);
	}
	/**
     * @brief Gets the maximum column view.
     * 
     * @return The maximum column view.
     */
	public int getMaxColView() {
		return this.biome.getHeight() - this.getMinRowView() - 1;
	}

	//Methode
	/**
     * @brief Moves the player to the spawn point.
     */
	public void goToSpawnPoint() {
		this.biome = Constantes.BIOME_HOUSE;
		this.player.setPosX(2);
		this.player.setPosY(7);
	}
	/**
     * @brief Handles player movement.
     */
	public void playerMove() {
		if(this.biome.getTile(this.player.getPosX(), this.player.getPosY()).isTpTile()) {
			
			int x = this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getSpawnX();
			int y = this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getSpawnY();
			
			switch(this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getIdTpBiome()) {
			 case 0:
				 this.biome = Constantes.BIOME_VILLAGE;
				 break;
			 case 1:
				 this.biome = Constantes.BIOME_BOSS;
				 break;
			 case 2:
				 this.biome = Constantes.BIOME_HOUSE;
			 	 break;
			default:
				break;
			}
			
			this.player.setPosX(x);
			this.player.setPosY(y);
			this.player.setDirection(Constantes.DIRECTION_SOUTH);
		}
		
	}
	/**
     * @brief Moves the player up.
     */
	public void playerMoveTop() {
		System.out.println("Joueur monte");
		
		int x = this.player.getPosX();
		int y = this.player.getPosY() - 1;
		
		this.player.setDirection(Constantes.DIRECTION_NORTH);
		if(this.biome.moveIsPossible(x, y, this.player)) {
			this.player.setPosY(y);
			this.playerMove();
		}

		this.mapScene.setRoot(this.loadBiome());
	}
	/**
     * @brief Moves the player down.
     */
	public void playerMoveBottom() {
		System.out.println("Joueur descend"); 
		
		int x = this.player.getPosX();
		int y = this.player.getPosY() + 1;
		
		this.player.setDirection(Constantes.DIRECTION_SOUTH);
		if(this.biome.moveIsPossible(x, y, this.player)) {
			this.player.setPosY(y);
			this.playerMove();
		}	
		this.mapScene.setRoot(this.loadBiome());
	}
	/**
     * @brief Moves the player left.
     */
	public void playerMoveLeft() {
		System.out.println("Joueur Gauche"); 
		
		int x = this.player.getPosX() - 1;
		int y = this.player.getPosY();
		
		this.player.setDirection(Constantes.DIRECTION_WEST);
		if(this.biome.moveIsPossible(x, y, this.player)) {
			this.player.setPosX(x);
			this.playerMove();
		}
		this.mapScene.setRoot(this.loadBiome());
	}
	 /**
     * @brief Moves the player right.
     */
	public void playerMoveRight() {
		System.out.println("Joueur Droit"); 
		
		int x = this.player.getPosX() + 1;
		int y = this.player.getPosY();
		
		this.player.setDirection(Constantes.DIRECTION_EAST);
		if(this.biome.moveIsPossible(x, y, this.player)) {
			this.player.setPosX(x);
			this.playerMove();
		}
		this.mapScene.setRoot(this.loadBiome());
	}
	/**
     * @brief Handles player interaction.
     */
	public void playerInteraction() {
		int x = this.player.getPosX();
		int y = this.player.getPosY();
		
		switch(this.player.getDirection()) {
			case Constantes.DIRECTION_NORTH:
				y -= 1;
				break;
			case Constantes.DIRECTION_SOUTH:
				y += 1;
				break;
			case Constantes.DIRECTION_WEST:
				x -= 1;
				break;
			case Constantes.DIRECTION_EAST:
				x += 1;
				break;
			default:
				break;
		}
		
		if(this.biome.isTileExist(x, y)) {
			if(this.biome.getTile(x, y).getPnj() != null && this.biome.getTile(x, y).getPnj().getDialog() != null) {
				
				//int nLine = this.biome.getTile(x, y).getPnj().getDialog().length;
				//int i = 0;
				
		    	this.loadTextBox(this.biome.getTile(x, y).getPnj().getDialog()[0]);
		    	
		    	if(this.biome.getTile(x, y).getPnj() instanceof Merchant) {
	    			System.out.println("oui");
	    			this.loadMarchanding(x,y);
	    			
	    		}else if(!this.biome.getTile(x, y).getPnj().getInventory().isEmpty()) {
		    		
		    		System.out.println("donne " + this.biome.getTile(x, y).getPnj().getInventoryElement(0).getName());
		    		this.player.getInventory().add(this.biome.getTile(x, y).getPnj().getInventoryElement(0).deepCopy());
		    		this.biome.getTile(x, y).getPnj().getInventory().remove(0);
		    		
		    	}
		    	
			}
			else if(this.biome.getTile(x, y).getPokemon() != null) {
				System.out.println("Debut du combat");		
				
				final int xf = x;
				final int yf = y;
				
				Duel duel = new Duel(this.primaryStage, this.player, this.biome.getTile(x, y).getPokemon());
				duel.setCloseChangeListener(isClose -> this.endDuel(duel,xf,yf));
				
				if(this.biome.getTile(x, y).getPokemon().isKo()) {
					this.mapScene.setRoot(this.loadBiome());
					this.biome.getTile(x, y).setPokemon(null);
				}	
			}
			else if(this.biome.getTile(x, y).getItem() != null) {
				
				Item item = this.biome.getTile(x, y).getItem();
				
				this.biome.getTile(x, y).setItem(null);
				this.mapScene.setRoot(this.loadBiome());
				
				this.player.getInventory().add(item);
				this.loadTextBox(this.player.getName() + " obtient " + item.getName());
				
			}
		}
	}
	/**
     * @brief Ends the duel.
     * 
     * @param duel The duel instance.
     * @param x The x-coordinate of the player.
     * @param y The y-coordinate of the player.
     */
	public void endDuel(Duel duel, int x, int y) {
		if (duel.getIsClose()) {
            System.out.println("Fin du combat");
            
            this.mapScene.setRoot(this.loadBiome());
            this.primaryStage.setScene(this.mapScene);
            
            if(duel.isPlayerWin()) {
				
				if(duel.getPokemon().getReward() != null) {
					
					this.mapScene.setRoot(this.loadBiome());
					this.loadTextBox(this.player.getName() + " obtient " + duel.getPokemon().getReward().getName());
					this.player.getInventory().add(duel.getPokemon().getReward());
					this.loadTextBox(this.player.getName() + " recoit " + duel.getPokemon().getReward().getName());
				}
				
				this.biome.getTile(x, y).setPokemon(null);
				this.mapScene.setRoot(this.loadBiome());
				
			}
            else {
            	this.goToSpawnPoint();
            	this.player.setHp(this.player.getHpMax());
            	this.loadTextBox("Papi vous a sauvé et guérit");
            }
       
        }
	}
	//Load
	/**
     * @brief Loads the biome.
     * 
     * @return The grid pane representing the biome.
     */
	public GridPane loadBiome() {
		
		GridPane gridPane = new GridPane();

		int endGameStatut = this.checkEndGame();
		if(endGameStatut == Constantes.NO_WIN) {
			int c;
			if(this.player.getPosX() <= this.getMinRowView() ) {
				c = 0;
			}
			else if (this.player.getPosX() >= this.getMaxRowView()) {
				c = this.getMaxRowView() - this.getMinRowView();
			}
			else {
				c = this.player.getPosX() - this.getMinRowView();
			}
			
			int r;
			if(this.player.getPosY() <= this.getMinColView() ) {
				r = 0;
			}
			else if (this.player.getPosY() >= this.getMaxColView()) {
				r = this.getMaxColView() - this.getMinColView();
			}
			else {
				r = this.player.getPosY() - this.getMinColView();
			}
			
		
	        for (int row = 0; row < Constantes.NUMBER_OF_ROW; row++) {
	            for (int col = 0; col < Constantes.NUMBER_OF_COL; col++) {
	               
	                gridPane.add(this.biome.getTile(col + c, row + r).getBloc().getSprite(), col, row);
	                
	                if(this.biome.getTile(col + c, row + r).getPnj() != null) {
	                	gridPane.add(this.biome.getTile(col + c, row + r).getPnj().getSprite(), col, row);
	                }
	                
	                if(this.biome.getTile(col + c, row + r).getPokemon() != null) {
	                	gridPane.add(this.biome.getTile(col + c, row + r).getPokemon().getSprite(), col, row);
	                }
	                
	                if(this.biome.getTile(col + c, row + r).getItem() != null) {
	                	
	                	ImageView img = new ImageView(new Image("file:img/pokeball.png"));
	                	img.setFitHeight(Constantes.CASE_HEIGHT);
	                	img.setFitWidth(Constantes.CASE_WIDTH);
	                	
	                	gridPane.add(img, col, row);
	                }
	                
	            }
	        }
	        System.out.println(this.player.toString());
	     
	        int x;
	        if(this.player.getPosX() <= this.getMinRowView()) {
	        	x = this.player.getPosX();
	        }
	        else if(this.player.getPosX() >= this.getMaxRowView()) {
	        	x = this.player.getPosX() - this.getMaxRowView() + this.getMinRowView();
	        }
	        else {
	        	x = this.getMinRowView();
	        }
	        
	        int y;
	        if(this.player.getPosY() <= this.getMinColView()) {
	        	y = this.player.getPosY();
	        }
	        else if(this.player.getPosY() >= this.getMaxColView()) {
	        	y = this.player.getPosY() - this.getMaxColView() + this.getMinColView();
	        }
	        else {
	        	y = this.getMinColView();
	        }
	        
	        gridPane.add(this.player.getSprite(), x, y);
	        
	        Label life = new Label(this.player.getHp() + " / " + this.player.getHpMax());
	        life.setFont(Font.font("System", FontWeight.BOLD, 8));
	        life.setTextFill(Color.WHITE);
	        gridPane.add(life, Constantes.NUMBER_OF_COL - 1, 0); 
	        
	        Label lifeTitle = new Label("Vie :");
	        lifeTitle.setFont(Font.font("System", FontWeight.BOLD, 8));
	        lifeTitle.setTextFill(Color.WHITE);
	        gridPane.add(lifeTitle, Constantes.NUMBER_OF_COL - 2, 0); 
	        
	        Label money = new Label(this.player.getCoins() + "");
	        money.setFont(Font.font("System", FontWeight.BOLD, 8));
	        money.setTextFill(Color.WHITE);
	        gridPane.add(money, Constantes.NUMBER_OF_COL - 1, 1); 
	        
	        Label moneyTitle = new Label("Argent :");
	        moneyTitle.setFont(Font.font("System", FontWeight.BOLD, 8));
	        moneyTitle.setTextFill(Color.WHITE);
	        gridPane.add(moneyTitle, Constantes.NUMBER_OF_COL - 2, 1);
	       
		}
		else {
			Label l = new Label();
			
			if(endGameStatut  == Constantes.WIN_DRACO) {
				l.setText("Victoire: Vous avez battu dracofeu et sauvé Papi.");
			}
			
			
			gridPane.setAlignment(Pos.CENTER);
			gridPane.add(l, 0, 0);
		}
		
        return gridPane;
	}
	/**
     * @brief Loads the text box with the specified line.
     * 
     * @param line The line of text to display.
     */
	public void loadTextBox(String line) {
		
		double rectangleWidth = Constantes.STAGE_WIDTH;
        double rectangleHeight = Constantes.STAGE_HEIGHT/5;
        
        ImageView textBox = new ImageView(new Image ("file:img/text.jpg"));
        textBox.setFitHeight(rectangleHeight);
        textBox.setFitWidth(rectangleWidth);
        textBox.setY(rectangleHeight * 4);
     
        Text text = new Text(line);
        text.setFont(Font.font("Arial", 20));
        text.setFill(Color.BLACK);
        text.setY(Constantes.STAGE_HEIGHT*4/5);
        
        text.setLayoutX((rectangleWidth - text.getBoundsInLocal().getWidth()) / 2);
        text.setLayoutY((rectangleHeight - text.getBoundsInLocal().getHeight()) / 2 + text.getBoundsInLocal().getHeight());
        
		Pane root = new Pane();
        root.getChildren().addAll(this.loadBiome(),textBox,text); // Ajouter le GridPane et le rectangle
        this.mapScene.setRoot(root);
	}
	/**
     * @brief Loads the inventory.
     * 
     * @return The grid pane representing the inventory.
     */
	public GridPane loadInventory() {
		
        GridPane gridPane = new GridPane();
        
        for (int i = 0; i < Constantes.NUMBER_OF_ROW; i++) {
             for (int j = 0; j < Constantes.NUMBER_OF_COL; j++) {
            	 
            	 Rectangle border = new Rectangle(Constantes.CASE_WIDTH, Constantes.CASE_HEIGHT);
                 border.setFill(null);
                 border.setStroke(Color.BLACK); 
                 border.setStrokeWidth(1); 
                 gridPane.add(border, j, i); 
                 
                 GridPane.setMargin(border, new javafx.geometry.Insets(-1));
                 
            	 if(i*Constantes.NUMBER_OF_COL + j < this.player.getInventory().size()) {
                    		
            		GridPane itemCard = new GridPane();
            		 
            		Item item = this.player.getInventoryElement(i*Constantes.NUMBER_OF_COL + j);
            		ImageView img = item.getSprite();
            		img.setFitHeight(Constantes.CASE_HEIGHT*0.5);
            		img.setFitWidth(Constantes.CASE_WIDTH*0.5);
            		
            		img.setOnMouseClicked(e -> {
            				
            				if(item.isUseableOutDuel()) {
            					System.out.println("Use " + item.getName());
            					this.player.useObject(item.getName());
            					
            					this.inventoryScene.setRoot(this.loadInventory());
            	       	        this.primaryStage.setScene(this.inventoryScene);
            				}
            				
            		});
            		 
            		itemCard.add(img, 0, 0);
            		 
            		Label name = new Label(item.getName());
            		itemCard.add(name, 0, 1);
                     
            		gridPane.add(itemCard, j, i);
            	 }
            }
         }
   
        return gridPane;
      
	}
	public void loadMarchanding(int x,int y) {
		double rectangleWidth = Constantes.STAGE_WIDTH;
        double rectangleHeight = Constantes.STAGE_HEIGHT/5;
        Merchant m = (Merchant) this.biome.getTile(x, y).getPnj();
        
        ImageView textBox = new ImageView(new Image ("file:img/text.jpg"));
        textBox.setFitHeight(rectangleHeight);
        textBox.setFitWidth(rectangleWidth);
        textBox.setY(rectangleHeight * 4);
     
        //Text
        Text text = new Text(m.getDialog()[0]);
        text.setFont(Font.font("Arial", 20));
        text.setFill(Color.BLACK);
        text.setY(Constantes.STAGE_HEIGHT*4/5);
        
        text.setLayoutX(30);
        text.setLayoutY(30);
        
        //Items
        ComboBox<String> comboBox = new ComboBox<>();
    	for(int i = 0; i < m.getInventory().size(); i++) {
    			 
    		comboBox.getItems().add(m.getInventoryElement(i).getName() + " - " + m.getPrices()[i]);
   	 	
    	}
    	comboBox.setLayoutX(40);
        comboBox.setLayoutY(Constantes.STAGE_HEIGHT*4/5 + 40);
        
        //Button
        Button buy = new Button("Acheter");
        buy.setOnAction(e -> {
        	
        	if(comboBox.getItems().size() > 0) {
        		int i = comboBox.getSelectionModel().getSelectedIndex();
            	Item item = m.getInventoryElement(i);
            	if(this.player.getCoins() >= m.getPrices()[i]) {
            		this.player.updateCoins(-m.getPrices()[i]);
            		this.player.getInventory().add(item);
            		m.getInventory().remove(i);
            		this.biome.getTile(x, y).setPnj(m);
            		
            		this.mapScene.setRoot(this.loadBiome());
            	}
        	}
        	
        });
        buy.setLayoutX(200);
        buy.setLayoutY(Constantes.STAGE_HEIGHT*4/5 + 40);
        
		Pane root = new Pane();
        root.getChildren().addAll(this.loadBiome(),textBox,text,comboBox,buy);
        this.mapScene.setRoot(root);
	}
	//Win
	/**
     * @brief Checks if the game has ended.
     * 
     * @return The end game status.
     */
	public int checkEndGame() {
		
		if(Constantes.BIOME_BOSS.getTile(5, 7).getPokemon() == null) {
			System.out.println("Vous avez gagné");
			return Constantes.WIN_DRACO;
		}
		
		return Constantes.NO_WIN;
	}
}
