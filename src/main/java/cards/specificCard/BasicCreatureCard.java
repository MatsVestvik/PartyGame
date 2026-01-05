package cards.specificCard;
import java.util.Stack;

import cards.Base;
import javafx.scene.layout.StackPane;

public class BasicCreatureCard extends Base{

    public BasicCreatureCard(int scale) {
        super(1, 1, 1, 1, scale, 1, 1, 
            "BasicCreature","This Creature has no special abilities.");
    }    
    public void activateAbility() {
    }
}
