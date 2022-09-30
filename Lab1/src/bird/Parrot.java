package bird;

public class Parrot extends Bird{
    protected static String typeName = "Parrot";
    protected static String habitat = "Land";
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
