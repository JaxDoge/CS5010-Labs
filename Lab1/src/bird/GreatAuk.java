package bird;

public class GreatAuk extends Shorebird{
    String nickName;
    /**
     * Common attributes for all hawks*/
    static String speciesName = "GreatAuk";
    static boolean extinction = true;
    static String[] favFood = new String[] {"insects", "aquatic invertebrates"};
    static String waterBody = "Saltwater shorelands";

    public GreatAuk(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return this.nickName;
    }
    public static String getSpeciesName() {
        return speciesName;
    }
    public static String[] getFavFood() {
        return favFood;
    }
    public static boolean isExtinction() {
        return extinction;
    }

    public static String getWaterBody() {
        return waterBody;
    }
}
