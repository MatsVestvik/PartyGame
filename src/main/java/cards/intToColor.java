package cards;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import util.LoadImage;

public class intToColor {
    public static String convert(int color) {
        switch (color) {
            case 0:
                return "red";
            case 1:
                return "blue";
            case 2:
                return "green";
            case 3:
                return "white";
            case 4:
                return "red"; 
            case 5:
                return "rainbow";
            default:
                return "unknown";
        }
    }

    public static ImageView getColorImageView(int color, int scale) {
        String colorString = convert(color);
        Image colorImage = LoadImage.load("card/" + colorString + "Card.png", 80* scale, 107* scale, true, false);
        return new ImageView(colorImage);
    }
    
}
