package cards;

import javafx.scene.image.ImageView;
import util.LoadImage;

public class intToCharacterArt {
   public static ImageView convert(String artName, int scale) {
       return new ImageView(LoadImage.load("characterArt/" + artName + ".png", 66 * scale, 51* scale, true, false));
   } 
   public static String getRandCharacterArt(int scale) {
       String[] artNames = {"dog", "norm", "sunglasses", "axe", "delinquent"};
       int randIndex = (int)(Math.random() * artNames.length);
       String randArtName = artNames[randIndex];
       return randArtName;
   }
}
