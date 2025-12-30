

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Party Game");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label title = new Label("Welcome to Party Game!");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 14; -fx-padding: 10;");
        startButton.setOnAction(e -> System.out.println("Game started!"));

        root.getChildren().addAll(title, startButton);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}