package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
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
