package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PreyBird extends Bird {

    public PreyBird(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood) {
        setTypeName(TypeName.PREYBIRD);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("have sharp, hooked beaks", "visible nostrils"));
        setWingsNum(2);
        setWaterHabitat(false);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new hawk
     * */
    public PreyBird(String nickName) {
        setTypeName(TypeName.PREYBIRD);
        setNickName(nickName);
        setSpeciesName("Hawk");
        setExtinction(false);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Other_Birds, 5);
        favFood.put(Food.Small_Mammals, 2);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("have sharp, hooked beaks", "visible nostrils"));
        setWingsNum(2);
        setWaterHabitat(false);
    }
}