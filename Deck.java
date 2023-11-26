import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        reset();
    }

    public void reset() {
        cards = new ArrayList<>();
        for (Card.Mark mark : Card.Mark.values()) {
            for (int number = 1; number <= 13; number++) {
                cards.add(new Card(mark, number));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }
}