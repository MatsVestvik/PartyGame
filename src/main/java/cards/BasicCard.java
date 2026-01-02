package cards;

import java.util.Stack;

import javafx.scene.layout.StackPane;

public class BasicCard extends Base{

    public BasicCard(int cost, int cash, int trouble, int heart, int scale) {
        super(cash, trouble, cost, heart, scale);
    }    
    public void activateAbility() {
    }
}
