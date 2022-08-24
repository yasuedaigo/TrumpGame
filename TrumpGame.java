import java.util.Arrays;
import java.util.Scanner;

public class TrumpGame {
    private final String[] COMMAND = { "d", "s", "r", "c" };
    private final String COMMAND_MESSAGE = "d:ドロー  s:シャッフル  r:リセット  c:点数計算";
    private final String INPUT_ERROR_MESSAGE = "入力エラーです";
    private CardManager cardManager;

    private TrumpGame() {
        cardManager = new CardManager();
    }

    public static void main(String[] args) {
        TrumpGame trumpGame = new TrumpGame();
        while (true) {
            String command = trumpGame.getCommand();
            trumpGame.executeCommand(command);
        }
    }

    private String getCommand() {
        String command = "e";
        while (!isTrue(command)) {
            showCommandMessage();
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                command = input.substring(0, 1);
            } catch (IndexOutOfBoundsException e) {
                showErrorMessage();
            }
        }
        return command;
    }

    private void showCommandMessage() {
        System.out.println(COMMAND_MESSAGE);
    }

    private void showErrorMessage() {
        System.out.println(INPUT_ERROR_MESSAGE);
    }

    private boolean isTrue(String command) {
        return Arrays.asList(COMMAND).contains(command);
    }

    private void executeCommand(String command) {
        switch (command) {
            case "d":
                cardManager.draw();
                break;
            case "s":
                cardManager.shuffle();
                break;
            case "r":
                cardManager.reset();
                break;
            case "c":
                cardManager.scoreCalc();
                break;
        }
    }
}
