package bird;

public class Moa extends FlightlessBird{
    String nickName;
    /**
     * Common attributes for all all birds in this species*/
    static String speciesName = "Moa";
    static boolean extinction = true;
    static String[] favFood = new String[] {"fruit", "vegetation"};

    public Moa(String nickName) {
        this.nickName = nickName;
    }
}
