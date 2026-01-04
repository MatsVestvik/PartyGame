package cards;

import java.util.Stack;

import javafx.scene.layout.StackPane;

public class BasicCard extends Base{

    public BasicCard(int cost, int cash, int trouble, int heart, int scale, int color, int rarity) {
        super(cash, trouble, cost, heart, scale, color, rarity);
    }    
    public void activateAbility() {
    }
}
