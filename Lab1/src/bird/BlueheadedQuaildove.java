package bird;

import java.util.StringJoiner;

public class BlueheadedQuaildove extends Pigeon{
    String nickName;
    /**
     * Common attributes for all birds in this species*/
    static String speciesName = "Blue-headed quail-dove";
    static String[] favFood = new String[] {"buds", "larvae"};

    public BlueheadedQuaildove(String nickName) {
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
    public String toString() {
        StringJoiner sj = new StringJoiner(":");
        sj.add(typeName);
        sj.add(speciesName);
        sj.add(this.nickName);
        return sj.toString();
    }
}
