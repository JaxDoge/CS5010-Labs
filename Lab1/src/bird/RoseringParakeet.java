package bird;

public class RoseringParakeet extends Parrot{

    String nickName;
    String favSaying;
    /**
     * Common attributes for all RoseringParakeet*/
    static String speciesName = "Rose-ringed parakeet";
    static boolean extinction = false;
    static String[] favFood = new String[] {"berries", "seeds"};
    static int vocabulary = 103;

    public RoseringParakeet(String nickName, String favSaying) {
        this.nickName = nickName;
        this.favSaying = favSaying;
    }
}
