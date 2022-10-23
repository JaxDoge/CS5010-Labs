package Clothing;

import java.util.List;
import java.util.StringJoiner;

import static Clothing.ClothingType.HEAD_GEAR;

public class HeadGear extends Clothing{

    private static final ClothingType clothingType = HEAD_GEAR;
    private final HeadGearName clothingName;

    /**
     * Clothing constructor could define how to set clothingPrefix. But other attributes have to left to constructors of subclasses
     *
     * @param cP input clothing prefix
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    public HeadGear(List<ClothingPrefix> cP, HeadGearName headGearName, int defencePoint) {
        super(cP);
        this.clothingName = headGearName;
        this.setDefencePoint(defencePoint);
    }

    /**
     * Get the ClothingType of this clothing,
     * Implement abstract method.
     * @return ClothingType: the clothing type.
     */
    @Override
    public ClothingType getClothingType() {
        return clothingType;
    }

    /**
     * Get the ClothingName of this clothing,
     * @return HeadGearName: the clothing name.
     */
    public HeadGearName getClothingName() {
        return this.clothingName;
    }

    /**
     * Print this object with basic info in a string.
     * @return String prefix properties + name + combination level
     * */
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ");
        for (ClothingPrefix cp : this.getClothingPrefix()) {
            sj.add(cp.toString());
        }
        sj.add(this.getClothingName().toString());
        return sj + " CombineLevel: " + this.getComblvl();
    }
}
