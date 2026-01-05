package scenes;

import cards.Base;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import deck.Deck;

import java.util.List;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class OpenedScene {
    private HBox cardDisplay;
    private ShopScene shopScene;
    private Stage stage;
    private Deck deck;
    public OpenedScene(ShopScene shopScene, Stage stage, Deck deck) {
        cardDisplay = new HBox();
        this.shopScene = shopScene;
        this.stage = stage;
        this.deck = deck;
    }
    public void showOpenedPackCards(List<Base> cards) {
        for (Base card : cards) {
            card.getCardPane().setOnMouseClicked(e -> {
                deck.addCard(card);
                cardDisplay.getChildren().remove(card.getCardPane());
            });
            cardDisplay.getChildren().add(card.getCardPane());
        }
    }
    
    public List<Base> getOpenedCards(int num) {
        List<Base> openedCards = new java.util.ArrayList<>(); 
        for (int i = 0; i < num; i++) {
            Base card = new Base(5, 3, 2, 4, 2, 1, 2, "dog", "An opened card from a pack.");
            openedCards.add(card);
        }
        return openedCards;
    }
    
    public Scene createOpenedScene() {
        VBox root = new VBox(10);
        VBox cardContainer = new VBox();
        Button backToShop = new Button("Back to Shop");
        backToShop.setStyle("-fx-font-size: 14; -fx-padding: 10; -fx-min-width: 100;");
        backToShop.setOnAction(e -> {
            shopScene.refreshShopScene();
            System.out.println("Returning to Shop Scene");
        });

        showOpenedPackCards(getOpenedCards(5));
        cardContainer.getChildren().add(cardDisplay);
        
        root.getChildren().add(cardContainer);
        root.getChildren().add(backToShop);
        VBox.setVgrow(cardContainer, Priority.ALWAYS);
        
        return new Scene(root, 800, 600);
    }

}