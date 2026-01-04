package scenes;

import java.util.ArrayList;
import java.util.List;

import cards.Base;

public class DeckScene {
    private List<Base> deck;

    public DeckScene() {
        deck = new ArrayList<>();
    }
    public void addCardToDeck(Base card) {
        deck.add(card);
    }
    public List<Base> getDeck() {
        return deck;
    }
    public void removeCardFromDeck(Base card) {
        deck.remove(card);
    }
    
    public Base getRandomCard() {
        if (deck.isEmpty()) {
            return null;
        }
        int randomIndex = (int) (Math.random() * deck.size());
        return deck.get(randomIndex);
    }
}
