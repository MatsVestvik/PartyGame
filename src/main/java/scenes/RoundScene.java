package scenes;

import javafx.geometry.Insets;
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
        stage.setScene(scene);
    }
    public Scene createRoundScene() {
        stage.setTitle("Round Scene");
        // Implement the round scene UI here
        // For demonstration, we'll just create a simple scene
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label roundLabel = new Label("This is the Round Scene!");
        roundLabel.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        root.getChildren().add(roundLabel);
        Scene scene = new Scene(root, 400, 300);
        return scene;
    }    
}
