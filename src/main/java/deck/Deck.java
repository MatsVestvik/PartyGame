package deck;

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
