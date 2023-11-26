public class Blackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        Card card1 = deck.draw();
        Card card2 = deck.draw();

        System.out.println("引いたカード: " + card1 + " と " + card2);
        int score = calculateScore(card1, card2);
        System.out.println("ブラックジャックのスコア: " + score);
    }
    
    public static int calculateScore(Card card1, Card card2) {
        int totalScore = calculateCardValue(card1) + calculateCardValue(card2);
        
        if (shouldAdjustAceValue(card1, card2, totalScore)) {
            totalScore -= 10;
        }

        return totalScore;
    }

    private static int calculateCardValue(Card card) {
        switch (card.getNumber()) {
            case 1:
                return 11;
            case 11: case 12: case 13:
                return 10;
            default:
                return card.getNumber();
        }
    }

    private static boolean shouldAdjustAceValue(Card card1, Card card2, int totalScore) {
        return (card1.getNumber() == 1 || card2.getNumber() == 1) && totalScore > 21;
    }


}