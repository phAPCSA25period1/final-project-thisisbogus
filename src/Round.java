import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Houses the entire round to be played with the amount of rounds and a list of players using the Player class as private variables to be set in the constructor.
 */
public class Round {

    private int rounds;
    public int round = 1;
    private Player[] players;

/**
 * Sets the amount of rounds in the game as well as creating the players that the user will input.
 * Initializes the players array.
 * <p>
 * Loops through the newly initialized player array and initializes the players with names input with the scanner.
 * @param roundCount the amount of rounds that will be played in the game
 * @param playerCount the amount of players that will play the game
 * @param userText the scanner that will be used to input text
 */
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

/**
 * A bit of a large method.
 * If I could do it again I'd probably seperate it into multiple for better readibility.
 * <p>
 * The core of the actual game, creating the collaborative stories.
 * It takes in user input each round, prompting them to write a piece of a story.
 * Once the player has entered their input, it will cut it in half, unless it's the end of the story.
 * <p>
 * It will then print the full stories, and ask each players to give it 1-10 points.
 * Finally, it loops through the players to check who has the greatest amount of points, and declares them the winner.
 */
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
