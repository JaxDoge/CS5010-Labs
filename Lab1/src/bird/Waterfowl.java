package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Waterfowl extends WaterBird {
    public Waterfowl(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood, WaterBody waterBody) {
        setTypeName(TypeName.WATERFOWL);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Waterfowl are another classification that live near water sources (fresh or salt)","Placeholder"));
        setWingsNum(2);
        setWaterBody(waterBody);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new swan.
     * */
    public Waterfowl(String nickName) {
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
        setWaterBody(WaterBody.FRESH_WATER_SOURCES);
    }


    public Waterfowl() {
        setTypeName(TypeName.WATERFOWL);
    }

    @Override
    public void setWaterBody(WaterBody waterBody) {
        if (waterBody == WaterBody.FRESH_WATER_SOURCES || waterBody == WaterBody.SALT_WATER_SOURCES) {
            this.waterBody = waterBody;
            return;
        }
        throw new IllegalArgumentException("Not a suitable water body type for Waterfowl");
    }
}
