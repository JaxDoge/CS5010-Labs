//package bird;
//
//import java.util.StringJoiner;
//
//public class Hawk extends PreyBird{
//    String nickName;
//    /**
//     * Common attributes for all hawks*/
//    static String speciesName = "Hawk";
//    static String[] favFood = new String[] {"fish", " small mammals"};
//
//    public Hawk(String nickName) {
//        this.nickName = nickName;
//    }
//
//    public String getNickName() {
//        return this.nickName;
//    }
//    public static String getSpeciesName() {
//        return speciesName;
//    }
//    public static String[] getFavFood() {
//        return favFood;
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
