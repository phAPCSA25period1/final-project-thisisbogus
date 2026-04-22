import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    private int rounds;
    public int round = 1;
    private ArrayList<Player> players;

    public Round(int roundCount, int playerCount, Scanner userText)
    {
        rounds = roundCount;
        for (int i = 1; i <= playerCount; i++)
        {
            players.add(new Player(userText.next()));
        }

    }

    public void PlayRound()
    {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i < rounds; i++)
        {
            for (int i = 0; )
            if (round == 1)
            {
                System.out.println("Please type the start of your story: ");
            }
            else
            {
                System.out.println("Please continue this story: ");
                System.out.println("");
            }
            String[] wordArray = input.nextLine().split(" ");

            System.out.println();

            String story = "";

            for (int i = 0; i < wordArray.length/2; i++)
            {
                System.out.print(wordArray[i]);
                System.out.print(" ");
                story = story + wordArray[i] + " ";
            }
        }
        input.close();
    }

}
