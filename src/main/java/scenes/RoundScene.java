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

import java.util.Stack;

import cards.Base;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import cards.Creature;

public class RoundScene {
    
    Deck deck;
    SceneManager sceneManager;
    StackPane cardsInHand;
    int cardsHeld;
    private static final int MAX_SPREAD = 100; // Maximum spacing between cards before they overlap
    
    public RoundScene(SceneManager sceneManager, Deck deck) {
        this.sceneManager = sceneManager;
        this.deck = deck;
        this.cardsHeld = 0;
        cardsInHand = new StackPane();
        cardsInHand.setPrefHeight(120);
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

        javafx.scene.layout.GridPane clubPane = Club.getClubPane();
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
        StackPane cardPane = card.getCardPane();
        
        // Add click handler for creature cards
        if (card instanceof Creature) {
            cardPane.setOnMouseClicked(e -> {
                if (e.getClickCount() == 2) { // Double click to play
                    playCreature((Creature) card);
                }
            });
        }
        
        cardsInHand.getChildren().add(cardPane);
        cardsHeld++;
        repositionCards();
    }
    
    private void repositionCards() {
        // Allow up to ~8 cards without overlap, then compress to keep total width stable
        int spacing = MAX_SPREAD;
        if (cardsHeld > 1) {
            int visibleSlotsWithoutOverlap = 8; // roughly how many cards before we start overlapping
            if (cardsHeld > visibleSlotsWithoutOverlap) {
                double allowedWidth = MAX_SPREAD * (visibleSlotsWithoutOverlap - 1); // keep hand within this width
                spacing = (int) Math.max(40, Math.floor(allowedWidth / (cardsHeld - 1)));
            }
        }
        
        // Reposition all cards
        for (int i = 0; i < cardsInHand.getChildren().size(); i++) {
            StackPane card = (StackPane) cardsInHand.getChildren().get(i);
            card.setTranslateX(i * spacing);
            StackPane.setAlignment(card, javafx.geometry.Pos.BOTTOM_LEFT);
        }
    }
    
    private void playCreature(Creature creature) {
        StackPane emptyTile = Club.getEmptyTile();
        
        if (emptyTile == null) {
            System.out.println("No empty tiles available!");
            return;
        }
        
        // Get character art and place it on the tile
        ImageView characterArt = creature.getCharacterArtView();
        if (characterArt != null) {
            ImageView creatureDisplay = new ImageView(characterArt.getImage());
            creatureDisplay.setFitWidth(140);
            creatureDisplay.setFitHeight(140);
            creatureDisplay.setPreserveRatio(true);
            
            emptyTile.getChildren().add(creatureDisplay);
            
            // Remove from hand
            cardsInHand.getChildren().remove(creature.getCardPane());
            cardsHeld--;
            repositionCards();
            
            System.out.println("Creature placed on club! Cards in hand: " + cardsHeld);
        }
    }
}

