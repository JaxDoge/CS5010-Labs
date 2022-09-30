package bird;

public class Waterfowl extends Bird{
    protected static String typeName = "Waterfowl";
    protected static String habitat = "Water";
    protected static int wings = 2;

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
