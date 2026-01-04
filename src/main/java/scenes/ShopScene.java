package scenes;

import java.util.Random;
import javafx.stage.Stage;

import cards.Base;
import cards.cardArts;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class ShopScene {
    private HBox cardDisplay;
    private Stage stage;
    private Scene scene;
    public ShopScene(Stage stage) {
        this.stage = stage;
        cardDisplay = new HBox();
        createRandomShopCards();
        scene = new Scene(cardDisplay);
        stage.setScene(scene);
    }    
    public HBox getCardDisplay() {
        return cardDisplay;
    }
    public void createRandomShopCards() {
        for (int i = 0; i < 5; i++) {
            Base card = getRandomShopCard(); 
            cardDisplay.getChildren().add(card.getCardPane());
        }
    }
    public Base getRandomShopCard() {
        Random rand = new Random();
        Base card = new Base(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), 2, rand.nextInt(5)+1, rand.nextInt(5)+1, cardArts.getRandCardArt(2), "A randomly generated shop card.") ;
        return card;
    }
}
