package cards.packs;

import java.util.Random;
import cards.Base;
import cards.cardArts;
import util.LoadImage;
import scenes.ShopScene;
import scenes.SceneManager;

import javafx.scene.Cursor;
import scenes.OpenedScene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
public class Pack{
    ImageView packArt;
    int scale;
    public Pack(String name, int scale) {
        packArt = getPackArt(name, scale);
        this.scale = scale; 
    }
    public ImageView getPackArt(String name, int scale) {
        Image artImage = LoadImage.load("packs/" + name + ".png", 90* scale, 120* scale, true, false);
        return new ImageView(artImage);
    }
    public static Base getRandomShopCard() {
        Random rand = new Random();
        Base card = new Base(rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), rand.nextInt(10), 2, rand.nextInt(5)+1, rand.nextInt(5)+1, cardArts.getRandCardArt(2), "A randomly generated shop card.") ;
        return card;
    }
    public StackPane getPackPane(ShopScene shopScene, SceneManager sceneManager) {
        StackPane packPane = new StackPane();
        Button packButton = new Button();
        packButton.setStyle("-fx-background-color: transparent;");
        packButton.setPrefSize(90*scale, 120*scale);
        packPane.getChildren().add(packArt);
        packPane.getChildren().add(packButton);
        packButton.setOnMouseEntered(e -> {
            packButton.setCursor(Cursor.HAND);
            packArt.setScaleX(1.1);
            packArt.setScaleY(1.1);
        });
        packButton.setOnMouseExited(e -> {
            packArt.setScaleX(1.0);
            packArt.setScaleY(1.0);
        });
        packButton.setOnAction(e -> {
            OpenedScene openedScene = new OpenedScene(shopScene, sceneManager, shopScene.getDeck());
            sceneManager.setRoot(openedScene.createOpenedRoot());
        });

        return packPane;
    }
}