package symbolsview;

import util.LoadImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Symbols {
    public static ImageView getSymbol(String symbolName, int width, int height) {
        Image symbolImage = LoadImage.load("symbols/" + symbolName + ".png", width, height, true, false);
        ImageView symbolImageView = new ImageView(symbolImage);
        return symbolImageView;
    }
}