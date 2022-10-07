package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pigeon extends Bird {
    public Pigeon(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood) {
        setTypeName(TypeName.PIGEON);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Pigeons (or doves) are known for feeding their young \"bird milk\" very similar to the milk of mammals."));
        setWingsNum(2);
        setWaterHabitat(false);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new blueheadedquaildove
     */
    public Pigeon(String nickName) {
        setTypeName(TypeName.PIGEON);
        setNickName(nickName);
        setSpeciesName("BlueheadedQuaildove");
        setExtinction(false);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Insects, 3);
        favFood.put(Food.Seeds, 3);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Pigeons (or doves) are known for feeding their young \"bird milk\" very similar to the milk of mammals."));
        setWingsNum(2);
        setWaterHabitat(false);
    }
}
