package bird;

public class Swan extends Waterfowl{
    String nickName;
    /**
     * Common attributes for all hawks*/
    static String speciesName = "Swan";
    static boolean extinction = false;
    static String[] favFood = new String[] {"insects", "berries"};
    static String waterBody = "Fresh water lake";

    public Swan(String nickName) {
        this.nickName = nickName;
    }
}
