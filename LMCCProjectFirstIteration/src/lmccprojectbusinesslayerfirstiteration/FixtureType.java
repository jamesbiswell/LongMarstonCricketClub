package lmccprojectbusinesslayerfirstiteration;

/**
 *
 * @author james biswell Y3258789
 * @version 1.00 19/05/2017
 */
import java.io.*;

public enum FixtureType implements Serializable
{

    LEAGUE("League"),
    EVENING_CUP("Evening Cup"),
    SUNDAY_CUP("Sunday Cup");
    private final String fixtureType;

    FixtureType(String type)
    {
        fixtureType = type;
    }

    public String getFixtureType()
    {
        return fixtureType;
    }
}
