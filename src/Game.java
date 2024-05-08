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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
	//Variable
	private Scene mapScene;
	private Scene inventoryScene;
	private Scene duelScene;
	private Biome biome;
	private Player player;
	private Stage primaryStage;
	
	//Cons
	public Game(Stage primaryStage) {
		super();
		
		this.player = new Player();
		this.biome = Constantes.BIOME_VILLAGE;
		this.primaryStage = primaryStage;
		
		this.player.setPosX(4);
		this.player.setPosY(8);
		
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
        
         
        this.primaryStage.setTitle("GAME");
        this.primaryStage.setScene(this.mapScene);
        this.primaryStage.show();
	}
		
	//GetSet
	public int getMinRowView() {
		return (int) Math.ceil(Constantes.NUMBER_OF_ROW / 2);
	}
	public int getMaxRowView() {
		return this.biome.getWidth() - this.getMinRowView() - 1;
	}
	public int getMinColView() {
		return (int) Math.ceil(Constantes.NUMBER_OF_COL / 2);
	}
	public int getMaxColView() {
		return this.biome.getHeight() - this.getMinRowView() - 1;
	}

	//Methode
	public void playerMove() {
		if(this.biome.getTile(this.player.getPosX(), this.player.getPosY()).isTpTile()) {
			
			int x = this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getSpawnX();
			int y = this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getSpawnY();
			
			switch(this.biome.getTile(this.player.getPosX(), this.player.getPosY()).getIdTpBiome()) {
			 case 0:
				 this.biome = Constantes.BIOME_VILLAGE;
				 break;
			 case 1:
				 this.biome = Constantes.BOSS_VILLAGE;
				 break;
			default:
				break;
			}
			
			this.player.setPosX(x);
			this.player.setPosY(y);
			this.player.setDirection(Constantes.DIRECTION_SOUTH);
		}
		
		
	}
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
				
				;
				
		    	this.loadTextBox(this.biome.getTile(x, y).getPnj().getDialog()[0]);
		    	
		    	if(!this.biome.getTile(x, y).getPnj().getInventory().isEmpty()) {
		    		System.out.println("donne " + this.biome.getTile(x, y).getPnj().getInventoryElement(0).getName());
		    		this.player.getInventory().add(this.biome.getTile(x, y).getPnj().getInventoryElement(0).deepCopy());
		    		this.biome.getTile(x, y).getPnj().getInventory().remove(0);
		    	}
		    	
		       
		       
			}
			else if(this.biome.getTile(x, y).getPokemon() != null) {
				System.out.println("Debut du combat");		
				Duel duel = new Duel(this.primaryStage, this.player, this.biome.getTile(x, y).getPokemon());
				duel.setCloseChangeListener(isClose -> {
		            if (isClose) {
		                System.out.println("Fin du combat");
		                
		                this.mapScene.setRoot(this.loadBiome());
		                this.primaryStage.setScene(this.mapScene);
		                
		                if(duel.isPlayerWin()) {
							
							if(duel.getPokemon().getReward() != null) {
								
								this.loadTextBox(this.player.getName() + " obtient " + duel.getPokemon().getReward().getName());
								this.player.getInventory().add(duel.getPokemon().getReward());
								this.loadTextBox(this.player.getName() + " recoit " + duel.getPokemon().getReward().getName());
							}
							
						}
		           
		            }
		        });
				
				this.biome.getTile(x, y).setPokemon(null);
			}
		}
	}
	//Load
	public GridPane loadBiome() {
		
		GridPane gridPane = new GridPane();
		
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

        return gridPane;
	}
	public void loadTextBox(String line) {
		
		double rectangleWidth = Constantes.STAGE_WIDTH;
        double rectangleHeight = Constantes.STAGE_HEIGHT/5;
        
        ImageView textBox = new ImageView(new Image ("./text.jpg"));
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
	public GridPane loadInventory() {
		
        GridPane gridPane = new GridPane();
        
        for (int i = 0; i < Constantes.NUMBER_OF_ROW; i++) {
             for (int j = 0; j < Constantes.NUMBER_OF_COL; j++) {
            	 
            	 Rectangle border = new Rectangle(Constantes.CASE_HEIGHT, Constantes.CASE_WIDTH);
                 border.setFill(null);
                 border.setStroke(Color.BLACK); 
                 border.setStrokeWidth(1); 
                 gridPane.add(border, j, i); 
                 
                 GridPane.setMargin(border, new javafx.geometry.Insets(-1));
                 
            	 if(i*Constantes.NUMBER_OF_COL + j < this.player.getInventory().size()) {
                    		
            		 Item item = this.player.getInventoryElement(i*Constantes.NUMBER_OF_COL + j);
            		 ImageView img = item.getSprite();
            		 
            	
            		 
            		 gridPane.add(img, j, i);
            	 }
            }
         }
        	
        return gridPane;
      
	}	
}
