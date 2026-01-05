package scenes;

import cards.Base;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import deck.Deck;
import scenes.SceneManager;
import scenes.ShopScene;

public class RoundScene {
    private SceneManager sceneManager;
    private Deck deck;

    public RoundScene(SceneManager sceneManager, Deck deck) {
        this.sceneManager = sceneManager;
        this.deck = deck;
    }
    public void runRoundScene() {
        sceneManager.setRoot(createRoundRoot());
    }
    public VBox createRoundRoot() {
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
            ShopScene shopScene = new ShopScene(sceneManager, deck);
        });
        
        root.getChildren().addAll(deckLabel, deckDisplay, shopButton);
        return root;
    }    
}
