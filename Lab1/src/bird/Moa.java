package bird;

import java.util.StringJoiner;

public class Moa extends FlightlessBird{
    String nickName;
    /**
     * Common attributes for all birds in this species*/
    static String speciesName = "Moa";
    static String[] favFood = new String[] {"fruit", "vegetation"};

    public Moa(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
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

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(":");
        sj.add(typeName);
        sj.add(speciesName);
        sj.add(this.nickName);
        return sj.toString();
    }
}
