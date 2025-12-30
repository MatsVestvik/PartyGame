

import scenes.InbetweenScene;
import scenes.RoundScene;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        InbetweenScene inbetweenScene = new InbetweenScene(stage);
        inbetweenScene.runInbetweenScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}