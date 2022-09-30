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
    public String getNickName() {
        return nickName;
    }
    public String sayHi() {
        return this.favSaying;
    }
    public static String getSpeciesName() {
        return speciesName;
    }
    public String[] getFavFood() {
        return favFood;
    }
    public static boolean isExtinction() {
        return extinction;
    }
    public static int getVocabulary() {
        return vocabulary;
    }
}
