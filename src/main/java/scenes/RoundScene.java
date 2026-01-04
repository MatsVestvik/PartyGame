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
        Base baseCard = new Base(5, 3, 2, 4, 5);
        Base anotherBaseCard = new Base(2, 4, 1, 3, 5);

        Button randomizeButton = new Button("Randomize Cards");
        randomizeButton.setOnAction(e -> {
              baseCard.setCashBox(new Random().nextInt(10));
              baseCard.setTroubleBox(new Random().nextInt(10));
              baseCard.setCostBox(new Random().nextInt(10)); 
              baseCard.setHeartBox(new Random().nextInt(10));
        });
        cards.getChildren().addAll(baseCard.getCardPane(), anotherBaseCard.getCardPane());
        root.getChildren().addAll(cards, randomizeButton);
        Scene scene = new Scene(root, 400, 300);
        return scene;
    }    
}
