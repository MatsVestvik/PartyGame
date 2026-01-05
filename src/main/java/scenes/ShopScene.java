package scenes;

import cards.packs.Pack;
import java.util.Random;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import deck.Deck;

import cards.Base;
import cards.cardArts;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class ShopScene {
    private HBox cardDisplay;
    private Stage stage;
    private Scene scene;
    private Deck deck;
    public ShopScene(Stage stage, Deck deck) {
        this.stage = stage;
        this.deck = deck;
        cardDisplay = new HBox();
        createRandomShopCards();
        scene = createShopScene();
        stage.setScene(scene);
        stage.setFullScreen(true);
    }    
    public HBox getCardDisplay() {
        return cardDisplay;
    }
    public void createRandomShopCards() {
        for (int i = 0; i < 5; i++) {
            Base card = getRandomShopCard(); 
            card.getCardPane().setOnMouseClicked(e -> {
                deck.addCard(card);
                cardDisplay.getChildren().remove(card.getCardPane());
            });
            cardDisplay.getChildren().add(card.getCardPane());
        }
    }
    public Base getRandomShopCard() {
        Random rand = new Random();
        Base card = new Base(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), 2, rand.nextInt(5)+1, rand.nextInt(5)+1, cardArts.getRandCardArt(2), "A randomly generated shop card.") ;
        return card;
    }
    public HBox getPackDisplay(){
        HBox packDisplay = new HBox();
        for (int i = 0; i < 3; i++) {
            Pack pack = new Pack("bluePack", 2);
            packDisplay.getChildren().add(pack.getPackPane(this, stage));
        }
        return packDisplay;
    }
    public void refreshShopScene() {
        stage.setScene(scene);
        stage.setFullScreen(true);
    }
    
    public Deck getDeck() {
        return deck;
    }
    public Scene createShopScene(){
        VBox root = new VBox();
        Button nextBattle = new Button("Next Battle");
        HBox packDisplay = getPackDisplay();
        nextBattle.setOnAction(e -> {
            RoundScene roundScene = new RoundScene(stage, deck);
            roundScene.runRoundScene();
        });
        root.getChildren().addAll(cardDisplay, packDisplay, nextBattle);
        return new Scene(root);
    }
}
