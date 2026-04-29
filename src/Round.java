import java.util.InputMismatchException;
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
            System.out.println("What is Player " + (i + 1) + "'s name?: ");
            players[i] = new Player(userText.next());
        }

    }

    public void PlayRound()
    {
        Scanner input = new Scanner(System.in);
        int finalRound = 2;

        //tracks the rounds
        for (int i = 1; i <= rounds; i++)
        {
            System.out.println("Round " + i + " Begin!");
            System.out.println();
            //tracks what player is currently typing
            for (int h = 0; h < players.length; h++)
            {
                //decides whether to start the story or not
                if (i == 1)
                {
                    System.out.println(players[h].getName() + ", please type the start of your story: ");
                }
                else if (i == rounds)
                {
                    System.out.println(players[h].getName() + ", please finish this story: ");
                    System.out.println(players[(h + i) % players.length].getStory());
                }
                else
                {
                    System.out.println(players[h].getName() + ", please continue this story: ");
                    System.out.println(players[(h + i) % players.length].getStory());
                }
                String[] wordArray = input.nextLine().split(" ");

                System.out.println();

                //doesn't erase last half if its the last round.
                if (i == rounds)
                {
                    finalRound = 1;
                }

                //writes half of the words of the input text to the player's class
                for (int j = 0; j < wordArray.length/finalRound; j++)
                {
                    players[(h + i) % players.length].addToStory(wordArray[j] + " ");
                }
            }
        }

        int pointsGiven = 0;
        for (int i = 0; i < players.length; i++)
        {
            System.out.println(players[i].getStory());
            int h = 0;
            while (h < players.length)
            {

                System.out.println(players[h].getName() + ", please rate this story 1-10: ");
                try {
                pointsGiven = input.nextInt();
                System.out.println();
                }
                catch (InputMismatchException a) {
                    System.out.println("Please input a proper integer");
                    System.out.println();
                    input.next();
                }

                if (pointsGiven <= 10 && pointsGiven > 0)
                {
                    players[i].addPoints(pointsGiven);
                    h++;
                }
            }
       }
            int mostPoints = 0;
            String winner = "";
            for (Player item : players)
            {
                System.out.println(item.getName() + " has " + item.getPoints() + " points!");
                if (item.getPoints() > mostPoints)
                {
                    mostPoints = item.getPoints();
                    winner = item.getName();
                }
            }
            System.out.println(winner + " has won the game!");
        input.close();
    }

}
