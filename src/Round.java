import java.util.Scanner;

public class Round {

    private int rounds;
    public int round = 1;
    private Player[] players;

    public Round(int roundCount, int playerCount, Scanner userText)
    {
        rounds = roundCount;
        players = new Player[playerCount];
        for (int i = 0; i < playerCount; i++)
        {
            players[i] = new Player(userText.next());
        }

    }

    public void PlayRound()
    {
        Scanner input = new Scanner(System.in);

        //tracks the rounds
        for (int i = 1; i < rounds; i++)
        {
            //tracks what player is currently typing
            for (int h = 0; h < players.length; h++)
            {
                //decides whether to start the story or not
                if (i == 1)
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

                //writes half of the words of the input text to the player's class
                for (int j = 0; j < wordArray.length/2; j++)
                {
                    //essentially for testing, should be removed later
                    System.out.print(wordArray[j]);
                    System.out.print(" ");

                    players[h].addToStory(wordArray[j] + " ");
                }
            }
        }
        input.close();
    }

}
