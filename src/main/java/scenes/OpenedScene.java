package scenes;

import javafx.stage.Screen;
import cards.RandomCard;

import cards.Base;
import cards.RandomCard;
import cards.packs.Pack;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import deck.Deck;

import java.util.List;
import java.util.Random;
import java.util.Stack;

import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import scenes.SceneManager;
import util.LoadImage;
public class OpenedScene {
    private HBox cardDisplay;
    private ShopScene shopScene;
    private Deck deck;
    private SceneManager sceneManager;
    public OpenedScene(ShopScene shopScene, SceneManager sceneManager, Deck deck) {
        cardDisplay = getOpenedCards(5);
        this.shopScene = shopScene;
        this.sceneManager = sceneManager;
        this.deck = deck;
    }
    
    public HBox getOpenedCards(int num) {
        HBox openedCards = new HBox(10);
        for (int i = 0; i < num; i++) {
            Base card = RandomCard.getRandomCard(2); 
            openedCards.getChildren().add(card.getCardPane());
        }
        return openedCards;
    }
    
    public StackPane createOpenedRoot() {
        StackPane withBackground = new StackPane();
        ImageView background = new ImageView(LoadImage.load("backgrounds/openedBackground.png", 
            Screen.getPrimary().getBounds().getWidth(), 
            Screen.getPrimary().getBounds().getHeight(), 
            false, false));
        withBackground.getChildren().add(background);
        Button backToShop = new Button("Back to Shop");
        backToShop.setStyle("-fx-font-size: 14; -fx-padding: 10; -fx-min-width: 100;");
        backToShop.setOnAction(e -> {
            shopScene.refreshShopScene();
            System.out.println("Returning to Shop Scene");
        });
        VBox cardWrapper = new VBox(20);
        cardWrapper.getChildren().add(cardDisplay);
        cardWrapper.getChildren().add(backToShop);
        withBackground.getChildren().add(cardWrapper);
        
        StackPane.setAlignment(cardWrapper, Pos.CENTER);
        StackPane.setMargin(cardWrapper, new javafx.geometry.Insets(300,0,0, 300));
        StackPane.setAlignment(backToShop, Pos.BOTTOM_CENTER);
        StackPane.setMargin(backToShop, new javafx.geometry.Insets(0, 0, 20, 0));
        return withBackground;
    }

}