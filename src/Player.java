public class Player {

    private Object[][] playerObjects;

    public Player(String givenName)
    {
        playerObjects = new Object[3][1];
        playerObjects[0][0] = givenName;
        playerObjects[1][0] = 0;
        playerObjects[2][0] = "";
    }

    public String getName()
    {
        return (String) playerObjects[0][0];
    }

    public void addPoints(int additionalPoints)
    {
        playerObjects[1][0] = ((int) playerObjects[1][0]) + additionalPoints;
    }

    public void addToStory(String additionalStory)
    {
        playerObjects[2][0] = ((String) playerObjects[2][0]) + additionalStory;
    }

    public String getStory()
    {
        return (String) playerObjects[2][0];
    }

    public int getPoints()
    {
        return (int) playerObjects[1][0];
    }
}
