package cards;

import java.util.Base;
import java.util.Stack;

import javafx.scene.layout.StackPane;

public class BasicCard extends Base{

    public BasicCard(int cost, int cash, int trouble) {
        super(cash, trouble, cost);
    }    
    public void activateAbility() {
        // To be overridden by subclasses
    }
}
