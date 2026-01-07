package cards.specificCard;
import java.util.Stack;

import cards.Creature;
import javafx.scene.layout.StackPane;

public class Norm extends Creature{

    public Norm(int scale) {
        super(1, 1, 1, 1, scale, 1, 1, 
            "club","This Creature has no special abilities.",
            "Norm");
    }    
    public void activateAbility() {
    }
}
