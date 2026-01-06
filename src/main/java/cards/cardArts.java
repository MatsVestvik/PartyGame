package cards;
import javafx.scene.image.ImageView;
import util.LoadImage;

import javafx.scene.image.Image;

public class cardArts {
    public static ImageView getCardArt(String name, int scale) {
        Image artImage = LoadImage.load("cardArt/" + name + ".png", 66* scale, 51* scale, true, false);
        //Image artImage = LoadImage.load("cardArt/" + name + ".png", 70 * scale, 37 * scale, true, false);
        return new ImageView(artImage);
    }
    
    public static String getRandCardArt(int scale) {
        String[] artNames = {"dog", "placeholder"};
        int randIndex = (int)(Math.random() * artNames.length);
        String randArtName = artNames[randIndex];
        return randArtName;
    }
    
}
