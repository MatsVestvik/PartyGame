package scenes;

import club.Club;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import util.LoadImage;
import deck.Deck;
import scenes.SceneManager;
import cards.Base;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class RoundScene {
    
    Deck deck;
    SceneManager sceneManager;
    StackPane cardsInHand;
    int cardsHeld;
    public RoundScene(SceneManager sceneManager, Deck deck) {
        this.sceneManager = sceneManager;
        this.deck = deck;
        this.cardsHeld = 0;
        cardsInHand = new StackPane();
    }

    public void runRoundScene() {
        sceneManager.fadeTo(createRoundRoot(),0);        
    }
    
    public StackPane createRoundRoot() {

        
        StackPane deckView = deck.getDeckPane(this::addCardToHand);
        Button next = new Button("Next");
        next.setOnAction(e -> {
            deck.returnDrawnCards();
            ShopScene shopScene = new ShopScene(sceneManager, deck);
        });
        VBox container = new VBox(10);
        container.getChildren().addAll(deckView, next);
        VBox.setMargin(deckView, new javafx.geometry.Insets(50, 0, 0, 50));

        VBox clubPane = Club.getClubPane();
        VBox rightBox = new VBox();
        rightBox.getChildren().add(clubPane);
        rightBox.getChildren().add(cardsInHand);
        HBox horizontal = new HBox();
        horizontal.getChildren().addAll(container, rightBox);
        HBox.setMargin(rightBox, new javafx.geometry.Insets(50, 0, 0, 200));
        container.setMaxWidth(100);
        container.setMinWidth(100);
        StackPane withBackground = new StackPane(); 
        ImageView background = new ImageView(LoadImage.load("backgrounds/rainbowBackground.png", 
            Screen.getPrimary().getBounds().getWidth(), 
            Screen.getPrimary().getBounds().getHeight(), 
            false, false));
         
        withBackground.getChildren().addAll(background, horizontal);
        
        return withBackground;
    }

    private void addCardToHand(Base card) {
        card.showFace();
        cardsInHand.getChildren().add(card.getCardPane());
        StackPane.setMargin(card.getCardPane(), new javafx.geometry.Insets(0, 0, 0, 50*cardsHeld));
        cardsHeld++;
    }
}
