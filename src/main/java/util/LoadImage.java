package util;
import javafx.scene.image.Image;

public class LoadImage {
    
    public static Image load(String path) {
        try {
            Image img = new Image(path);
            return img;
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println("Failed to load image at path: " + path);
            }
            
            return null;
        }
    }
}
