package lmccprojectbusinesslayerseconditeration;

/**
 *
 * @author james biswell Y3258789
 * @version 2.00 06/08/2017
 */
import java.io.*;

public enum Result implements Serializable
{

    TO_BE_DETERMINED("To be determined"),
    SIX_POINT_WIN("Six point win"),
    FIVE_POINT_WIN("Five point win"),
    ONE_POINT_LOSS("One point loss"),
    NO_POINTS_LOSS("No points loss"),
    THREE_POINT_TIE("Three point tie"),
    CUP_WIN("Cup win"),
    CUP_LOSS("Cup loss"),
    ABANDONED_BEFORE_STARTING("Abandoned before starting"),
    ABANDONED_AFTER_STARTING("Abandoned after starting"),
    CONCESSION_LONG_MARSTON("Concession by Long Marston"),
    CONCESSION_OPPOSITION("Concession by opposition");
    private final String result;

    Result(String theResult)
    {
        result = theResult;
    }

    public String getResult()
    {
        return result;
    }
}
