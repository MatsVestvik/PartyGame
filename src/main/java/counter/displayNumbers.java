package counter;

import javafx.scene.layout.HBox;
import util.LoadImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class displayNumbers {
   public static HBox displayInt(int number) {
        HBox hbox = new HBox();
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            char digitChar = String.valueOf(number).charAt(i);
            int digit = Character.getNumericValue(digitChar);
            Image digitImage = LoadImage.load("file:src/main/resources/images/numbers/" + digit + ".png");
            ImageView digitImageView = new ImageView(digitImage);
            digitImageView.setFitWidth(500);
            digitImageView.setPreserveRatio(true);
            digitImageView.setSmooth(false);
            hbox.getChildren().add(digitImageView);
        }
        return hbox;
   } 
}
