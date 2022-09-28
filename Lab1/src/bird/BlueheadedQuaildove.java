package bird;

public class BlueheadedQuaildove extends Pigeon{
    String nickName;
    /**
     * Common attributes for all birds in this species*/
    static String speciesName = "Blue-headed quail-dove";
    static boolean extinction = false;
    static String[] favFood = new String[] {"buds", "larvae"};

    public BlueheadedQuaildove(String nickName) {
        this.nickName = nickName;
    }
}
