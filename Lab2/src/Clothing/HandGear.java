package Clothing;

import java.util.List;
import java.util.StringJoiner;

import static Clothing.ClothingType.HAND_GEAR;

public class HandGear extends Clothing{
    private static final ClothingType clothingType = HAND_GEAR;
    private final HandGearName clothingName;

    public HandGear(List<ClothingPrefix> cP, HandGearName handGearName, int attackPoint) {
        super(cP);
        this.clothingName = handGearName;
        this.setAttackPoint(attackPoint);
    }
    @Override
    public ClothingType getClothingType() {
        return clothingType;
    }

    public HandGearName getClothingName() {
        return this.clothingName;
    }


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
