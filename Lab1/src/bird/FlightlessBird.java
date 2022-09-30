package bird;

public class FlightlessBird extends Bird{
    protected static String typeName = "Flightless Bird";
    protected static String habitat = "Land";
    protected static int wings = 0;

    public static String getTypeName() {
        return typeName;
    }
    public static String getHabitat() {
        return habitat;
    }
    public static int getWingNum() {
        return wings;
    }

}
