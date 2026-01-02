package cards;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import counter.DisplayBar;

import javafx.geometry.Insets;
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
    HBox troubleBox;
    HBox cashBox;
    HBox costBox;
    HBox heartBox;
    int scale;
    int cash;
    int trouble;
    int cost;
    int heart;

    public Base(int cash, int trouble, int cost, int heart, int scale) {
        this.scale = scale;
        setCashVisual(cash);
        setTroubleVisual(trouble);
        setCostVisual(cost);
        setHeartVisual(heart);
        createCardVisuals();
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
    public void setTroubleVisual(int trouble) {
        this.troubleBox = createStatBox("trouble", trouble);
        setTrouble(trouble);
    }
    public void setCostVisual(int cost) {
        this.costBox = createStatBox("coin", cost);
        setCost(cost);
    }
    public void setHeartVisual(int heart) {
        this.heartBox = createStatBox("heart", heart);
        setHeart(heart);
    }
    public void setCashVisual(int cash) {
        this.cashBox = createStatBox("cash", cash);
        setCash(cash);
    }
    public void setCost(int cost) {
        this.cost = cost;
    }  
    public void setCash(int cash) {
        this.cash = cash;
    }
    public void setTrouble(int trouble) {
        this.trouble = trouble;
    }
    public void setHeart(int heart) {
        this.heart = heart;
    }

    public HBox createStatBox(String symbolName, int value) {
        HBox statBox = new HBox(scale/10);
        int statsScale = scale;
        ImageView symbolImageView = new ImageView(LoadImage.load("symbols/" + symbolName + ".png",12 *statsScale/1.5,12 *statsScale/1.5, true, false));
        DisplayNumbers valueLabel = new DisplayNumbers((int)(statsScale/1.5));
        valueLabel.setNumber(value);
        DisplayBar displayBar = new DisplayBar(statsScale);
        displayBar.setNumber(value);
        statBox.getChildren().addAll(symbolImageView, valueLabel.getNumberBox(), displayBar.getNumberBox());
        return statBox;
    }

    public void createCardVisuals() {
        this.cardPane = new StackPane();
        Image cardImage = LoadImage.load("card/card.png",71 *scale,95 *scale, true, false); 

        
        ImageView cardImageView = new ImageView(cardImage);
        
        VBox statsBox = new VBox(5 * scale);
        statsBox.getChildren().add(cashBox);
        statsBox.getChildren().add(troubleBox);
        statsBox.getChildren().add(costBox);
        statsBox.getChildren().add(heartBox);
        cardPane.getChildren().add(cardImageView);
        cardPane.getChildren().add(statsBox); 
        StackPane.setAlignment(cardImageView, Pos.TOP_LEFT);
        StackPane.setMargin(statsBox, new Insets(40*scale, 0, 0, 4*scale));
    }
}
