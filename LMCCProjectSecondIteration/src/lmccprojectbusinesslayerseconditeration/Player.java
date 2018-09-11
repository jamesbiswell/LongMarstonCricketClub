package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
 */
import java.util.*;
import java.io.*;
import java.math.*;

public class Player implements Serializable
{

    // private static int numberOfPlayers = 0;
    private int playerNumber;
    private String name;
    private String address;
    private String email;
    private String landline;
    private String mobile;
    private PlayerSummary playerSummary;
    private Collection<PlayerPerformance> playerPerformance;
    private Collection<WicketkeeperPerformance> wicketkeeperPerformance;
    private Collection<Fixture> fixturesAvailableFor;
    private Collection<Fixture> fixturesSelectedFor;
    private Collection<Fixture> fixturesPlayedFor;

    public Player(int playerNumber, String name, String address, String email,
            String landline, String mobile, boolean captain,
            boolean wicketkeeper, PlayerClassification classification,
            Team teamPreference)
    {
        // numberOfPlayers++;
        // this.playerNumber = numberOfPlayers;
        this.playerNumber = playerNumber;
        this.name = name;
        this.address = address;
        this.email = email;
        this.landline = landline;
        this.mobile = mobile;
        this.playerSummary = new PlayerSummary(captain, wicketkeeper,
                classification, teamPreference);
        this.playerPerformance = new HashSet<PlayerPerformance>();
        this.wicketkeeperPerformance = new HashSet<WicketkeeperPerformance>();
        this.fixturesAvailableFor = new HashSet<Fixture>();
        this.fixturesSelectedFor = new HashSet<Fixture>();
        this.fixturesPlayedFor = new HashSet<Fixture>();
    }

