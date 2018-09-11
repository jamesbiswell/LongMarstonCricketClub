package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
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
