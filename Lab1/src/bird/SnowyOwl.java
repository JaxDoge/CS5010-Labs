package bird;

public class SnowyOwl extends Owl {
    String nickName;
    /**
     * Common attributes for all birds in this species*/
    static String speciesName = "Snowy Owl";
    static boolean extinction = false;
    static String[] favFood = new String[] {"small mammals", "insects"};

    public SnowyOwl(String nickName) {
        this.nickName = nickName;
    }
}
