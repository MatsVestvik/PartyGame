package cards;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.Stack;

import counter.DisplayBar;
import counter.DisplayNumbers;
import util.LoadImage;

public class Base {
    StackPane cardPane;
    HBox troubleBox;
    HBox cashBox;
    HBox costBox;
    HBox heartBox;
    ImageView cardImageView;
    ImageView rareImageView;
    ImageView descriptionImageView;
    StackPane frontFace;
    StackPane descriptionFace;
    Button flipFaceButton;
    Button flipDescriptionButton;
    ImageView cardArtView;
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
    boolean showingFront = true;
    String description;
    Text descriptionText;

    public Base(int cash, int trouble, int cost, int heart, int scale, int color, int rarity, String artName, String description) {
        this.scale = scale;
        setCashBox(cash);
        setTroubleBox(trouble);
        setCostBox(cost);
        setHeartBox(heart);
        setCardImageView(color);
        setCardArtView(artName);
        this.description = description;
        this.descriptionText = new Text(description);
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
    public ImageView getCardArtView() {
        return cardArtView;
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
        if (frontFace != null) {
            int index = frontFace.getChildren().indexOf(cardImageView);
            if (index >= 0) {
                frontFace.getChildren().set(index, newImageView);
                StackPane.setAlignment(newImageView, Pos.TOP_LEFT);
            }
        }
        this.cardImageView = newImageView;
    }
    public void setRarityImageView(int rarity) {
        this.rarity = rarity;
        ImageView newRareImageView = intToRare.getRareImage(rarity, scale);
        if (frontFace != null) {
            int index = frontFace.getChildren().indexOf(rareImageView);
            if (index >= 0) {
                frontFace.getChildren().set(index, newRareImageView);
                StackPane.setAlignment(newRareImageView, Pos.TOP_LEFT);
                StackPane.setMargin(newRareImageView, new Insets(6*scale, 0, 0, 0));
            }
        }
        this.rareImageView = newRareImageView;
    }
    public void setCardArtView(String artName) {
        this.cardArtView = cardArts.getCardArt(artName, scale);
        if (frontFace != null) {
            int index = frontFace.getChildren().indexOf(cardArtView);
            if (index >= 0) {
                frontFace.getChildren().set(index, cardArtView);
                StackPane.setAlignment(cardArtView, Pos.TOP_CENTER);
                StackPane.setMargin(cardArtView, new Insets(5*scale, 0, 0, 0));
            }
        }
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

    public void showFace() {
        showingFront = true;
        if (frontFace != null && descriptionFace != null) {
            frontFace.setVisible(true);
            descriptionFace.setVisible(false);
        }
    }

    public void showDescription() {
        showingFront = false;
        if (frontFace != null && descriptionFace != null) {
            frontFace.setVisible(false);
            descriptionFace.setVisible(true);
        }
    }

    public void flipCard() {
        showingFront = !showingFront;
        if (frontFace != null && descriptionFace != null) {
            frontFace.setVisible(showingFront);
            descriptionFace.setVisible(!showingFront);
        }
    }

    public HBox createStatBox(String symbolName, int value, DisplayNumbers valueLabel, DisplayBar displayBar) {
        HBox statBox = new HBox();
        ImageView symbolImageView = new ImageView(LoadImage.load("symbols/" + symbolName + ".png",12 *scale,12 *scale, true, false));
        valueLabel.setNumber(value);
        displayBar.setNumber(value);
        StackPane barContainer = new StackPane(displayBar.getNumberBox()); 
        barContainer.setPadding(new Insets(2*scale, 0, 0, 3*scale)); 
        statBox.getChildren().addAll(symbolImageView, valueLabel.getNumberBox(), barContainer);
        return statBox;
    }

    public void createCardVisuals() {
        cardPane = new StackPane();

        frontFace = new StackPane();
        VBox statsBox = new VBox(2 * scale);
        statsBox.getChildren().addAll(cashBox, troubleBox, costBox, heartBox);
        frontFace.getChildren().addAll(cardImageView, cardArtView, statsBox, rareImageView);
        StackPane.setAlignment(cardImageView, Pos.TOP_LEFT);
        StackPane.setAlignment(cardArtView, Pos.TOP_CENTER);
        StackPane.setMargin(cardArtView, new Insets(5 * scale, 0, 0, 0));
        StackPane.setMargin(statsBox, new Insets(45 * scale, 0, 0, 4 * scale));
        StackPane.setAlignment(rareImageView, Pos.TOP_LEFT);
        StackPane.setMargin(rareImageView, new Insets(6 * scale, 0, 0, 0));

        descriptionFace = new StackPane();
        if (descriptionImageView == null) {
            descriptionImageView = new ImageView(LoadImage.load("card/" + intToColor.convert(color) + "Card.png", 80 * scale, 107 * scale, true, false)); 
        }
        descriptionFace.getChildren().add(descriptionImageView);
        
        // Create TextFlow for text wrapping
        TextFlow descriptionFlow = new TextFlow();
        descriptionFlow.setPrefWidth(70 * scale);
        descriptionFlow.setMaxWidth(70 * scale);
        if (descriptionText != null) {
            descriptionText.setWrappingWidth(70 * scale);
            descriptionText.getStyleClass().add("description-text");
            descriptionFlow.getChildren().add(descriptionText);
        }
        descriptionFace.getChildren().add(descriptionFlow);
        StackPane.setAlignment(descriptionFlow, Pos.TOP_LEFT);
        StackPane.setMargin(descriptionFlow, new Insets(5 * scale, 5 * scale, 5 * scale, 5 * scale));
        StackPane.setAlignment(descriptionImageView, Pos.TOP_LEFT);

        cardPane.getChildren().addAll(frontFace, descriptionFace);
        descriptionFace.setVisible(false);
        cardPane.setOnMouseClicked(e -> flipCard());
        cardPane.setOnMouseEntered(e -> showDescription());
        cardPane.setOnMouseExited(e -> showFace());
    }
}
