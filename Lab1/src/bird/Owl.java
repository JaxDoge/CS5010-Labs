package bird;

public class Owl extends Bird {
    protected static String typeName = "Owl";
    protected static String facialShape = "A disks that frame the eyes and bill";
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

    public static String getFacialShape() {
        return facialShape;
    }
}
