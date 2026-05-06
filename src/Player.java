/**
 * The player constructor holds all of the information that is related directly to an individual player.
 * This class is called to by the Round class in most places, and it needed to be consolidated to its own class for the sake of efficiency.
 * It contains various getters and setters (taking the form of adders) to allow its variables held within the private playerObjects array to be accessed easily.
 */
public class Player {

    private Object[][] playerObjects;

/**
 * Creates the individual player with a name the user will input.
 * This allows for distinction between players so theres no risk of confusion.
 * <p>
 * The constructor also initializes the playerObjects array.
 * @param givenName the individual player's name
 */
    public Player(String givenName)
    {
        playerObjects = new Object[3][1];
        playerObjects[0][0] = givenName;
        playerObjects[1][0] = 0;
        playerObjects[2][0] = "";
    }

/**
 * Returns the player's name from the playerObjects array.
 * @return      the player's name
 */
    public String getName()
    {
        return (String) playerObjects[0][0];
    }

/**
 * Returns the current story from the playerObjects array.
 * @return      the player's points
 */
    public int getPoints()
    {
        return (int) playerObjects[1][0];
    }

/**
 * Returns the current story from the playerObjects array.
 * @return      the player's story string
 */
    public String getStory()
    {
        return (String) playerObjects[2][0];
    }



/**
 * Adds to the points in the playerObjects array.
 * <p>
 * There is no need to fully set the variable as there is no instance in the program where points is not simply added to.
 * This minimizes any potential coding errors, though negative numbers could be input for a subtraction effect.
 * @param additionalPoints the amount of points to be added to the players total
 */
    public void addPoints(int additionalPoints)
    {
        playerObjects[1][0] = ((int) playerObjects[1][0]) + additionalPoints;
    }

/**
 * Pieces the two pieces of the story together, from one round to the next.
 * Accesses the story string in the playerObjects array.
 * @param additionalStory the string of words that will be concatenated with the existing string
 */
    public void addToStory(String additionalStory)
    {
        playerObjects[2][0] = ((String) playerObjects[2][0]) + additionalStory;
    }

}
