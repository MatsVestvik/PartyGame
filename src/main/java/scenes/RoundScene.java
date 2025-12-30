package scenes;

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
        return new Scene(null); // Placeholder
    }    
}
