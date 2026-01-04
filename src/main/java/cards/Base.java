package cards;

import javafx.geometry.Pos;
import javafx.scene.Pane;
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
        HBox statBox = new HBox();
        ImageView symbolImageView = new ImageView(LoadImage.load("symbols/" + symbolName + ".png",12 *scale,12 *scale, true, false));
        DisplayNumbers valueLabel = new DisplayNumbers(scale);
        valueLabel.setNumber(value);
        DisplayBar displayBar = new DisplayBar(scale);
        displayBar.setNumber(value);
        StackPane barContainer = new StackPane(displayBar.getNumberBox()); // Assuming getNumberBox() returns ImageView
        barContainer.setPadding(new Insets(2*scale, 0, 0, 3*scale)); // Add padding
        statBox.getChildren().addAll(symbolImageView, valueLabel.getNumberBox(), barContainer);
        return statBox;
    }

    public void createCardVisuals() {
        this.cardPane = new StackPane();
        Image cardImage = LoadImage.load("card/card.png",80 *scale,107*scale, true, false); 

        
        ImageView cardImageView = new ImageView(cardImage);
        Image placeholderImage = LoadImage.load("cardArt/placeholder.png",70*scale,37*scale, true, false);
        ImageView placeholderImageView = new ImageView(placeholderImage);
        Image normTag = LoadImage.load("tag/NORM.png",34*scale,9*scale, true, false);
        ImageView normTagImageView = new ImageView(normTag);
        
        VBox statsBox = new VBox(2*scale);
        statsBox.getChildren().add(cashBox);
        statsBox.getChildren().add(troubleBox);
        statsBox.getChildren().add(costBox);
        statsBox.getChildren().add(heartBox);
        cardPane.getChildren().add(cardImageView);
        cardPane.getChildren().add(placeholderImageView);
        cardPane.getChildren().add(statsBox); 
        cardPane.getChildren().add(normTagImageView);
        StackPane.setAlignment(normTagImageView, Pos.TOP_LEFT);
        StackPane.setMargin(normTagImageView, new Insets(6*scale, 0, 0, 0));
        StackPane.setAlignment(placeholderImageView, Pos.TOP_CENTER);
        StackPane.setMargin(placeholderImageView, new Insets(5*scale, 0, 0, 0));
        StackPane.setAlignment(cardImageView, Pos.TOP_LEFT);
        StackPane.setMargin(statsBox, new Insets(45*scale, 0, 0, 4*scale));
    }
}
