package scenes;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
public class InbetweenScene {
    public Scene createInbetweenScene(Stage stage) {
        stage.setTitle("Party Game");
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label title = new Label("Welcome to Party Game!");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        startButton.setOnAction(e -> {
            System.out.println("Game Started!");
            RoundScene roundScene = new RoundScene();
            Scene gameScene = roundScene.createRoundScene(stage);
            stage.setScene(gameScene);
        });
        root.getChildren().addAll(title, startButton);
        Scene scene = new Scene(root, 400, 300);
        return scene;
    }    
}
