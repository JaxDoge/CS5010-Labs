package Battle;

import Clothing.*;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Battle class could instantiate a real battle with preset clothing bank and two players and ten different clothing.
 * the outcome is fixed.
 * It just for imitation purpose
 * */
public class Battle {
    private Player p1;
    private Player p2;
    private ClothingBank clothingBank;
    private Clothing FW1;
    private Clothing FW2;
    private Clothing FW3;
    private Clothing FW4;
    private Clothing HeG1;
    private Clothing HeG2;
    private Clothing HanG1;
    private Clothing HanG2;
    private Clothing HanG3;
    private Clothing HanG4;

    public Battle() {
        p1 = new Player();
        p2 = new Player();

        clothingBank = new ClothingBank();
        List<ClothingPrefix> prefix1 = new ArrayList<>(List.of(ClothingPrefix.Celestial));
        FW1 = new FootWear(prefix1, FootWearName.BOOT, 5, 2);
        List<ClothingPrefix> prefix2 = new ArrayList<>(List.of(ClothingPrefix.Corrosive));
        FW2 = new FootWear(prefix2, FootWearName.SNEAKER, 2, 2);
        List<ClothingPrefix> prefix3 = new ArrayList<>(List.of(ClothingPrefix.Hibernal));
        FW3 = new FootWear(prefix3, FootWearName.BOOT, 100, 5);
        List<ClothingPrefix> prefix4 = new ArrayList<>(List.of(ClothingPrefix.Deadly));
        FW4 = new FootWear(prefix4, FootWearName.HOVERBOARD, 1, 8);
        List<ClothingPrefix> prefix5 = new ArrayList<>(List.of(ClothingPrefix.Glowing));
        HeG1 = new HeadGear(prefix5, HeadGearName.HELMET, 7);
        HeG2 = new HeadGear(prefix1, HeadGearName.HAT, 1);
        HanG1 = new HandGear(prefix2, HandGearName.SWORD, 14);
        HanG2 = new HandGear(prefix2, HandGearName.SWORD, 15);
        HanG3 = new HandGear(prefix2, HandGearName.SWORD, 16);
        HanG4 = new HandGear(prefix2, HandGearName.SWORD, 17);

        clothingBank.addClothing(FW1);
        clothingBank.addClothing(FW2);
        clothingBank.addClothing(FW3);
        clothingBank.addClothing(FW4);
        clothingBank.addClothing(HeG1);
        clothingBank.addClothing(HeG2);
        clothingBank.addClothing(HanG1);
        clothingBank.addClothing(HanG2);
        clothingBank.addClothing(HanG3);
        clothingBank.addClothing(HanG4);
    }

    /**
     * Two player choose their gears from clothing bank in turn
     * Print the player after he picks up a gear.
     * */
    private void equipPhase() {
        while (clothingBank.getSize() > 0) {
            p1.pickup(clothingBank);
            System.out.println(p1.toString());
            p2.pickup(clothingBank);
            System.out.println(p2.toString());
        }
    }

    /**
     * Battle launcher.
     * */
    public String finalWinner() {
        equipPhase();
        int outcome = p1.compareTo(p2);
        if (outcome < 0) {
            return "P0 win.";
        } else if (outcome > 0) {
            return "P1 win.";
        } else {
            return "Tie.";
        }
    }
}
