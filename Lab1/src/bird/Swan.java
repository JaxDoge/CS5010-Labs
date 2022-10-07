//package bird;
//
//import java.util.StringJoiner;
//
//public class Swan extends Waterfowl{
//    String nickName;
//    /**
//     * Common attributes for all hawks*/
//    static String speciesName = "Swan";
//    static String[] favFood = new String[] {"insects", "berries"};
//    static String waterBody = "Fresh water lake";
//
//    public Swan(String nickName) {
//        this.nickName = nickName;
//    }
//    public String getNickName() {
//        return nickName;
//    }
//    public static String getSpeciesName() {
//        return speciesName;
//    }
//    public String[] getFavFood() {
//        return favFood;
//    }
//
//    public static String getWaterBody() {
//        return waterBody;
//    }
//
//    @Override
//    public String toString() {
//        StringJoiner sj = new StringJoiner(":");
//        sj.add(typeName);
//        sj.add(speciesName);
//        sj.add(this.nickName);
//        return sj.toString();
//    }
//}
