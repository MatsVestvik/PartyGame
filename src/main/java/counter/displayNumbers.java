package counter;

import javafx.scene.layout.HBox;
import util.LoadImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayNumbers {
    private HBox numberBox;
    private int number;
    public DisplayNumbers() {
        numberBox = new HBox();
        number = 0;
    }   

    public HBox getNumberBox() {
        return numberBox;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        numberBox.getChildren().clear();
        int scale = 20;
        if (number < 0) {
            Image minusImage = LoadImage.load("numbers/pixil-frame--.png",8*scale, 12*scale, false, false);
            ImageView minusImageView = new ImageView(minusImage);
            numberBox.getChildren().add(minusImageView);
        }
        for (int i = 0; i < String.valueOf(number).length(); i++) {
            char digitChar = String.valueOf(number).charAt(i);
            int digit = Character.getNumericValue(digitChar);
            Image digitImage = LoadImage.load("numbers/pixil-frame-" + digit + ".png",8*scale, 12*scale, false, false);
            ImageView digitImageView = new ImageView(digitImage);
        
            numberBox.getChildren().add(digitImageView);
        }
    }

    public void increaseNumber(int increment) {
        setNumber(number + increment);
    }
}
