package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Waterfowl extends WaterBird {
    public Waterfowl(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood, WaterBody waterBody) {
        super(waterBody);
        setTypeName(TypeName.WATERFOWL);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Waterfowl are another classification that live near water sources (fresh or salt)","Placeholder"));
        setWingsNum(2);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new swan.
     * */
    public Waterfowl(String nickName) {
        super(WaterBody.FRESH_WATER_SOURCES);
        setTypeName(TypeName.WATERFOWL);
        setNickName(nickName);
        setSpeciesName("Swan");
        setExtinction(false);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Aquatic_Invertebrates, 2);
        favFood.put(Food.Insects, 1);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Waterfowl are another classification that live near water sources (fresh or salt)", "Placeholder"));
        setWingsNum(2);
    }


}
