package bird;

import java.util.List;
import java.util.Map;

/**
 * Technically there should be parent class of Bird class
 * But We do not have
 * So just record several attributes by hard coding*/
public interface Birdable {
    /**
     * Common birds' attributes
     * No need initialize later
     * Shared by every bird species*/
    ThmRg bloodtemp = ThmRg.Warmblooded;
    Loco locomotion = Loco.Bipedal;
    AniType animaltype = AniType.Vertebrate;
    ForeLb forelimb = ForeLb.Wings;
    ExCover exteriorcover = ExCover.Feathers;
    EatStr eatingstructure = EatStr.Beak;

    /**
     * */
    void setExtinction(boolean extFlag);
    boolean isExtinction();
    void setNickName(String nickName);
    String getNickName();
    void setSpeciesName(String speciesName);
    String getSpeciesName();
    void setTypeName(TypeName typeName);
    TypeName getTypeName();
    void setCharacteristic(List<String> characteristic);
    List<String> getCharacteristic();
    void setWingsNum(int wings);
    int getWingsNum();
    void setFavFood(Map<Food, Integer> favFood);
    Map<Food, Integer> getFavFood();
    int getFavFoodPortion(Food food);
    void setWaterHabitat(boolean waterFlag);
    boolean getWaterHabitat();
    AviaryDemand getAviaryDemand(TypeName typeName);
    AviaryDemand getAviaryDemand();

    /**
     * Check if the species name of this bird is valid for this type
     * Example if user wanna create a bird: Bird bird1 = new FlightlessBird("Monica","Moa") is legal
     * but new FlightlessBird("Monica","Chicken") cannot pass this check
     * neither can new FlightlessBird("Monica","Hawk")
     * because Chicken and Hawk are not FlightlessBird
     * */
    boolean checkTypeBelong(String speciesName);


}
