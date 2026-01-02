package cards;

import javafx.scene.layout.StackPane;

public class Base {
    StackPane cardPane;
    int cash;
    int trouble;
    int cost;

    public Base(int cash, int trouble, int cost) {
        this.cash = cash;
        this.trouble = trouble;
        this.cost = cost;
    }
}
