import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int rounds;
        int players;

        //gets the desired amount of players and rounds
        System.out.println("How many players are there?: ");
        players = input.nextInt();
        System.out.println();

        System.out.println("How many rounds would you like?: ");
        rounds = input.nextInt();
        System.out.println();

        Round game = new Round(rounds, players, input);
        game.PlayRound();

        input.close();
    }
}
