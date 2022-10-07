package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlightlessBird extends Bird {
    public FlightlessBird(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood) {
        setTypeName(TypeName.FLIGHTLESS_BIRD);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Flightless birds live on the ground and have no (or undeveloped) wings"));
        setWingsNum(0);
        setWaterHabitat(false);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new moa
     */
    public FlightlessBird(String nickName) {
        setTypeName(TypeName.FLIGHTLESS_BIRD);
        setNickName(nickName);
        setSpeciesName("Moa");
        setExtinction(true);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Insects, 5);
        favFood.put(Food.Berries, 4);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Flightless birds live on the ground and have no (or undeveloped) wings"));
        setWingsNum(0);
        setWaterHabitat(false);
    }
}