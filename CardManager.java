import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardManager {
    public static final Map<Integer, Integer> NUMBER_VALUES = new HashMap<>();
    static {
        NUMBER_VALUES.put(1, 11);
        NUMBER_VALUES.put(11, 10);
        NUMBER_VALUES.put(12, 10);
        NUMBER_VALUES.put(13, 10);
    }
    private final int TOP_INDEX = 0;
    private final int MAX_SCORE = 21;
    private final String DROWCARD_MESSAGE = "%sをひきました";
    private final String SCORE_MESSAGE = "点数は%dです";
    private final String HAND_MESSAGE = "現在の手札は：";
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> hands = new ArrayList<>();

    public CardManager() {
        this.reset();
        this.shuffle();
    }

    public void reset() {
        deck.clear();
        for (Card.MARKS mark : Card.MARKS.values()) {
            for (int i = 1; i <= Card.MAX_NUMBER; i++) {
                Card card = new Card(i, mark);
                deck.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    private void showDrawMessage() {
        System.out.println(String.format(DROWCARD_MESSAGE, deck.get(TOP_INDEX).toString()));
    }

    private void showScoreMessage(int score) {
        System.out.println(String.format(SCORE_MESSAGE, score));
    }

    public void draw() {

        showHands(hands);
        showDrawMessage();
        hands.add(deck.get(TOP_INDEX));
        deck.remove(TOP_INDEX);

        showHands(hands);
    }

    public void scoreCalc() {
        showHands(hands);
        int score = 0;
        for (Card card : hands) {
            score = score + numberValue(card);
        }
        score = adjustAce(hands, score);
        showScoreMessage(score);
        hands.clear();
    }

    private int numberValue(Card card) {
        if (NUMBER_VALUES.containsKey(card.getNumber())) {
            return NUMBER_VALUES.get(card.getNumber());
        }
        return card.getNumber();
    }

    private int adjustAce(ArrayList<Card> hands, int score) {
        for (Card card : hands) {
            if (isAce(card)) {
                if (isOver(score)) {
                    score  = downAce(score);
                }
            }
        }
        return score;
    }

    private int downAce(int score) {
        return score - 10;
    }

    private boolean isAce(Card card) {
        return card.getNumber() == 1;
    }

    private boolean isOver(int score) {
        return score > MAX_SCORE;
    }

    private void showHands(ArrayList<Card> hands) {
        showHandMessage();
        for (Card card : hands) {
            System.out.print(card.numberChar() + " ");
        }
        System.out.println("");
    }

    private void showHandMessage() {
        System.out.print(HAND_MESSAGE);
    }
}
