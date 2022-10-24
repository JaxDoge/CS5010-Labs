package Player;

import Clothing.*;

import java.util.*;

public class Player implements Playerable{
    private static int globalID;
    private final int playerID;

    private final HeadGear[] headGear;
    private final HandGear[] handGears;
    private final FootWear[] footWears;
    private int defencePoint;
    private int attackPoint;
    private int gearNum;

    public Player () {
        playerID = globalID;
        globalID += 1;
        headGear = new HeadGear[1];
        handGears = new HandGear[2];
        footWears = new FootWear[2];
    }


    /**
     * Compare two players.
     * If this player takes more damage, return a negative integer.
     * If they take the same damage, return ZERO.
     * Otherwise, return a positive integer
     * @return Integer the deduction of this damage and other damage
     * */
    @Override
    public int compareTo(Player o) {
        int thisDamage = o.attackPoint - this.defencePoint;
        int otherDamage = this.attackPoint - o.defencePoint;
        return thisDamage - otherDamage;
    }

    /**
     * A comparator to sort gears by comblvl in ascending order
     * */
    static class comblvlComparator implements Comparator<Clothing> {

        /**
         * Compare two gears.
         * If first gear has lower comb level, return a negative integer.
         * If second gear has lower comb level, return a positive integer.
         * Otherwise, return ZERO.
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         *         first argument is less than, equal to, or greater than the
         *         second.
         * @throws NullPointerException if an argument is null and this
         *         comparator does not permit null arguments
         * @throws ClassCastException if the arguments' types prevent them from
         *         being compared by this comparator.
         * */
        @Override
        public int compare(Clothing o1, Clothing o2) {
            return o1.getComblvl() - o2.getComblvl();
        }
    }

    /**
     * For each turn, this player pick up one gear based on the given spec.
     * After picking up, the chosen clothing will be removed from bank and add to player's slot.
     * The clothing bank is not empty when calling this function.
     * */
    @Override
    public void pickup(ClothingBank clothingBank) {
        // Case 1, check if there is an empty slot for current candidate.
        for (Clothing clothing : clothingBank) {
            // Determine the position of this candidate gear.
            Clothing[] targetPosition = pickupInsertPosition(clothing);
            // Find an empty slot.
            for (int i = 0; i < targetPosition.length; i++) {
                if (targetPosition[i] == null) {
                    targetPosition[i] = clothing;
                    // Update player statics
                    this.updateStatic(clothing);
                    // Delete this clothing from bank
                    clothingBank.deleteClothing(clothing);
                    // Increment gear number of this player by 1
                    this.gearNum += 1;
                    return;
                }
            }
        }

        // Case 2, there is no empty slot for this clothing, so find the equipped gear with the lowest combination level
        // to combine. The first slot always contain the lowest combination level gear.
        // this for loop is unnecessary, but create an iterator is the only way to access stock clothes.
        for (Clothing clothing : clothingBank) {
            Clothing[] targetPosition = pickupInsertPosition(clothing);
            targetPosition[0] = targetPosition[0].combTo(clothing);
            // Update player statics
            this.updateStatic(clothing);
            // Delete this clothing from bank
            clothingBank.deleteClothing(clothing);
            // sort for next round
            Arrays.sort(targetPosition, new comblvlComparator());
            return;
        }
    }

    /**
     * Private helper function to determine what kind of gear slot is compatible with input Clothing object
     * @return Clothing[]  a suitable gear slot position.
     * */
    private Clothing[] pickupInsertPosition(Clothing clothing) {
        if (clothing instanceof HandGear) {
            return this.handGears;
        } else if (clothing instanceof HeadGear) {
            return this.headGear;
        } else {
            return this.footWears;
        }
    }

    /**
     * Private helper function to update player's ATK point and DFS point based on chosen gear
     * */
    private void updateStatic(Clothing clothing) {
        this.defencePoint += clothing.getDefence();
        this.attackPoint += clothing.getAttack();
    }

    /**
     * Print this player in format: Player UID, ATK, DFS, all equipped clothes(if possible).
     * */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player ").append(this.playerID).append(": ").append("\n");
        sb.append("  Defence Point: ").append(this.defencePoint).append(" AttackPoint: ").append(this.attackPoint);
        // if this player has no gear at this moment, return basic info.
        if (this.gearNum == 0) {
            return sb.toString();
        }
        sb.append("\n");
        // otherwise add gears info at tail.
        StringJoiner sj = new StringJoiner(",\n","[","]");
        List<Clothing> allGear = new ArrayList<>();
        allGear.addAll(Arrays.asList(this.headGear));
        allGear.addAll(Arrays.asList(this.handGears));
        allGear.addAll(Arrays.asList(this.footWears));
        for (Clothing clothing : allGear) {
            if (clothing != null) {
                sj.add(clothing.toString());
            }
        }
        sb.append(sj);
        return sb.toString();
    }

//    public static void main(String[] argv) {
//        Clothing[] testArray = new Clothing[3];
//        List<Clothing> testList = new ArrayList<>();
//        testList.addAll(Arrays.asList(testArray));
//        testList.add(new HeadGear(new ArrayList<ClothingPrefix>(Arrays.asList(ClothingPrefix.Meteoric)), HeadGearName.VISOR, 10));
//        for (Clothing x : testList) {
//            if (x == null) {
//                System.out.println("NULL");
//            } else {
//                System.out.println(x);
//            }
//        }
//    }
}
