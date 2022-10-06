package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreyBird extends Bird {

    public PreyBird(String nickName, String speciesName, boolean extinction) {
        setNickName(nickName);
        setSpeciesName(speciesName);
        setTypeName(TypeName.PREY_BIRD);
        setExtinction(extinction);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Other_Birds, 5);
        favFood.put(Food.Small_Mammals, 2);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("have sharp, hooked beaks", "visible nostrils"));
        setWingsNum(2);
        setWaterHabitat(false);
    }

    public PreyBird(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood) {
        setNickName(nickName);
        setSpeciesName(speciesName);
        setTypeName(TypeName.PREY_BIRD);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("have sharp, hooked beaks", "visible nostrils"));
        setWingsNum(2);
        setWaterHabitat(false);
    }
}