package bird;

public class Hawk extends PreyBird{
    String nickName;
    /**
     * Common attributes for all hawks*/
    static String speciesName = "Hawk";
    static boolean extinction = false;
    static String[] favFood = new String[] {"fish", " small mammals"};

    public Hawk(String nickName) {
        this.nickName = nickName;
    }

}
