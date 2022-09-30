package bird;

public class PreyBird extends Bird {
    protected static String typeName = "Bird of Prey";
    protected static String beakShape = "Sharp, hooked beaks with visible nostrils";
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

    public static String getBeakShape() {
        return beakShape;
    }
}