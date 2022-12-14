package Clothing;

import java.util.List;

/**
 * This interface define all public method that a Clothing object (or subclass object) need possess.
 * All Clothingable object should be comparable.
 * */
public interface Clothingable extends Comparable<Clothing>{

    /**
     * Get the defence point of this clothing
     * @return int: the defence point
     * */
    int getDefence();

    /**
     * Get the attack point of this clothing
     * @return int: the attack point
     * */
    int getAttack();

    /**
     * Get the combine level of this clothing, initially this should be zero
     * @return int: the combine level
     * */
    int getComblvl();

    /**
     * Get the ClothingType of this clothing,
     * @return ClothingType: the clothing type.
     * */
    ClothingType getClothingType();

    /**
     * Get the ClothingPrefix of this clothing,
     * @return ClothingPrefix: the clothing prefix.
     * */
    List<ClothingPrefix> getClothingPrefix();

    /**
     * This method combines this Clothing object with other Clothing object,
     * @param otherClothes: other clothes
     * @return Clothing: A new Clothing object after combination.
     * */
    Clothing combTo(Clothing otherClothes);
}
