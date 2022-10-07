package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Shorebird extends WaterBird {
    public Shorebird(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood, WaterBody waterBody) {
        super(waterBody);
        setTypeName(TypeName.SHOREBIRD);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Shorebirds include the great auk, horned puffin, and African Jacana",
                "They live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean."));
        setWingsNum(2);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new Great Auk.
     * */
    public Shorebird(String nickName) {
        super(WaterBody.FRESH_WATER_SOURCES);
        setTypeName(TypeName.SHOREBIRD);
        setNickName(nickName);
        setSpeciesName("GreatAuk");
        setExtinction(true);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Buds, 3);
        favFood.put(Food.Fish, 2);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Shorebirds include the great auk, horned puffin, and African Jacana",
                "They live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean."));
        setWingsNum(2);
    }
}
