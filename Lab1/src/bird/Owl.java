package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Owls are distinguished by the facial disks that frame the eyes and bill.
 * */
public class Owl extends Bird {
    public Owl(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood) {
        setTypeName(TypeName.OWL);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Owls are distinguished by the facial disks that frame the eyes and bill"));
        setWingsNum(2);
        setWaterHabitat(false);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname of a new snowyowl
     */
    public Owl(String nickName) {
        setTypeName(TypeName.OWL);
        setNickName(nickName);
        setSpeciesName("SnowyOwl");
        setExtinction(false);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Nuts, 5);
        favFood.put(Food.Small_Mammals, 4);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Owls are distinguished by the facial disks that frame the eyes and bill"));
        setWingsNum(2);
        setWaterHabitat(false);
    }
}
