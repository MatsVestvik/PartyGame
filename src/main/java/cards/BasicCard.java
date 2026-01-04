package cards;
import java.util.Stack;

import javafx.scene.layout.StackPane;

public class BasicCard extends Base{

    public BasicCard(int cost, int cash, int trouble, int heart, int scale, int color, int rarity, String artName, String description) {
        super(cash, trouble, cost, heart, scale, color, rarity, artName, description);
    }    
    public void activateAbility() {
    }
}
