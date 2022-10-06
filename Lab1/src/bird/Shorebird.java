package bird;

public class Shorebird extends Birdable {
    static String typeName = "Shorebird";
    static String habitat = "Water";
    static int wings = 2;

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
