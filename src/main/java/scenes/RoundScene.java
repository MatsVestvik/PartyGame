package scenes;

import java.util.Random;
import cards.Base;
import javafx.scene.layout.HBox;
import symbolsview.Symbols;
import util.LoadImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import counter.DisplayNumbers;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import deck.Deck;

public class RoundScene {
    private Stage stage;
    private Deck deck;

    public RoundScene(Stage stage, Deck deck) {
        this.stage = stage;
        this.deck = deck;
    }
    public void runRoundScene() {
        Scene scene = createRoundScene();
        stage.setScene(scene);
        stage.setFullScreen(true);
    }
    public Scene createRoundScene() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        
        Label deckLabel = new Label("Your Deck (" + deck.size() + " cards):");
        deckLabel.setStyle("-fx-font-size: 16; -fx-font-weight: bold;");
        
        HBox deckDisplay = new HBox(10);
        for (Base card : deck.getCards()) {
            deckDisplay.getChildren().add(card.getCardPane());
        }
        
        Button shopButton = new Button("Go to Shop");
        shopButton.setOnAction(e -> { 
            ShopScene shopScene = new ShopScene(stage, deck);
        });
        
        root.getChildren().addAll(deckLabel, deckDisplay, shopButton);
        Scene scene = new Scene(root, 800, 600);
        return scene;
    }    
}
