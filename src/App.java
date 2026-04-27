import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Round game = new Round(3, 3, input);
        game.PlayRound();

        input.close();
    }
}
