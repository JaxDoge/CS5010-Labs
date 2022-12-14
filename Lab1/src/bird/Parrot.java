package bird;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Parrots have a short, curved beak and are known for their intelligence and ability to mimic sounds.
 * Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single "favorite" saying.
 * They include the rose-ring parakeet, gray parrot, and sulfur-crested cockatoo.
 * Parrot object could define special vocabulary "words".
 * And it possesses special "favSaying" which could be output.
 * */
public class Parrot extends Bird {

    protected String favSaying;
    protected int words;
    public Parrot(String nickName, String speciesName, boolean extinction, Map<Food, Integer> favFood,
                  int words, String favSaying) {
        setTypeName(TypeName.PARROT);
        setNickName(nickName);
        setSpeciesName(speciesName);
        setExtinction(extinction);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Parrots have a short, curved beak and are known for their intelligence and ability to mimic sounds",
                "Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single favorite saying."));
        setWingsNum(2);
        setWaterHabitat(false);
        setWords(words);
        setFavSaying(favSaying);
    }

    /**
     * For the sake of convenience, this constructor only need the nickname and favorite saying of a new RoseringParakeet
     */
    public Parrot(String nickName, String favSaying) {
        setTypeName(TypeName.PARROT);
        setNickName(nickName);
        setSpeciesName("RoseringParakeet");
        setExtinction(false);
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Vegetation, 1);
        favFood.put(Food.Nuts, 2);
        setFavFood(favFood);
        setCharacteristic(Arrays.asList("Parrots have a short, curved beak and are known for their intelligence and ability to mimic sounds",
                "Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single favorite saying."));
        setWingsNum(2);
        setWaterHabitat(false);
        setWords(103);
        setFavSaying(favSaying);
    }

    public Parrot() {
        setTypeName(TypeName.PARROT);
    }

    /**
     * set this parrot words.
     * word int: input word
     * Throw exception if the input is a negative number.
     * */
    public void setWords(int words) {
        if (words <= 0) {
            throw new IllegalArgumentException("Parrot's words cannot be negative");
        }
        this.words = words;
    }

    /**
     * Get word
     * Return int: current words
     * */
    public int getWords() {
        return this.words;
    }

    /**
     * Set parrot favorite saying
     * favSaying String: input favorite saying
     * throw exception if the input string is empty or exceed 240 characters
     * */
    public void setFavSaying(@NotNull String favSaying) {
        if (favSaying.length() == 0) {
            throw new IllegalArgumentException("The favorite saying is empty");
        } else if (favSaying.length() > 240) {
            throw new IllegalArgumentException("The favorite saying is longer than 240 characters");
        }
        this.favSaying = favSaying;
    }

    /**
     * Get parrot's favorite saying
     * Return String:
     * */
    public String getFavSaying() {
        return this.favSaying;
    }

}
