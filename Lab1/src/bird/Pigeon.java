package bird;

public class Pigeon extends Bird{
    protected static String typeName = "Pigeon";
    protected static String habitat = "Land";
    protected static int wings = 2;
    protected static String babyFeed = "Bird milk";

    public static String getTypeName() {
        return typeName;
    }
    public static String getHabitat() {
        return habitat;
    }
    public static int getWingNum() {
        return wings;
    }

    public static String getBabyFeed() {
        return babyFeed;
    }
}