    /**
     * @return the playerNumber
     */
    public int getPlayerNumber()
    {
        return playerNumber;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the landline
     */
    public String getLandline()
    {
        return landline;
    }

    /**
     * @param landline the landline to set
     */
    public void setLandline(String landline)
    {
        this.landline = landline;
    }

    /**
     * @return the mobile
     */
    public String getMobile()
    {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    /**
     * @return the playerSummary
     */
    public PlayerSummary getPlayerSummary()
    {
        return playerSummary;
    }

    /**
     * @param playerSummary the playerSummary to set
     */
    public void setPlayerSummary(PlayerSummary playerSummary)
    {
        this.playerSummary = playerSummary;
    }

    /**
     * @return the playerPerformance
     */
    public Collection<PlayerPerformance> getPlayerPerformance()
    {
        return playerPerformance;
    }

    /**
     * @param playerPerformance the playerPerformance to set
     */
    public void setPlayerPerformance(
            Collection<PlayerPerformance> playerPerformance)
    {
        this.playerPerformance = playerPerformance;
    }

    /**
     * @return the wicketkeeperPerformance
     */
    public Collection<WicketkeeperPerformance> getWicketkeeperPerformance()
    {
        return wicketkeeperPerformance;
    }

    /**
     * @param wicketkeeperPerformance the wicketkeeperPerformance to set
     */
    public void setWicketkeeperPerformance(
            Collection<WicketkeeperPerformance> wicketkeeperPerformance)
    {
        this.wicketkeeperPerformance = wicketkeeperPerformance;
    }

    /**
     * @return the fixturesAvailableFor
     */
    public Collection<Fixture> getFixturesAvailableFor()
    {
        return fixturesAvailableFor;
    }

    /**
     * @param fixturesAvailableFor the fixturesAvailableFor to set
     */
    public void setFixturesAvailableFor(Collection<Fixture> fixturesAvailableFor)
    {
        this.fixturesAvailableFor = fixturesAvailableFor;
    }

    /**
     * @return the fixturesSelectedFor
     */
    public Collection<Fixture> getFixturesSelectedFor()
    {
        return fixturesSelectedFor;
    }

    /**
     * @param fixturesSelectedFor the fixturesSelectedFor to set
     */
    public void setFixturesSelectedFor(Collection<Fixture> fixturesSelectedFor)
    {
        this.fixturesSelectedFor = fixturesSelectedFor;
    }

    /**
     * @return the fixturesPlayedFor
     */
    public Collection<Fixture> getFixturesPlayedFor()
    {
        return fixturesPlayedFor;
    }

    /**
     * @param fixturesPlayedFor the fixturesPlayedFor to set
     */
    public void setFixturesPlayedFor(Collection<Fixture> fixturesPlayedFor)
    {
        this.fixturesPlayedFor = fixturesPlayedFor;
    }

    /**
     * Return summary details of this player for the toString method
     *
     * @return the String
     */
    @Override
    public String toString()
    {
        return this.playerNumber + " " + this.name + " "
                + this.playerSummary.getClassification()
                + " " + this.playerSummary.getTeamPreference();
    }

    /**
     * Return a String with various player details
     *
     * @return the String
     */
    public String toStringLong()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Player Number: " + this.playerNumber + "  ");
        sb.append("Player Name: " + this.name + "  ");
        sb.append(
                "Classification: " + this.playerSummary.getClassification() + "  ");
        sb.append(
                "Team Preference: " + this.playerSummary.getTeamPreference() + "  ");
        sb.append("\n");
        Collection<PlayerPerformance> playerPerformanceSet = new HashSet<PlayerPerformance>();
        playerPerformanceSet = this.getPlayerPerformance();
        Iterator<PlayerPerformance> setItP = playerPerformanceSet.iterator();
        while (setItP.hasNext())
        {
            PlayerPerformance playerPerformance = setItP.next();
            sb.append(
                    "Fixture Type: " + playerPerformance.getFixtureType() + "  ");
            sb.append("Team Type: " + playerPerformance.getTeam() + "  ");
            sb.append(
                    "Games Played: " + playerPerformance.getGamesPlayed() + "  ");
            BigDecimal bdARI = new BigDecimal(
                    playerPerformance.getAllRounderIndex()).setScale(
                    2, RoundingMode.HALF_EVEN);
            sb.append(
                    "All-rounder Index: " + bdARI + "  ");
            // sb.append(
            //        "Outfield Catches: " + playerPerformance.getNumberOfOutfieldCatches() + "  ");
            // sb.append("\n");
            BigDecimal bdBat = new BigDecimal(
                    playerPerformance.getBattingAverage()).setScale(
                    2, RoundingMode.HALF_EVEN);
            sb.append(
                    "Batting Average: " + bdBat + "  ");
            // sb.append(
            //       "Innings: " + playerPerformance.getNumberOfInnings() + "  ");
            // sb.append(
            //        "Not Outs: " + playerPerformance.getNumberOfNotOuts() + "  ");
            // sb.append("Runs: " + playerPerformance.getNumberOfRuns() + "  ");
            // sb.append("Ducks: " + playerPerformance.getNumberOfDucks() + "  ");
            // sb.append("\n");
            BigDecimal bdBowl = new BigDecimal(
                    playerPerformance.getBowlingAverage()).setScale(
                    2, RoundingMode.HALF_EVEN);
            sb.append(
                    "Bowling Average: " + bdBowl + "  ");
            // sb.append(
            //        "Wickets Taken: " + playerPerformance.getNumberOfWicketsTaken() + "  ");
            // sb.append(
            //        "Runs Conceded: " + playerPerformance.getNumberOfRunsConceded() + "  ");
            // sb.append("\n");
            Collection<WicketkeeperPerformance> wicketkeeperPerformanceSet = new HashSet<WicketkeeperPerformance>();
            wicketkeeperPerformanceSet = this.getWicketkeeperPerformance();
            Iterator<WicketkeeperPerformance> setItW = wicketkeeperPerformanceSet.iterator();
            while (setItW.hasNext())
            {
                WicketkeeperPerformance wicketkeeperPerformance = setItW.next();
                if (playerPerformance.getFixtureTypeAndTeamType().equals(
                        wicketkeeperPerformance.getFixtureTypeAndTeamType()))
                {
                    sb.append(
                            "Games Played As Keeper: " + wicketkeeperPerformance.getGamesPlayedAsKeeper() + "  ");
                    sb.append(
                            "Keeper Catches: " + wicketkeeperPerformance.getNumberOfKeeperCatches() + "  ");
                    sb.append(
                            "Stumpings: " + wicketkeeperPerformance.getNumberOfStumpings() + "  ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Add player performance information
     *
     * @param playerPerf - PlayerPerformance object
     *
     * @return whether or not it is added
     */
    public boolean addPlayerPerformance(PlayerPerformance playerPerf)
    {
        Iterator<PlayerPerformance> setIt = this.playerPerformance.iterator();

        while (setIt.hasNext())
        {
            if (setIt.next().getFixtureTypeAndTeamType().equals(
                    playerPerf.getFixtureTypeAndTeamType()))
            {
                javax.swing.JOptionPane pane = new javax.swing.JOptionPane();
                pane.showMessageDialog(null,
                        "Player performance stats for same fixture type and team provided more than once."
                        + "\n" + "Please check on View/Amend Player tab which set of stats has been used.",
                        "Player Performance Warning",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                // System.out.println(
                //        "Player performance for fixture type and team already exists!");
                return false;
            }
        }
        this.playerPerformance.add(playerPerf);
        return true;
    }

    /**
     * Add wicketkeeper performance information
     *
     * @param wicketkeeperPerf - WicketkeeperPerformance object
     *
     * @return whether or not it is added
     */
    public boolean addWicketkeeperPerformance(
            WicketkeeperPerformance wicketkeeperPerf)
    {
        Iterator<WicketkeeperPerformance> setIt = this.wicketkeeperPerformance.iterator();

        while (setIt.hasNext())
        {
            if (setIt.next().getFixtureTypeAndTeamType().equals(
                    wicketkeeperPerf.getFixtureTypeAndTeamType()))
            {
                javax.swing.JOptionPane pane = new javax.swing.JOptionPane();
                pane.showMessageDialog(null,
                        "Wicketkeeper performance stats for same fixture type and team provided more than once."
                        + "\n" + "Please check on View/Amend Player tab which set of stats has been used.",
                        "Wicketkeeper Performance Warning",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                // System.out.println(
                //        "Wicketkeeper performance for fixture type and team already exists!");
                return false;
            }
        }
        this.wicketkeeperPerformance.add(wicketkeeperPerf);
        return true;
    }

    /**
     * Add fixture available for
     *
     * @param fixture - the fixture for which the player is available
     *
     * @return whether or not it is added
     */
    public boolean addFixtureAvailableFor(Fixture fixture)
    {
        if (!(this.fixturesAvailableFor.contains(fixture)))
        {
            this.fixturesAvailableFor.add(fixture);
            if (!(fixture.getPlayersAvailableFor().contains(this)))
            {
                fixture.addPlayerAvailableFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete fixture available for
     *
     * @param fixture - the fixture for which the player is no longer available
     *
     * @return whether or not it is deleted
     */
    public boolean deleteFixtureAvailableFor(Fixture fixture)
    {
        if (this.fixturesAvailableFor.contains(fixture)
                && !(this.fixturesSelectedFor.contains(fixture)))
        {
            this.fixturesAvailableFor.remove(fixture);
            if (fixture.getPlayersAvailableFor().contains(this))
            {
                fixture.deletePlayerAvailableFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View fixtures available for
     *
     * @return the future fixtures for which the player is available
     */
    public Collection<Fixture> viewFixturesAvailableFor()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Integer year = calendar.get(calendar.YEAR);
        Integer month = calendar.get(calendar.MONTH);
        month = month + 1;
        String monthString = null;
        if (month < 10)
        {
            monthString = "0" + month;
        }
        else
        {
            monthString = month.toString();
        }
        Integer day = calendar.get(calendar.DAY_OF_MONTH);
        String dayString = null;
        if (day < 10)
        {
            dayString = "0" + day;
        }
        else
        {
            dayString = day.toString();
        }
        String dateString = year + monthString + dayString;
        Integer dateInt = Integer.parseInt(dateString);
        Collection<Fixture> fixtures = new HashSet<Fixture>();
        for (Fixture fixture : this.fixturesAvailableFor)
        {
            if (fixture.getDate() >= dateInt)
            {
                fixtures.add(fixture);
            }
        }
        return fixtures;
    }

    /**
     * Add fixture selected for
     *
     * @param fixture - the fixture for which the player is selected
     *
     * @return whether or not it is added
     */
    public boolean addFixtureSelectedFor(Fixture fixture)
    {
        if (this.fixturesAvailableFor.contains(fixture)
                && !(this.fixturesSelectedFor.contains(fixture)) // && (fixture.getPlayersSelectedFor().size() < 11)
                )
        {
            this.fixturesSelectedFor.add(fixture);
            if (!(fixture.getPlayersSelectedFor().contains(this)))
            {
                fixture.addPlayerSelectedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete fixture selected for
     *
     * @param fixture - the fixture for which the player is no longer selected
     *
     * @return whether or not it is deleted
     */
    public boolean deleteFixtureSelectedFor(Fixture fixture)
    {
        if (this.fixturesSelectedFor.contains(fixture)
                && !(this.fixturesPlayedFor.contains(fixture)))
        {
            this.fixturesSelectedFor.remove(fixture);
            if (fixture.getPlayersSelectedFor().contains(this))
            {
                fixture.deletePlayerSelectedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View fixtures selected for
     *
     * @return the future fixtures for which the player is selected
     */
    public Collection<Fixture> viewFixturesSelectedFor()
    {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Integer year = calendar.get(calendar.YEAR);
        Integer month = calendar.get(calendar.MONTH);
        month = month + 1;
        String monthString = null;
        if (month < 10)
        {
            monthString = "0" + month;
        }
        else
        {
            monthString = month.toString();
        }
        Integer day = calendar.get(calendar.DAY_OF_MONTH);
        String dayString = null;
        if (day < 10)
        {
            dayString = "0" + day;
        }
        else
        {
            dayString = day.toString();
        }
        String dateString = year + monthString + dayString;
        Integer dateInt = Integer.parseInt(dateString);
        Collection<Fixture> fixtures = new HashSet<Fixture>();
        for (Fixture fixture : this.fixturesSelectedFor)
        {
            if (fixture.getDate() >= dateInt)
            {
                fixtures.add(fixture);
            }
        }
        return fixtures;
    }

    /**
     * Add fixture played for
     *
     * @param fixture - the fixture for which the player played
     *
     * @return whether or not it is added
     */
    public boolean addFixturePlayedFor(Fixture fixture)
    {
        if (this.fixturesSelectedFor.contains(fixture)
                && !(this.fixturesPlayedFor.contains(fixture)) // && (fixture.getPlayersPlayedFor().size() < 11)
                )
        {
            this.fixturesPlayedFor.add(fixture);
            if (!(fixture.getPlayersPlayedFor().contains(this)))
            {
                fixture.addPlayerPlayedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * Delete fixture played for
     *
     * @param fixture - the fixture for which the player did not play
     *
     * @return whether or not it is deleted
     */
    public boolean deleteFixturePlayedFor(Fixture fixture)
    {
        if (this.fixturesPlayedFor.contains(fixture))
        {
            this.fixturesPlayedFor.remove(fixture);
            if (fixture.getPlayersPlayedFor().contains(this))
            {
                fixture.deletePlayerPlayedFor(this);
            }
            return true;
        }
        return false;
    }

    /**
     * View fixtures played for
     *
     * @return the fixtures for which the player played
     */
    public Collection<Fixture> viewFixturesPlayedFor()
    {
        return this.fixturesPlayedFor;
    }
}
