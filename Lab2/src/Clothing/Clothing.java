package Clothing;

import java.util.List;
import java.util.StringJoiner;


/**
 * Abstract parent Clothing class.
 * It defines most common properties and behaviors of clothing objects and child objects
 * */
public abstract class Clothing implements Clothingable{

    protected List<ClothingPrefix> clothingPrefix;
    protected int defencePoint;
    protected int attackPoint;
    protected int combLevel = 0;

    /**
     * Clothing constructor could define how to set clothingPrefix. But other attributes have to left to constructors of subclasses
     * @param cP input clothing prefix
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     * */
    public Clothing(List<ClothingPrefix> cP) {
        this.clothingPrefix = cP;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * @param   other the object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     *          is less than, equal to, or greater than the specified object.
     *
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this object.
     * */
    @Override
    public int compareTo(Clothing other) throws NullPointerException, ClassCastException {
        if (this.attackPoint == other.attackPoint) {
            return other.defencePoint - this.defencePoint;
        }
        return other.attackPoint - this.attackPoint;
    }

    /**
     * set the defence point of this clothing
     * @param defencePoint: the input defence point
     */
    protected void setDefencePoint(int defencePoint) {
        if (defencePoint < 0) {
            throw new IllegalArgumentException("Negative defence point");
        }
        this.defencePoint = defencePoint;
    }

    /**
     * set the attack point of this clothing
     * @param attackPoint: the input attack point
     */
    protected void setAttackPoint(int attackPoint) {
        if (attackPoint < 0) {
            throw new IllegalArgumentException("Negative attack point");
        }
        this.attackPoint = attackPoint;
    }

    /**
     * Increase combination level by one
     * Protected helper function.
     * */
    protected void increaseCombLvl() {
        this.combLevel += 1;
    }


    /**
     * Get the defence point of this clothing
     * @return int: the defence point
     */
    @Override
    public int getDefence() {
        return this.defencePoint;
    }

    /**
     * Get the attack point of this clothing
     * @return int: the attack point
     */
    @Override
    public int getAttack() {
        return this.attackPoint;
    }

    /**
     * Get the combine level of this clothing, initially this should be zero
     *
     * @return int: the combine level
     */
    @Override
    public int getComblvl() {
        return this.combLevel;
    }

    /**
     * Get the ClothingType of this clothing,
     * Implement in subclass.
     * @return ClothingType: the clothing type.
     */
    @Override
    public abstract ClothingType getClothingType();

    /**
     * Get the ClothingPrefix of this clothing,
     *
     * @return ClothingPrefix: the clothing prefix.
     */
    @Override
    public List<ClothingPrefix> getClothingPrefix() {
        return this.clothingPrefix;
    }

    /**
     * This method combines this Clothing object with other Clothing object,
     * Note that we do not know the Clothing names here, but that actually does not matter because it would not be affected.
     * While combining, the attack point and defence point of this clothing will be added by other's statics.
     * The prefix string list will be concatenated.
     * The clothing name will keep.
     * @param otherClothes : other clothes
     * @return Clothing: A new Clothing object after combination.
     */
    @Override
    public Clothing combTo(Clothing otherClothes) throws IllegalArgumentException, ClassCastException, NullPointerException {
        if (!this.equalClothingType(otherClothes)) {
            throw new IllegalArgumentException("These two clothing are not belong to the same type. Combining failure");
        }
        if (otherClothes == this) {
            throw new IllegalArgumentException("Clothing cannot combine with itself. Combining failure");
        }
        // this clothing prefix comes first
        this.clothingPrefix.addAll(otherClothes.clothingPrefix);
        // update other's prefix
        otherClothes.clothingPrefix = this.clothingPrefix;
        // update statics
        otherClothes.setDefencePoint(this.getDefence() + otherClothes.getDefence());
        otherClothes.setAttackPoint(this.getAttack() + otherClothes.getAttack());
        // update combination level
        otherClothes.increaseCombLvl();
        // return other clothing, with same clothes' name
        return otherClothes;
    }

    /**
     *
     * */

    /**
     * This method judges if this Clothing object share the same ClothingType with other Clothing object,
     *
     * @param otherClothes : other clothes
     * @return Boolean: equal type or not.
     */
    protected boolean equalClothingType(Clothing otherClothes) {
        // Well, professor said we should avoid using member variable to distinguish different gear types. @185
        // Don't understand why, but ...
//        return this.getClothingType().equals(otherClothes.getClothingType());
        return this.getClass().getSimpleName().equals(otherClothes.getClass().getSimpleName());
    }

    /**
     * Protect abstract method to deliver subclasses clothing name to parent clothing class
     * @return String clothing name.
     * */
    protected abstract String getClothingName();

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
        return sj + " " + this.getClothingName() + " CombineLevel: " + this.getComblvl();
    }
}
