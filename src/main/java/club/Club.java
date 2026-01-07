package club;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.LoadImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Club {
    public Club() {
    }
    
    public static VBox getClubPane() {

        int scale = 10;
        int width = 6;
        VBox clubPane = new VBox();

        HBox wallRow = new HBox();
        for (int i = 0; i< width; i++) {

            ImageView wallTile = new ImageView(LoadImage.load("tiles/wall.png", 15*scale, 15*scale, true, false));
            wallRow.getChildren().add(wallTile);
        }
        
        clubPane.getChildren().add(wallRow);
        for (int i = 0; i < 3; i++) {

            HBox row = new HBox();

            for (int j = 0; j < width; j++) {
                ImageView floorTile = new ImageView(LoadImage.load("tiles/floor.png", 15*scale, 15*scale, true, false));
                row.getChildren().add(floorTile);
            }
            clubPane.getChildren().add(row);
        }

        return clubPane;
    }
    
}
