package Player;

import Clothing.*;

import java.util.List;

public class Player implements Playerable{
    private static int globalID;
    private int playerID;

    private HeadGear[] headGear;
    private HandGear[] handGears;
    private FootWear[] footWears;
    private int defencePoint;
    private int attackPoint;

    public Player () {
        playerID = globalID;
        globalID += 1;
        headGear = new HeadGear[1];
        handGears = new HandGear[2];
        footWears = new FootWear[2];
    }



    @Override
    public int compareTo(Player o) {
        int thisDamage = o.attackPoint - this.defencePoint;
        int otherDamage = this.defencePoint - o.attackPoint;
        return thisDamage - otherDamage;
    }

    /**
     * For each turn, this player pick up one gear based on the given spec.
     * After picking up, the chosen clothing will be removed from bank and add to player's slot.
     * */
    @Override
    public void pickup(ClothingBank clothingBank) {

        for (Clothing clothing : clothingBank) {
            // Phase 1, check if there is an empty slot for current candidate.

        }
    }

    private Clothing[] pickupInsertPosition(Clothing clothing) {
        if (clothing instanceof HandGear) {
            return this.handGears;
        } else if (clothing instanceof HeadGear) {
            return this.headGear;
        } else {
            return this.footWears;
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
