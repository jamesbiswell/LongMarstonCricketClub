package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.io.*;

public enum PlayerClassification implements Serializable
{

    BATSMAN("Batsman"),
    BOWLER("Bowler"),
    ALLROUNDER("All-rounder"),
    WICKETKEEPER("Wicketkeeper");
    private final String playerClassification;

    PlayerClassification(String classification)
    {
        playerClassification = classification;
    }

    public String getPlayerClassification()
    {
        return playerClassification;
    }
}
