package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.io.*;

public enum Team implements Serializable
{

    FIRSTXI("First XI"),
    SECONDXI("Second XI");
    private final String Team;

    Team(String theTeam)
    {
        Team = theTeam;
    }

    public String getTeam()
    {
        return Team;
    }
}
