package cards;

import java.util.Stack;

import javafx.scene.layout.StackPane;

public class BasicCard {
    StackPane cardPane;
    int cash;
    int trouble;
    int cost;

    public BasicCard(int cash, int trouble, int cost) {
        cardPane = new StackPane();
        this.cash = cash;
        this.trouble = trouble;
        this.cost = cost;        
    }    
}
