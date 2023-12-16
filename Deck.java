import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        reset();
    }

    //デッキをリセットする
    public void reset() {
        cards = new ArrayList<>();
        for (Card.Mark mark : Card.Mark.values()) {
            for (int number = 1; number <= 13; number++) {
                cards.add(new Card(mark, number));
            }
        }
    }

    //デッキをシャッフルする
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //デッキからカードを1枚引く
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }
}