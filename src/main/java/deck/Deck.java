package deck;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import cards.Base;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Deck {
    private List<Base> cards;
    
    public Deck() {
        this.cards = new ArrayList<>();
    }
    
    public void addCard(Base card) {
        cards.add(card);
        System.out.println("Card added to deck. Total cards: " + cards.size());
    }
    
    public void removeCard(Base card) {
        cards.remove(card);

    }
    
    public Base drawTop() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
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
        for (Base card : cards) {
            var back = card.getCardBackside(scale);
            deckPane.getChildren().add(back);
            back.setTranslateX(-offset);
            back.setTranslateY(-offset);
            if (offset < 20) {
                offset += 4;
            }
        }
        Button deckButton = new Button("Deck (" + cards.size() + " cards)");
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
        cards.clear();
    }
}
