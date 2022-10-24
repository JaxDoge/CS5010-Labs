package Clothing;

import java.util.List;
import java.util.StringJoiner;

import static Clothing.ClothingType.FOOTWAER;

public class FootWear extends Clothing{
    private static final ClothingType clothingType = FOOTWAER;
    private final FootWearName clothingName;

    public FootWear(List<ClothingPrefix> cP, FootWearName footWearName, int defencePoint, int attackPoint) {
        super(cP);
        this.clothingName = footWearName;
        this.setDefencePoint(defencePoint);
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
