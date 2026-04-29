public class Player {

    private String name;
    private int points = 0;
    private String story = "";

    public Player(String givenName)
    {
        name = givenName;
    }

    public String getName()
    {
        return name;
    }

    public void addPoints(int additionalPoints)
    {
        points += additionalPoints;
    }

    public void addToStory(String additionalStory)
    {
        story = story + additionalStory;
    }

    public String getStory()
    {
        return story;
    }

    public int getPoints()
    {
        return points;
    }
}
