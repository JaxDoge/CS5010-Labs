package bird;

import java.util.StringJoiner;

public class GreatAuk extends Shorebird{
    String nickName;
    /**
     * Common attributes for all hawks*/
    static String speciesName = "GreatAuk";
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

    @Override
    public boolean isExtinction() {
        return true;
    }

    public static String getWaterBody() {
        return waterBody;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(":");
        sj.add(typeName);
        sj.add(speciesName);
        sj.add(this.nickName);
        return sj.toString();
    }
}
