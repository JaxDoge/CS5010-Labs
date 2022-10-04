package bird;

import java.util.StringJoiner;

public class SnowyOwl extends Owl {
    String nickName;
    /**
     * Common attributes for all birds in this species*/
    static String speciesName = "Snowy Owl";
    static String[] favFood = new String[] {"small mammals", "insects"};

    public SnowyOwl(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
    }
    public static String getSpeciesName() {
        return speciesName;
    }
    public String[] getFavFood() {
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
