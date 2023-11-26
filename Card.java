public class Card {
    enum Mark {
        DIAMONDS, HEARTS, CLUBS, SPADES
    }

    private Mark mark;
    private int number;

    public Card(Mark mark, int number) {
        this.mark = mark;
        this.number = number;
    }

    public Mark getMark() {
        return mark;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return mark + " " + number;
    }
}