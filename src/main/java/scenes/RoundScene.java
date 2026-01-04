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

public class RoundScene {
    private Stage stage;

    public RoundScene(Stage stage) {
        this.stage = stage;
    }
    public void runRoundScene() {
        Scene scene = createRoundScene();
        stage.setFullScreen(true);
        stage.setScene(scene);
    }
    public Scene createRoundScene() {
        VBox root = new VBox(10);
        HBox cards = new HBox();
        int scale = 2;
        Base baseCard = new Base(5, 3, 2, 4, scale, 1, 1, "dog");
        Base anotherBaseCard = new Base(2, 4, 1, 3, scale, 2, 2, "placeholder");
        Base thirdBaseCard = new Base(3, 2, 5, 1, scale, 1, 1, "dog");
        Base fourthBaseCard = new Base(4, 5, 3, 2, scale, 1, 2, "placeholder");
        Base fifthBaseCard = new Base(1, 1, 1, 1, scale, 3, 3, "dog");
        Base sixthBaseCard = new Base(6, 6, 6, 6, scale, 4, 4, "placeholder");
        Base seventhBaseCard = new Base(0, 0, 0, 0, scale, 5, 5, "dog");
        Button randomizeButton = new Button("Randomize Cards");
        randomizeButton.setOnAction(e -> {
            randomizeCard(baseCard);
            randomizeCard(anotherBaseCard);
            randomizeCard(thirdBaseCard);
            randomizeCard(fourthBaseCard);
            randomizeCard(fifthBaseCard);
            randomizeCard(sixthBaseCard);
            randomizeCard(seventhBaseCard);
        });
        cards.getChildren().addAll(baseCard.getCardPane(), anotherBaseCard.getCardPane(), thirdBaseCard.getCardPane(), fourthBaseCard.getCardPane(), fifthBaseCard.getCardPane(), sixthBaseCard.getCardPane(), seventhBaseCard.getCardPane());
        root.getChildren().addAll(cards, randomizeButton);
        Scene scene = new Scene(root, 400, 300);
        return scene;
    }    
    
    public static void randomizeCard(Base card) {
        Random rand = new Random();
        card.updateCash(rand.nextInt(10));
        card.updateTrouble(rand.nextInt(10));
        card.updateCost(rand.nextInt(10)); 
        card.updateHeart(rand.nextInt(10));
        card.setCardImageView(rand.nextInt(5) + 1);
        card.setRarityImageView(rand.nextInt(5) + 1);   
    }
}
