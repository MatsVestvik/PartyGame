package scenes;

import cards.Base;
import javafx.scene.layout.VBox;

import java.util.List;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class OpenedScene {
    private HBox cardDisplay;
    private Scene ShopScene;
    public OpenedScene(Scene ShopScene) {
        cardDisplay = new HBox();
        this.ShopScene = ShopScene;
        
    }
    public void showOpenedPackCards(List<Base> cards) {
        for (Base card : cards) {
            cardDisplay.getChildren().add(card.getCardPane());
        }
    }
    
    public List<Base> getOpenedCards(int num) {
        List<Base> openedCards = new java.util.ArrayList<>(); 
        for (int i = 0; i < num; i++) {
            Base card = new Base(5, 3, 2, 4, 2, 1, 2, "dog", "An opened card from a pack.");
            openedCards.add(card);
        }
        return openedCards;
    }
    
    public Scene createOpenedScene() {
        VBox root = new VBox();
        Button backToShop = new Button("Back to Shop");
        backToShop.setOnAction(e -> {
            Stage stage = (Stage) backToShop.getScene().getWindow();
            stage.setScene(ShopScene);
        });

        showOpenedPackCards(getOpenedCards(5));
        root.getChildren().add(cardDisplay);
        root.getChildren().add(backToShop);
        return new Scene(root);
    }

}