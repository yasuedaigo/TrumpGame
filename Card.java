import java.util.HashMap;
import java.util.Map;

public class Card {
    public static final int MAX_NUMBER = 13;
    public static Map<Integer, String> alfabetNumbers = new HashMap<>();
    static {
        alfabetNumbers.put(1, "A");
        alfabetNumbers.put(11, "J");
        alfabetNumbers.put(12, "Q");
        alfabetNumbers.put(13, "K");
    }

    public enum MARKS {
        Diamonds,
        Hearts,
        Clubs,
        Spades
    }

    private final String CARD_MESSAGE = "%sの%d";
    private MARKS mark;
    private int number;

    public Card(int useNumber, MARKS useMark) {
        this.number = useNumber;
        this.mark = useMark;
    }

    public int getNumber() {
        return number;
    }

    public String numberChar() {
        if (isAlfabetNumber()) {
            return alfabetNumbers.get(this.number);
        }
        return String.valueOf(this.number);
    }

    private boolean isAlfabetNumber() {
        return alfabetNumbers.containsKey(this.number);
    }

    public MARKS getMark() {
        return mark;
    }

    public void showCardMessage() {
        System.out.println(String.format(CARD_MESSAGE, mark.toString(), getNumber()));
    }

    public String toString() {
        return mark.toString() + "の" + getNumber();
    }

}
