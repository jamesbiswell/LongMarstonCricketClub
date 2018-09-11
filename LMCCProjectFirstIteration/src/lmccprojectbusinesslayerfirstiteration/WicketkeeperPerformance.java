package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.io.*;

public class WicketkeeperPerformance implements Serializable
{

    private FixtureType fixtureType;
    private Team team;
    private int gamesPlayedAsKeeper;
    private int numberOfKeeperCatches;
    private int numberOfStumpings;

    public WicketkeeperPerformance(FixtureType fixtureType, Team team,
            int gamesPlayedAsKeeper, int numberOfKeeperCatches,
            int numberOfStumpings)
    {
        this.fixtureType = fixtureType;
        this.team = team;
        this.gamesPlayedAsKeeper = gamesPlayedAsKeeper;
        this.numberOfKeeperCatches = numberOfKeeperCatches;
        this.numberOfStumpings = numberOfStumpings;
    }

    /**
     * @return the fixtureType
     */
    public FixtureType getFixtureType()
    {
        return fixtureType;
    }

    /**
     * @return the team
     */
    public Team getTeam()
    {
        return team;
    }

    /**
     * @return the gamesPlayedAsKeeper
     */
    public int getGamesPlayedAsKeeper()
    {
        return gamesPlayedAsKeeper;
    }

    /**
     * @param gamesPlayedAsKeeper the gamesPlayedAsKeeper to set
     */
    public void setGamesPlayedAsKeeper(int gamesPlayedAsKeeper)
    {
        this.gamesPlayedAsKeeper = gamesPlayedAsKeeper;
    }

    /**
     * @return the numberOfKeeperCatches
     */
    public int getNumberOfKeeperCatches()
    {
        return numberOfKeeperCatches;
    }

    /**
     * @param numberOfKeeperCatches the numberOfKeeperCatches to set
     */
    public void setNumberOfKeeperCatches(int numberOfKeeperCatches)
    {
        this.numberOfKeeperCatches = numberOfKeeperCatches;
    }

    /**
     * @return the numberOfStumpings
     */
    public int getNumberOfStumpings()
    {
        return numberOfStumpings;
    }

    /**
     * @param numberOfStumpings the numberOfStumpings to set
     */
    public void setNumberOfStumpings(int numberOfStumpings)
    {
        this.numberOfStumpings = numberOfStumpings;
    }

    /**
     * @return the fixture type and team type as a
     * concatenated string separated by a space
     */
    public String getFixtureTypeAndTeamType()
    {
        return this.fixtureType.toString() + " " + this.team.toString();
    }
}
