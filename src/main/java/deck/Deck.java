package deck;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import cards.Base;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Deck {
    private List<Base> cards;
    private List<Base> drawnCards;
    private int cardsDrawnThisRound;
    
    public Deck() {
        this.cards = new ArrayList<>();
        this.drawnCards = new ArrayList<>();
        this.cardsDrawnThisRound = 0;
    }
    
    public void addCard(Base card) {
        cards.add(card);
        System.out.println("Card added to deck. Total cards: " + cards.size());
    }
    
    public void removeCard(Base card) {
        cards.remove(card);

    }
    
    public Base drawTop() {
        if (cards.size() - cardsDrawnThisRound <= 0) {
            return null;
        }
        Base drawnCard = cards.get(cards.size() - 1 - cardsDrawnThisRound);
        drawnCards.add(drawnCard);
        cardsDrawnThisRound++;
        return drawnCard;
    }
    
    public void returnDrawnCards() {
        drawnCards.clear();
        cardsDrawnThisRound = 0;
    }

    public StackPane getDeckPane(Consumer<Base> onDraw) {
        StackPane deckPane = new StackPane();
        rebuildDeckPane(deckPane, onDraw);
        return deckPane;
    }

    private void rebuildDeckPane(StackPane deckPane, Consumer<Base> onDraw) {
        deckPane.getChildren().clear();
        int offset = 0;
        int scale = 2;
        int availableCards = cards.size() - cardsDrawnThisRound;
        for (int i = 0; i < availableCards; i++) {
            Base card = cards.get(cards.size() - 1 - i);
            var back = card.getCardBackside(scale);
            deckPane.getChildren().add(back);
            back.setTranslateX(-offset);
            back.setTranslateY(-offset);
            if (offset < 20) {
                offset += 4;
            }
        }
        Button deckButton = new Button("Deck (" + availableCards + " cards)");
        deckButton.setStyle("-fx-background-color: transparent; -fx-text-fill: transparent; -fx-border-color: transparent;");
        deckButton.setPrefWidth(78 * scale);
        deckButton.setPrefHeight(109 * scale);
        deckButton.setMinWidth(78 * scale);
        deckButton.setMinHeight(109 * scale);
        deckButton.setMaxWidth(78 * scale);
        deckButton.setMaxHeight(109 * scale);

        deckButton.setOnAction(e -> {
            Base drawn = drawTop();
            if (drawn != null) {
                if (onDraw != null) {
                    onDraw.accept(drawn);
                }
                rebuildDeckPane(deckPane, onDraw);
            }
        });
        deckPane.getChildren().add(deckButton);
    }
    
    public List<Base> getCards() {
        return cards;
    }
    
    public int size() {
        return cards.size();
    }
    
    public void clear() {
        cardsDrawnThisRound = 0;
        cards.clear();
        drawnCards.clear();
    }
}
