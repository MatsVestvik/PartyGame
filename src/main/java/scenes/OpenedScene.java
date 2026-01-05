package scenes;

import cards.Base;
import cards.packs.Pack;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import deck.Deck;

import java.util.List;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.geometry.Pos;
import scenes.SceneManager;
public class OpenedScene {
    private HBox cardDisplay;
    private ShopScene shopScene;
    private Deck deck;
    private SceneManager sceneManager;
    public OpenedScene(ShopScene shopScene, SceneManager sceneManager, Deck deck) {
        cardDisplay = new HBox(10);
        this.shopScene = shopScene;
        this.sceneManager = sceneManager;
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
            Base card = Pack.getRandomShopCard(); 
            openedCards.add(card);
        }
        return openedCards;
    }
    
    public VBox createOpenedRoot() {
        StackPane cardWrapper = new StackPane();
        VBox root = new VBox(10);
        VBox cardContainer = new VBox();
        cardWrapper.getChildren().add(cardDisplay);
        StackPane.setAlignment(cardContainer,Pos.CENTER);
        Button backToShop = new Button("Back to Shop");
        backToShop.setStyle("-fx-font-size: 14; -fx-padding: 10; -fx-min-width: 100;");
        backToShop.setOnAction(e -> {
            shopScene.refreshShopScene();
            System.out.println("Returning to Shop Scene");
        });

        showOpenedPackCards(getOpenedCards(5));
        cardContainer.getChildren().add(cardWrapper);
        
        root.getChildren().add(cardContainer);
        root.getChildren().add(backToShop);
        VBox.setVgrow(cardContainer, Priority.ALWAYS);
        return root;
    }

}