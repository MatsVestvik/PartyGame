package scenes;

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
        numberDisplay.setNumber(17);
        root.getChildren().addAll(roundLabel, numberDisplay.getNumberBox(), increaseNumberButton, decreaseNumberButton);

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
