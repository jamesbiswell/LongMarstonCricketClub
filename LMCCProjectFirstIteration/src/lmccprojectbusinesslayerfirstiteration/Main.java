package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.util.*;
import lmccprojectuserinterfacefirstiteration.UserInterface;

public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        CricketClub lmcc = CricketClub.getInstance();
        UserInterface.run(lmcc);
        lmcc.addFixture(FixtureType.LEAGUE, Team.FIRSTXI, 20170605,
                "LS8 1AA", "Sri Lanka");
        lmcc.addFixture(FixtureType.LEAGUE, Team.SECONDXI, 20170604,
                "LS8 1AA", "Australia");
        lmcc.addFixture(FixtureType.LEAGUE, Team.FIRSTXI, 20170603,
                "LS8 1AA", "India");
        System.out.println(lmcc.fixtures.toString());
        System.out.println(lmcc.players.toString());
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
        for (Fixture fixture : lmcc.fixtures.values())
        {
            if (fixture.getDate() >= dateInt)
            {
                fixtures.add(fixture);
            }
        }
        System.out.println(dateInt.toString());
        System.out.println(fixtures.toString());
    }
}
