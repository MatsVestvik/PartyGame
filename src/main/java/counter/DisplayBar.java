package counter;

import javafx.scene.layout.HBox;
import util.LoadImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayBar {

    private HBox numberBox;
    private int number;
    private int scale;
    public DisplayBar(int scale) {
        numberBox = new HBox();
        number = 0;
        this.scale = scale;
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
        int scale = this.scale;
        if (number < 0) {
            number = 0;
        }
        else if (number > 9) {
            number = 9;
        }
        Image digitImage = LoadImage.load("10bar/pixil-frame-" + number + ".png", 46*scale, 7*scale, true, false);
        ImageView digitImageView = new ImageView(digitImage);
        numberBox.getChildren().add(digitImageView);
    }

    public void increaseNumber(int increment) {
        setNumber(number + increment);
    }
} 
