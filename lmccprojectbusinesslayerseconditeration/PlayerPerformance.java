package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
 */
import java.io.*;

public class PlayerPerformance implements Serializable
{

    private FixtureType fixtureType;
    private Team team;
    private int gamesPlayed;
    private int numberOfInnings;
    private int numberOfRuns;
    private int numberOfDucks;
    private int numberOfNotOuts;
    private float battingAverage;
    private int numberOfRunsConceded;
    private int numberOfWicketsTaken;
    private float bowlingAverage;
    private int numberOfOutfieldCatches;
    private float allRounderIndex;

    public PlayerPerformance(FixtureType fixtureType, Team team, int gamesPlayed,
            int numberOfInnings, int numberOfRuns, int numberOfDucks,
            int numberOfNotOuts, int numberOfRunsConceded,
            int numberOfWicketsTaken, int numberOfOutfieldCatches)
    {
        this.fixtureType = fixtureType;
        this.team = team;
        this.gamesPlayed = gamesPlayed;
        this.numberOfInnings = numberOfInnings;
        this.numberOfRuns = numberOfRuns;
        this.numberOfDucks = numberOfDucks;
        this.numberOfNotOuts = numberOfNotOuts;
        this.numberOfRunsConceded = numberOfRunsConceded;
        this.numberOfWicketsTaken = numberOfWicketsTaken;
        this.numberOfOutfieldCatches = numberOfOutfieldCatches;
        this.calculateAveragesAndARIndex();
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
     * @return the gamesPlayed
     */
    public int getGamesPlayed()
    {
        return gamesPlayed;
    }

    /**
     * @param gamesPlayed the gamesPlayed to set
     */
    public void setGamesPlayed(int gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * @return the numberOfInnings
     */
    public int getNumberOfInnings()
    {
        return numberOfInnings;
    }

    /**
     * @param numberOfInnings the numberOfInnings to set
     */
    public void setNumberOfInnings(int numberOfInnings)
    {
        this.numberOfInnings = numberOfInnings;
        this.calculateAveragesAndARIndex();
    }

    /**
     * @return the numberOfRuns
     */
    public int getNumberOfRuns()
    {
        return numberOfRuns;
    }

    /**
     * @param numberOfRuns the numberOfRuns to set
     */
    public void setNumberOfRuns(int numberOfRuns)
    {
        this.numberOfRuns = numberOfRuns;
        this.calculateAveragesAndARIndex();
    }

    /**
     * @return the numberOfDucks
     */
    public int getNumberOfDucks()
    {
        return numberOfDucks;
    }

    /**
     * @param numberOfDucks the numberOfDucks to set
     */
    public void setNumberOfDucks(int numberOfDucks)
    {
        this.numberOfDucks = numberOfDucks;
    }

    /**
     * @return the numberOfNotOuts
     */
    public int getNumberOfNotOuts()
    {
        return numberOfNotOuts;
    }

    /**
     * @param numberOfNotOuts the numberOfNotOuts to set
     */
    public void setNumberOfNotOuts(int numberOfNotOuts)
    {
        this.numberOfNotOuts = numberOfNotOuts;
        this.calculateAveragesAndARIndex();
    }

    /**
     * @return the battingAverage
     */
    public float getBattingAverage()
    {
        return battingAverage;
    }

    /**
     * @return the numberOfRunsConceded
     */
    public int getNumberOfRunsConceded()
    {
        return numberOfRunsConceded;
    }

    /**
     * @param numberOfRunsConceded the numberOfRunsConceded to set
     */
    public void setNumberOfRunsConceded(int numberOfRunsConceded)
    {
        this.numberOfRunsConceded = numberOfRunsConceded;
        this.calculateAveragesAndARIndex();
    }

    /**
     * @return the numberOfWicketsTaken
     */
    public int getNumberOfWicketsTaken()
    {
        return numberOfWicketsTaken;
    }

    /**
     * @param numberOfWicketsTaken the numberOfWicketsTaken to set
     */
    public void setNumberOfWicketsTaken(int numberOfWicketsTaken)
    {
        this.numberOfWicketsTaken = numberOfWicketsTaken;
        this.calculateAveragesAndARIndex();
    }

    /**
     * @return the bowlingAverage
     */
    public float getBowlingAverage()
    {
        return bowlingAverage;
    }

    /**
     * @return the numberOfOutfieldCatches
     */
    public int getNumberOfOutfieldCatches()
    {
        return numberOfOutfieldCatches;
    }

    /**
     * @param numberOfOutfieldCatches the numberOfOutfieldCatches to set
     */
    public void setNumberOfOutfieldCatches(int numberOfOutfieldCatches)
    {
        this.numberOfOutfieldCatches = numberOfOutfieldCatches;
    }

    /**
     * @return the allRounderIndex
     */
    public float getAllRounderIndex()
    {
        return allRounderIndex;
    }

    /**
     * @return the fixture type and team type as a
     * concatenated string separated by a space
     */
    public String getFixtureTypeAndTeamType()
    {
        return this.fixtureType.toString() + " " + this.team.toString();
    }

    /**
     * Calculate averages and all-rounder index helper method
     * for setNumberOfInnings, setNumberOfNotOuts, setNumberOfRuns,
     * setNumberOfRunsConceded, SetNumberOfWicketsTaken
     * and class constructor
     */
    private void calculateAveragesAndARIndex()
    {
        // batting average is calculated if there are some runs 
        // and some innings where the player is out
        if ((this.numberOfRuns > 0)
                && ((this.numberOfInnings - this.numberOfNotOuts) > 0))
        {
            this.battingAverage = ((float) this.numberOfRuns
                    / (float) (this.numberOfInnings - this.numberOfNotOuts));
        }

        // bowling average is calculated if there are some runs
        // conceded and some wickets taken
        if ((this.numberOfRunsConceded > 0)
                && (this.numberOfWicketsTaken > 0))
        {
            this.bowlingAverage = ((float) this.numberOfRunsConceded
                    / (float) this.numberOfWicketsTaken);
        }

        // all-rounder index is calculated if there is both
        // a batting average and a bowling average
        if ((this.battingAverage > 0)
                && (this.bowlingAverage > 0))
        {
            this.allRounderIndex = (this.battingAverage
                    / this.bowlingAverage);
        }
    }
}
