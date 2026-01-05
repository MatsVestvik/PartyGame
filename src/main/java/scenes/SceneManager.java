package scenes;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Shared scene manager to avoid flicker by reusing a single Scene. */
public class SceneManager {
    private final Stage stage;
    private final Scene scene;

    public SceneManager(Stage stage) {
        this.stage = stage;
        this.scene = new Scene(new StackPane(), 800, 600);
        
        // Load stylesheet
        String css = getClass().getResource("/cards/cardStyle.css/BaseStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.setFullScreen(true);
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setRoot(Parent newRoot) {
        scene.setRoot(newRoot);
    }

    public void fadeTo(Parent newRoot, double millis) {
        Parent oldRoot = scene.getRoot();
        if (oldRoot == null) {
            setRoot(newRoot);
            return;
        }
        FadeTransition out = new FadeTransition(Duration.millis(millis), oldRoot);
        out.setFromValue(1.0);
        out.setToValue(0.0);
        out.setOnFinished(e -> {
            scene.setRoot(newRoot);
            FadeTransition in = new FadeTransition(Duration.millis(millis), newRoot);
            in.setFromValue(0.0);
            in.setToValue(1.0);
            in.play();
        });
        out.play();
    }
}
