package cards;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;

import java.util.Stack;
import javafx.scene.image.Image;
import counter.DisplayNumbers;

import javafx.scene.layout.HBox;
import counter.DisplayNumbers;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import util.LoadImage;

public class Base {
    StackPane cardPane;
    ImageView intTrouble;
    ImageView intCash;
    ImageView intCost;
    int cash;
    int trouble;
    int cost;

    public Base(int cash, int trouble, int cost) {
        this.cash = cash;
        this.trouble = trouble;
        this.cost = cost;
        createCardVisuals(5);
    }
    public StackPane getCardPane() {
        return cardPane;
    }
    public ImageView getIntTrouble() {
        return intTrouble;
    }
    public ImageView getIntCash() {
        return intCash;
    }
    public ImageView getIntCost() {
        return intCost;
    }

    public HBox createStatBox(int scale, String symbolName, int value) {
        HBox statBox = new HBox(2);
        ImageView symbolImageView = new ImageView(LoadImage.load("symbols/" + symbolName + ".png",15 *scale/2,15 *scale/2, true, false));
        DisplayNumbers valueLabel = new DisplayNumbers(scale/2);
        valueLabel.setNumber(value);
        
        statBox.getChildren().addAll(symbolImageView, valueLabel.getNumberBox());
        return statBox;
    }

    public void createCardVisuals(int scale) {
        this.cardPane = new StackPane();
        Image cardImage = LoadImage.load("card/card.png",71 *scale,95 *scale, true, false); 

        
        ImageView cardImageView = new ImageView(cardImage);
        
        VBox statsBox = new VBox(5);
        statsBox.getChildren().add(createStatBox(scale, "cash", 4));
        statsBox.getChildren().add(createStatBox(scale, "trouble", 2));
        statsBox.getChildren().add(createStatBox(scale, "coin", 3));
        statsBox.getChildren().add(createStatBox(scale, "heart", 1));
        cardPane.getChildren().add(cardImageView);
        cardPane.getChildren().add(statsBox); 
        StackPane.setAlignment(cardImageView, Pos.TOP_LEFT);
    }
}
