package scenes;
import counter.DisplayNumbers;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import scenes.SceneManager;
import deck.Deck;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InbetweenScene {
    private SceneManager sceneManager;
    private Deck deck;
    private Stage stage;

    public InbetweenScene(SceneManager sceneManager, Deck deck) {
        this.sceneManager = sceneManager;
        this.deck = deck;
        this.stage = sceneManager.getStage();
    }

    public void runInbetweenScene() {
        Parent root = createInbetweenView();
        sceneManager.setRoot(root);
    }

    public Parent createInbetweenView() {
        stage.setTitle("Party Game");
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label title = new Label("Welcome to Party Game!");
        title.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");

        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 14; -fx-padding: 10;");

        startButton.setOnAction(e -> {
            System.out.println("Game Started!");
            RoundScene roundScene = new RoundScene(sceneManager, deck);
            roundScene.runRoundScene();
        });
        root.getChildren().addAll(title, startButton);
        return root;
    }    
}
