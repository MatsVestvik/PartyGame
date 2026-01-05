

import scenes.InbetweenScene;
import scenes.SceneManager;
import deck.Deck;

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
        SceneManager sceneManager = new SceneManager(stage);
        Deck deck = new Deck();
        InbetweenScene inbetweenScene = new InbetweenScene(sceneManager, deck);
        inbetweenScene.runInbetweenScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}