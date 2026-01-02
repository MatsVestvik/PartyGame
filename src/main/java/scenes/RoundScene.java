package scenes;

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
        stage.setTitle("Round Scene");
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        Button increaseNumberButton = new Button("Increase Number");
        Button decreaseNumberButton = new Button("Decrease Number");

        Label roundLabel = new Label("This is the Round Scene!");
        roundLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        DisplayNumbers numberDisplay = new DisplayNumbers();
        numberDisplay.setNumber(0);

        ImageView coinView = Symbols.getSymbol("coin", 50, 50);
        ImageView heartView = Symbols.getSymbol("heart", 50, 50);
        ImageView cashView = Symbols.getSymbol("cash", 50, 50);
        ImageView troubleView = Symbols.getSymbol("trouble", 50, 50);
        HBox symbolsBox = new HBox(10, coinView, heartView, cashView, troubleView);
        root.getChildren().addAll(roundLabel, numberDisplay.getNumberBox(), increaseNumberButton, decreaseNumberButton, symbolsBox);

        increaseNumberButton.setOnAction(e -> {
            numberDisplay.increaseNumber(1);
        });

        decreaseNumberButton.setOnAction(e -> {
            numberDisplay.increaseNumber(-1);
        });

        Scene scene = new Scene(root, 400, 300);
        return scene;
    }    
}
