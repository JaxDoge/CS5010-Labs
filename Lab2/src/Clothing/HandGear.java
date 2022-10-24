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

    @Override
    public String getClothingName() {
        return this.clothingName.toString();
    }

}
