package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
 */
import java.util.*;
import java.io.*;

public class Fixture implements Serializable
{

    // private static int numberOfFixtures = 0;
    private int fixtureNumber;
    private FixtureType fixtureType;
    private Team team;
    private Integer date;
    private String season;
    private String postcodeLocation;
    private String opposition;
    private Result result;
    private Collection<Player> playersAvailableFor;
    private Collection<Player> playersSelectedFor;
    private Collection<Player> playersPlayedFor;

    public Fixture(int fixtureNumber, FixtureType fixtureType, Team team,
            int date, String postcodeLocation, String opposition)
    {
        // numberOfFixtures++;
        // this.fixtureNumber = numberOfFixtures;
        this.fixtureNumber = fixtureNumber;
        this.fixtureType = fixtureType;
        this.team = team;
        this.date = date;
        this.season = this.date.toString().substring(0, 4);
        this.postcodeLocation = postcodeLocation;
        this.opposition = opposition;
        this.result = Result.TO_BE_DETERMINED;
        this.playersAvailableFor = new HashSet<Player>();
        this.playersSelectedFor = new HashSet<Player>();
        this.playersPlayedFor = new HashSet<Player>();
    }

    /**
     * @return the fixtureNumber
     */
    public int getFixtureNumber()
    {
        return fixtureNumber;
    }

    /**
     * @return the fixtureType
     */
    public FixtureType getFixtureType()
    {
        return fixtureType;
    }

    /**
     * @param fixtureType the fixtureType to set
     */
    public void setFixtureType(FixtureType fixtureType)
    {
        this.fixtureType = fixtureType;
    }

