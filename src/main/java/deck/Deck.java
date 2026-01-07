package deck;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import cards.Base;
import java.util.ArrayList;
import java.util.List;

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
    
    public StackPane getDeckPane() {
        StackPane deckPane = new StackPane();
        int offset = 0;
        int scale = 2;
        for (Base card : cards) {
            // cache the backside node so we position the same instance we add
            var back = card.getCardBackside(scale);
            deckPane.getChildren().add(back);
            back.setTranslateX(-offset);
            back.setTranslateY(-offset);
            if (offset < 20){
                offset += 4;
            }
        }
        Button deckButton = new Button("Deck (" + cards.size() + " cards)");
        deckButton.setOnAction(e -> {
            removeCard(cards.get(cards.size() - 1));
        });
        deckPane.getChildren().add(deckButton);
        return deckPane;
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
