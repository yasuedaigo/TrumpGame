import java.util.Arrays;
import java.util.Scanner;

public class TrumpGame {
    private final String[] COMMAND = {"d","s","r"};
    private CardManager cardManager;

    private TrumpGame(){
        cardManager = new CardManager();
    }

    public static void main(String[] args) {
        TrumpGame trumpGame = new TrumpGame();
        while(true){
            String command = trumpGame.getCommand();
            trumpGame.executeCommand(command);
        }
    }

    private String getCommand() {
        String command = "e";
        while(!isTrue(command)){
            System.out.println("文字キーを押してください");
            try{
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                System.err.println("入力は"+input);
                command = input.substring(0,1);
            }catch(Exception e){
                System.err.println( "入力エラーです。" );
            }
        }
        return command;
    }

    private boolean isTrue(String command){
        return Arrays.asList(COMMAND).contains(command);
    }

    private void executeCommand(String command){
        switch(command){
            case "d":
                cardManager.draw();
                break;
            case "s":
            cardManager.shuffle();
                break;
            case "r":
            cardManager.reset();
                break;
            }
    }
}