    /**
     * @return the team
     */
    public Team getTeam()
    {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(Team team)
    {
        this.team = team;
    }

    /**
     * @return the postcodeLocation
     */
    public String getPostcodeLocation()
    {
        return postcodeLocation;
    }

    /**
     * @param postcodeLocation the postcodeLocation to set
     */
    public void setPostcodeLocation(String postcodeLocation)
    {
        this.postcodeLocation = postcodeLocation;
    }

    /**
     * @return the opposition
     */
    public String getOpposition()
    {
        return opposition;
    }

    /**
     * @param opposition the opposition to set
     */
    public void setOpposition(String opposition)
    {
        this.opposition = opposition;
    }

    /**
     * @return the result
     */
    public Result getResult()
    {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Result result)
    {
        this.result = result;
    }

    /**
     * @return the playersAvailableFor
     */
    public Collection<Player> getPlayersAvailableFor()
    {
        return playersAvailableFor;
    }

    /**
     * @param playersAvailableFor the playersAvailableFor to set
     */
    public void setPlayersAvailableFor(Collection<Player> playersAvailableFor)
    {
        this.playersAvailableFor = playersAvailableFor;
    }

    /**
     * @return the playersSelectedFor
     */
    public Collection<Player> getPlayersSelectedFor()
    {
        return playersSelectedFor;
    }

    /**
     * @param playersSelectedFor the playersSelectedFor to set
     */
    public void setPlayersSelectedFor(Collection<Player> playersSelectedFor)
    {
        this.playersSelectedFor = playersSelectedFor;
    }

    /**
     * @return the playersPlayedFor
     */
    public Collection<Player> getPlayersPlayedFor()
    {
        return playersPlayedFor;
    }

    /**
     * @param playersPlayedFor the playersPlayedFor to set
     */
    public void setPlayersPlayedFor(Collection<Player> playersPlayedFor)
    {
        this.playersPlayedFor = playersPlayedFor;
    }

    /**
     * @return the date
     */
    public int getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(int date)
    {
        this.date = date;
        this.setSeason();
    }

    /**
     * @return the season
     */
    public String getSeason()
    {
        return season;
    }

    /**
     * season of fixture is set in line with the date of the fixture
     */
    public void setSeason()
    {
        this.season = this.date.toString().substring(0, 4);
    }

    /**
     * Return summary details of this fixture for the toString method
     *
     * @return the String
     */
    @Override
    public String toString()
    {
        return this.fixtureNumber + " "
                + this.team.toString() + " "
                + this.fixtureType.toString() + " "
                + this.date + " "
                + this.opposition + " "
                + this.postcodeLocation + " ";
    }

    /**
     * Return a String with various fixture details
     *
     * @return the String
     */
    public String toStringLong()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Fixture Number: " + this.fixtureNumber + "  ");
        sb.append("Team: " + this.team + "  ");
        sb.append("Fixture Type: " + this.fixtureType + "  ");
        sb.append("Date: " + this.date + "  ");
        sb.append("Opposition: " + this.opposition + "  ");
        sb.append("Location: " + this.postcodeLocation + "  ");
        if (this.result != null)
        {
            sb.append("Result: " + this.result + "  ");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Add player available for
     *
     * @param player - the player available for the fixture
     *
     * @return whether or not he is added
     */
    public boolean addPlayerAvailableFor(Player player)
    {
        if (!(this.playersAvailableFor.contains(player)))
        {
            this.playersAvailableFor.add(player);
            if (!(player.getFixturesAvailableFor().contains(this)))
            {
                player.addFixtureAvailableFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete player available for
     *
     * @param player - the player no longer available for the fixture
     *
     * @return whether or not he is deleted
     */
    public boolean deletePlayerAvailableFor(Player player)
    {
        if (this.playersAvailableFor.contains(player)
                && !(this.playersSelectedFor.contains(player)))
        {
            this.playersAvailableFor.remove(player);
            if (player.getFixturesAvailableFor().contains(this))
            {
                player.deleteFixtureAvailableFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View players available for
     *
     * @return the players available for the fixture
     */
    public Collection<Player> viewPlayersAvailableFor()
    {
        return this.playersAvailableFor;
    }

    /**
     * Add player selected for
     *
     * @param player - the player selected for the fixture
     *
     * @return whether or not he is added
     */
    public boolean addPlayerSelectedFor(Player player)
    {
        if ((this.playersAvailableFor.contains(player))
                && (this.playersSelectedFor.size() < 11)
                && !(this.playersSelectedFor.contains(player)))
        {
            this.playersSelectedFor.add(player);
            if (!(player.getFixturesSelectedFor().contains(this)))
            {
                player.addFixtureSelectedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete player selected for
     *
     * @param player - the player no longer selected for the fixture
     *
     * @return whether or not he is deleted
     */
    public boolean deletePlayerSelectedFor(Player player)
    {
        if (this.playersSelectedFor.contains(player)
                && !(this.playersPlayedFor.contains(player)))
        {
            this.playersSelectedFor.remove(player);
            if (player.getFixturesSelectedFor().contains(this))
            {
                player.deleteFixtureSelectedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View players selected for
     *
     * @return the players selected for the fixture
     */
    public Collection<Player> viewPlayersSelectedFor()
    {
        return this.playersSelectedFor;
    }

    /**
     * Add player played for
     *
     * @param player - the player who played for the fixture
     *
     * @return whether or not he is added
     */
    public boolean addPlayerPlayedFor(Player player)
    {
        if ((this.playersSelectedFor.contains(player))
                && (this.playersPlayedFor.size() < 11)
                && !(this.playersPlayedFor.contains(player)))
        {
            this.playersPlayedFor.add(player);
            if (!(player.getFixturesPlayedFor().contains(this)))
            {
                player.addFixturePlayedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete player played for
     *
     * @param player - the player who did not play for the fixture
     *
     * @return whether or not he is deleted
     */
    public boolean deletePlayerPlayedFor(Player player)
    {
        if (this.playersPlayedFor.contains(player))
        {
            this.playersPlayedFor.remove(player);
            if (player.getFixturesPlayedFor().contains(this))
            {
                player.deleteFixturePlayedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View players played for
     *
     * @return the players who played for the fixture
     */
    public Collection<Player> viewPlayersPlayedFor()
    {
        return this.playersPlayedFor;
    }
}
