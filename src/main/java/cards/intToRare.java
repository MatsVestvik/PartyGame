package cards;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.LoadImage;

public class intToRare {
    
    public static String convert(int rare) {
        switch (rare) {
            case 0:
                return "";
            case 1:
                return "NORM";
            case 2:
                return "GOLD";
            case 3:
                return "legendary";
            default:
                return "unknown";
        }
    }
    
    public static ImageView getRareImage(int rare, int scale) {
        String rareString = convert(rare);
        Image rareImage = LoadImage.load("tag/" + rareString + ".png",34*scale,9*scale, true, false);
        return new ImageView(rareImage);
    }
}

