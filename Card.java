public class Card {
    public static final int MAX_NUMBER = 13;
    public enum MARKS{
        Diamonds,
        Hearts,
        Clubs,
        Spades
    }
    private MARKS mark;
    private int number;

    public Card(int useNumber,MARKS useMark) {
        this.number = useNumber;
        this.mark = useMark;
    }

    public int getNumber() {
        return number;
    }

    public MARKS getMark() {
        return mark;
    }

    public void showInfo(){
        System.out.println(mark.toString()+"の"+getNumber());
    }

    public String toString(){
        return mark.toString()+"の"+getNumber();
    }

}
