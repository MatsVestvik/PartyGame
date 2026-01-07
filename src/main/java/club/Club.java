package club;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.LoadImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Club {
    private static GridPane clubGrid;
    
    public Club() {
    }
    
    public static GridPane getClubPane() {
        int scale = 10;
        int width = 6;
        int height = 3;
        clubGrid = new GridPane();
        clubGrid.setHgap(0);
        clubGrid.setVgap(0);

        // Add floor tiles with StackPanes so creatures can be placed on top
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                StackPane tile = new StackPane();
                ImageView floorTile = new ImageView(LoadImage.load("tiles/floor.png", 15*scale, 15*scale, true, false));
                tile.getChildren().add(floorTile);
                tile.setPrefWidth(15 * scale);
                tile.setPrefHeight(15 * scale);
                clubGrid.add(tile, col, row);
            }
        }

        return clubGrid;
    }
    
    public static StackPane getTile(int col, int row) {
        if (clubGrid == null) return null;
        return (StackPane) clubGrid.lookup(".stack-pane");
    }
    
    public static StackPane getEmptyTile() {
        if (clubGrid == null) return null;
        for (var child : clubGrid.getChildren()) {
            StackPane tile = (StackPane) child;
            // Check if tile only has the floor image (no creatures)
            if (tile.getChildren().size() == 1) {
                return tile;
            }
        }
        return null;
    }
    
    public static GridPane getClubGrid() {
        return clubGrid;
    }
    
}
