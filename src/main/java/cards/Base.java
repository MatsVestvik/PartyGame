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
    HBox troubleBox;
    HBox cashBox;
    HBox costBox;
    HBox heartBox;
    ImageView cardImageView;
    ImageView rareImageView;
    DisplayNumbers cashDisplay;
    DisplayNumbers troubleDisplay;
    DisplayNumbers costDisplay;
    DisplayNumbers heartDisplay;
    DisplayBar cashBar;
    DisplayBar troubleBar;
    DisplayBar costBar;
    DisplayBar heartBar;
    int scale;
    int cash;
    int trouble;
    int cost;
    int heart;
    int color;
    int rarity;

    public Base(int cash, int trouble, int cost, int heart, int scale, int color, int rarity) {
        this.scale = scale;
        setCashBox(cash);
        setTroubleBox(trouble);
        setCostBox(cost);
        setHeartBox(heart);
        setCardImageView(color);
        setRarityImageView(rarity);
        createCardVisuals();

    }
    public StackPane getCardPane() {
        return cardPane;
    }
    public HBox getTroubleBox() {
        return troubleBox;
    }
    public HBox getCashBox() {
        return cashBox;
    }
    public HBox getCostBox() {
        return costBox;
    }
    public HBox getHeartBox() {
        return heartBox;
    }
    public void setTroubleBox(int trouble) {
        this.troubleDisplay = new DisplayNumbers(scale);
        this.troubleBar = new DisplayBar(scale);
        this.troubleBox = createStatBox("trouble", trouble, troubleDisplay, troubleBar);
        setTrouble(trouble);
    }
    public void setCostBox(int cost) {
        this.costDisplay = new DisplayNumbers(scale);
        this.costBar = new DisplayBar(scale);
        this.costBox = createStatBox("coin", cost, costDisplay, costBar);
        setCost(cost);
    }
    public void setHeartBox(int heart) {
        this.heartDisplay = new DisplayNumbers(scale);
        this.heartBar = new DisplayBar(scale);
        this.heartBox = createStatBox("heart", heart, heartDisplay, heartBar);
        setHeart(heart);
    }
    public void setCashBox(int cash) {
        this.cashDisplay = new DisplayNumbers(scale);
        this.cashBar = new DisplayBar(scale);
        this.cashBox = createStatBox("cash", cash, cashDisplay, cashBar);
        setCash(cash);
    }
    public void setCardImageView(int color) {
        this.color = color;
        ImageView newImageView = intToColor.getColorImageView(color, scale);
        if (cardPane != null) {
            int index = cardPane.getChildren().indexOf(cardImageView);
            if (index >= 0) {
                cardPane.getChildren().set(index, newImageView);
                StackPane.setAlignment(newImageView, Pos.TOP_LEFT);
            }
        }
        this.cardImageView = newImageView;
    }
    public void setRarityImageView(int rarity) {
        this.rarity = rarity;
        ImageView newRareImageView = intToRare.getRareImage(rarity, scale);
        if (cardPane != null) {
            int index = cardPane.getChildren().indexOf(rareImageView);
            if (index >= 0) {
                cardPane.getChildren().set(index, newRareImageView);
                StackPane.setAlignment(newRareImageView, Pos.TOP_LEFT);
                StackPane.setMargin(newRareImageView, new Insets(6*scale, 0, 0, 0));
            }
        }
        this.rareImageView = newRareImageView;
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
    

    public void updateCash(int cash) {
        setCash(cash);
        if (cashDisplay != null) {
            cashDisplay.setNumber(cash);
        }
        if (cashBar != null) {
            cashBar.setNumber(cash);
        }
    }

    public void updateTrouble(int trouble) {
        setTrouble(trouble);
        if (troubleDisplay != null) {
            troubleDisplay.setNumber(trouble);
        }
        if (troubleBar != null) {
            troubleBar.setNumber(trouble);
        }
    }

    public void updateCost(int cost) {
        setCost(cost);
        if (costDisplay != null) {
            costDisplay.setNumber(cost);
        }
        if (costBar != null) {
            costBar.setNumber(cost);
        }
    }

    public void updateHeart(int heart) {
        setHeart(heart);
        if (heartDisplay != null) {
            heartDisplay.setNumber(heart);
        }
        if (heartBar != null) {
            heartBar.setNumber(heart);
        }
    }

    public HBox createStatBox(String symbolName, int value, DisplayNumbers valueLabel, DisplayBar displayBar) {
        HBox statBox = new HBox();
        ImageView symbolImageView = new ImageView(LoadImage.load("symbols/" + symbolName + ".png",12 *scale,12 *scale, true, false));
        valueLabel.setNumber(value);
        displayBar.setNumber(value);
        StackPane barContainer = new StackPane(displayBar.getNumberBox()); // Assuming getNumberBox() returns ImageView
        barContainer.setPadding(new Insets(2*scale, 0, 0, 3*scale)); // Add padding
        statBox.getChildren().addAll(symbolImageView, valueLabel.getNumberBox(), barContainer);
        return statBox;
    }

    public void createCardVisuals() {
        this.cardPane = new StackPane();
        
        Image placeholderImage = LoadImage.load("cardArt/placeholder.png",70*scale,37*scale, true, false);
        ImageView placeholderImageView = new ImageView(placeholderImage);
        
        VBox statsBox = new VBox(2*scale);
        statsBox.getChildren().add(cashBox);
        statsBox.getChildren().add(troubleBox);
        statsBox.getChildren().add(costBox);
        statsBox.getChildren().add(heartBox);
        cardPane.getChildren().add(cardImageView);
        cardPane.getChildren().add(placeholderImageView);
        cardPane.getChildren().add(statsBox); 
        cardPane.getChildren().add(rareImageView);
        StackPane.setAlignment(rareImageView, Pos.TOP_LEFT);
        StackPane.setMargin(rareImageView, new Insets(6*scale, 0, 0, 0));
        StackPane.setAlignment(placeholderImageView, Pos.TOP_CENTER);
        StackPane.setMargin(placeholderImageView, new Insets(5*scale, 0, 0, 0));
        StackPane.setAlignment(cardImageView, Pos.TOP_LEFT);
        StackPane.setMargin(statsBox, new Insets(45*scale, 0, 0, 4*scale));
    }
}
