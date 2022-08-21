import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardManager {
    
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> hands = new ArrayList<>();
    private final int MAX_HAND_NUMBER = 2;
    private final String RANKING_MESSAGE = "%d 位: %s %d";
    private final int START_RANK = 1;

    public CardManager() {
        this.reset();
        this.shuffle();
    }

    public void reset(){
        deck.clear();
        for(Card.MARKS mark : Card.MARKS.values()){
            for(int i=1;i<=Card.MAX_NUMBER;i++){
                Card card = new Card(i,mark);
                deck.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public void draw(){
        System.out.println(deck.get(0).toString() +"をひきました");
        hands.add(deck.get(0));
        deck.remove(0);
        showInfo(hands);
        if(isMax(hands)){
            this.scoreCalc(hands);
            hands.clear();
        }
    }

    private boolean isMax(ArrayList<Card> hands){
        return hands.size() == MAX_HAND_NUMBER;
    }

    private void scoreCalc(ArrayList<Card> hands){
        int score = 0;
        for (Card card : hands) {
            score = score + card.getNumber();
        }
        System.out.println("点数は"+score +"です");
    }

    private void showInfo(ArrayList<Card> hands){
        System.out.println("現在の手札は");
        for (Card card : hands) {
            card.showInfo();
        }
    }
}
