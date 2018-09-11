package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.io.*;

public class PlayerSummary implements Serializable
{

    private boolean captain;
    private boolean wicketkeeper;
    private PlayerClassification classification;
    private Team teamPreference;

    public PlayerSummary(boolean captain, boolean wicketkeeper,
            PlayerClassification classification, Team teamPreference)
    {
        this.captain = captain;
        this.wicketkeeper = wicketkeeper;
        this.classification = classification;
        this.teamPreference = teamPreference;
    }

    /**
     * @return the captain
     */
    public boolean isCaptain()
    {
        return captain;
    }

    /**
     * @param captain the captain to set
     */
    public void setCaptain(boolean captain)
    {
        this.captain = captain;
    }

    /**
     * @return the wicketkeeper
     */
    public boolean isWicketkeeper()
    {
        return wicketkeeper;
    }

    /**
     * @param wicketkeeper the wicketkeeper to set
     */
    public void setWicketkeeper(boolean wicketkeeper)
    {
        this.wicketkeeper = wicketkeeper;
    }

    /**
     * @return the classification
     */
    public PlayerClassification getClassification()
    {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(PlayerClassification classification)
    {
        this.classification = classification;
    }

    /**
     * @return the teamPreference
     */
    public Team getTeamPreference()
    {
        return teamPreference;
    }

    /**
     * @param teamPreference the teamPreference to set
     */
    public void setTeamPreference(Team teamPreference)
    {
        this.teamPreference = teamPreference;
    }
}
