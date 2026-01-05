package scenes;

import cards.packs.Pack;
import cards.specificCard.BasicCreatureCard;

import java.util.Random;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import deck.Deck;
import scenes.SceneManager;

import cards.Base;
import cards.RandomCard;
import cards.cardArts;
import javafx.scene.layout.HBox;

public class ShopScene {
    private HBox cardDisplay;
    private SceneManager sceneManager;
    private Deck deck;
    private VBox root;
    public ShopScene(SceneManager sceneManager, Deck deck) {
        this.sceneManager = sceneManager;
        this.deck = deck;
        cardDisplay = new HBox(20);
        createRandomShopCards();
        root = createShopRoot();
        sceneManager.setRoot(root);
    }    
    public HBox getCardDisplay() {
        return cardDisplay;
    }
    public void createRandomShopCards() {
        for (int i = 0; i < 5; i++) {
            Base card = RandomCard.getRandomCard(2);
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
        HBox packDisplay = new HBox(20);
        for (int i = 0; i < 2; i++) {
            Pack pack = new Pack("bluePack", 2);
            Pack redPack = new Pack("redPack", 2);
            packDisplay.getChildren().add(pack.getPackPane(this, sceneManager));
            packDisplay.getChildren().add(redPack.getPackPane(this, sceneManager));
        }
        return packDisplay;
    }
    public void refreshShopScene() {
        sceneManager.setRoot(root);
    }
    
    public Deck getDeck() {
        return deck;
    }
    public VBox createShopRoot(){
        VBox rootLayout = new VBox(20);
        Button nextBattle = new Button("Next Battle");
        HBox packDisplay = getPackDisplay();
        nextBattle.setOnAction(e -> {
            RoundScene roundScene = new RoundScene(sceneManager, deck);
            roundScene.runRoundScene();
        });
        rootLayout.getChildren().addAll(cardDisplay, packDisplay, nextBattle);
        return rootLayout;
    }
}
