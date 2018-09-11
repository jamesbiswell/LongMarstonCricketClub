package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.util.*;
import java.io.*;

public class CricketClub implements Serializable
{

    // TODO change collections back to private when Main lmcc print statements not referencing them directly
    public HashMap<Integer, Player> players;
    public HashMap<Integer, Fixture> fixtures;

    private CricketClub()
    {
        this.players = new HashMap<Integer, Player>();
        this.fixtures = new HashMap<Integer, Fixture>();
    }

    public static CricketClub getInstance()
    {
        return CricketClubHolder.INSTANCE;
    }

    private static class CricketClubHolder
    {

        private static final CricketClub INSTANCE = new CricketClub();
    }

    /**
     * Add a player to the system
     *
     * @param name - name of player
     * @param address - home address of player
     * @param email - email address of player
     * @param landline - landline number of player
     * @param mobile - mobile number of player
     * @param captain - whether or not the player can act as captain
     * @param wicketkeeper - whether or not the player can act as wicketkeeper
     * @param classification - the classification of player (batsman, bowler etc.)
     * @param teamPreference - the team (1st XI or 2nd XI) for which the player prefers to play
     * @param playerPerformance - PlayerPerformance object
     * @param wicketkeeperPerformance - WicketkeeperPerformance object
     */
    public void addPlayer(String name, String address, String email,
            String landline, String mobile, boolean captain,
            boolean wicketkeeper, PlayerClassification classification,
            Team teamPreference, Collection<PlayerPerformance> playerPerformance,
            Collection<WicketkeeperPerformance> wicketkeeperPerformance)
    {
        Player player = new Player(name, address, email, landline, mobile,
                captain, wicketkeeper, classification, teamPreference);

        Iterator<PlayerPerformance> setIte = playerPerformance.iterator();
        while (setIte.hasNext())
        {
            player.addPlayerPerformance(setIte.next());
        }

        Iterator<WicketkeeperPerformance> setIt = wicketkeeperPerformance.iterator();
        while (setIt.hasNext())
        {
            player.addWicketkeeperPerformance(setIt.next());
        }

        this.players.put(player.getPlayerNumber(), player);
    }

    /**
     * Amend a player on the system
     *
     * @param playerNumber - number of player
     * @param name - name of player
     * @param address - home address of player
     * @param email - email address of player
     * @param landline - landline number of player
     * @param mobile - mobile number of player
     * @param playerSummary - PlayerSummary object
     * @param playerPerformance - PlayerPerformance object
     * @param wicketkeeperPerformance - WicketkeeperPerformance object
     */
    public void amendPlayer(int playerNumber, String name, String address,
            String email,
            String landline, String mobile, PlayerSummary playerSummary,
            Collection<PlayerPerformance> playerPerformance,
            Collection<WicketkeeperPerformance> wicketkeeperPerformance)
    {
        Player player = this.players.get(playerNumber);
        player.setName(name);
        player.setAddress(address);
        player.setEmail(email);
        player.setLandline(landline);
        player.setMobile(mobile);
        player.setPlayerSummary(playerSummary);

        Collection<PlayerPerformance> pp = new HashSet<PlayerPerformance>();
        player.setPlayerPerformance(pp);
        Iterator<PlayerPerformance> setIte = playerPerformance.iterator();
        while (setIte.hasNext())
        {
            player.addPlayerPerformance(setIte.next());
        }

        Collection<WicketkeeperPerformance> wkp = new HashSet<WicketkeeperPerformance>();
        player.setWicketkeeperPerformance(wkp);
        Iterator<WicketkeeperPerformance> setIt = wicketkeeperPerformance.iterator();
        while (setIt.hasNext())
        {
            player.addWicketkeeperPerformance(setIt.next());
        }
        this.players.put(player.getPlayerNumber(), player);
    }

    /**
     * Delete a player from the system
     *
     * @param player - the player object to be removed
     *
     * @return - whether or not the player is removed
     */
    public void deletePlayer(int playerNumber)
    {
        for (Player play : this.players.values())
        {
            if (play.getPlayerNumber() == playerNumber)
            {
                this.players.remove(playerNumber);
            }
        }
    }

    /**
     * View player list on the system
     *
     * @return - a hash map of the players
     */
    public Map<Integer, Player> viewPlayerList()
    {
        return this.players;
    }

    /**
     * View a player on the system
     *
     * @return - a Player object (chosen by playerNumber)
     */
    public Player viewPlayer(int playerNumber)
    {
        return this.players.get(playerNumber);
    }

    /**
     * Add a fixture to the system
     *
     * @param fixtureType - type of fixture (i.e. league, evening cup etc.)
     * @param team - for which team (i.e. 1st XI or 2nd XI) it is a fixture
     * @param date - date of fixture
     * @param postcodeLocation - postcode of location where fixture is played
     * @param opposition - against whom the fixture is being played
     *
     * @return whether the fixture is added
     */
    public boolean addFixture(FixtureType fixtureType, Team team,
            int date, String postcodeLocation, String opposition)
    {

        for (Fixture fixt : this.fixtures.values())
        {
            if (fixt.getTeam().equals(team)
                    && (fixt.getDate() == date))
            {
                System.out.println("Fixture already exists!");
                return false;
            }
        }
        Fixture fixture = new Fixture(fixtureType, team, date,
                postcodeLocation,
                opposition);
        this.fixtures.put(fixture.getFixtureNumber(), fixture);
        return true;
    }

    /**
     * Amend a fixture on the system
     * 
     * TODO amend fixture code
     */
    public void amendFixture(Fixture fixture)
    {
    }

    /**
     * Delete a fixture from the system
     *
     * @param fixture - the fixture object to be removed
     * 
     * @return - whether or not the fixture is removed
     */
    public void deleteFixture(Fixture fixture)
    {
        for (Fixture fixt : this.fixtures.values())
        {
            if (fixt.equals(fixture))
            {
                this.fixtures.remove(fixture.getFixtureNumber());
            }
        }
    }

    /**
     * View fixture list
     *
     * @return - a hash map of the fixtures
     */
    public Map<Integer, Fixture> viewFixtureList()
    {
        return this.fixtures;
    }

    /**
     * View a fixture on the system
     *
     * @return - a Fixture object (chosen by fixtureNumber)
     */
    public Fixture viewFixture(int fixtureNumber)
    {
        return this.fixtures.get(fixtureNumber);
    }

    /**
     * Add fixture results on the system
     *
     * TODO add fixture results code
     */
    public void addFixtureResults(Fixture fixture)
    {
    }
}
