package Player;

import Clothing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player p1;
    private Player p2;

    private ClothingBank testCB;
    private FootWear testFW1;
    private FootWear testFW2;
    private FootWear testFW3;
    private HeadGear testHeG1;
    private HeadGear testHeG2;
    private HeadGear testHeG3;
    private HeadGear testHeG4;
    private HandGear testHanG1;
    private HandGear testHanG2;
    private HandGear testHanG3;
    private HandGear testHanG4;
    @BeforeEach
    void setUp() {
        p1 = new Player();
        p2 = new Player();

        testCB = new ClothingBank();
        List<ClothingPrefix> prefix1 = new ArrayList<>(List.of(ClothingPrefix.Celestial));
        testFW1 = new FootWear(prefix1, FootWearName.BOOT, 5, 2);
        List<ClothingPrefix> prefix2 = new ArrayList<>(List.of(ClothingPrefix.Corrosive));
        testFW2 = new FootWear(prefix2, FootWearName.SNEAKER, 2, 2);
        List<ClothingPrefix> prefix3 = new ArrayList<>(List.of(ClothingPrefix.Hibernal));
        testFW3 = new FootWear(prefix3, FootWearName.HOVERBOARD, 1, 5);
        List<ClothingPrefix> prefix5 = new ArrayList<>(List.of(ClothingPrefix.Glowing));
        testHeG1 = new HeadGear(prefix5, HeadGearName.HELMET, 7);
        testHeG2 = new HeadGear(prefix1, HeadGearName.HAT, 1);
        testHeG3 = new HeadGear(prefix1, HeadGearName.HAT, 3);
        testHeG4 = new HeadGear(prefix1, HeadGearName.HAT, 5);
        testHanG1 = new HandGear(prefix2, HandGearName.SWORD, 14);
        testHanG2 = new HandGear(prefix2, HandGearName.SWORD, 15);
        testHanG3 = new HandGear(prefix2, HandGearName.SWORD, 16);
        testHanG4 = new HandGear(prefix2, HandGearName.SWORD, 17);

        testCB.addClothing(testFW1);
        testCB.addClothing(testFW2);
        testCB.addClothing(testFW3);
        testCB.addClothing(testHeG1);
        testCB.addClothing(testHeG2);
        testCB.addClothing(testHeG3);
        testCB.addClothing(testHeG4);
        testCB.addClothing(testHanG1);
        testCB.addClothing(testHanG2);
        testCB.addClothing(testHanG3);
    }

    @Test
    void compareTo() {
        assertTrue(p1.compareTo(p2) == 0);
        assertTrue(p1.compareTo(p1) == 0);
        p1.pickup(testCB);
        assertTrue(p1.compareTo(p2) < 0);

        Object other = "123";
        assertThrows(ClassCastException.class, () -> {
            p1.compareTo((Player) other);
        });

        assertThrows(NullPointerException.class, () -> {
            p1.compareTo(null);
        });
    }

    @Test
    void pickup() {
        assertThrows(NullPointerException.class, () -> {
            p1.pickup(null);
        });

        Object other = "123";
        assertThrows(ClassCastException.class, () -> {
            p1.pickup((ClothingBank) other);
        });

        p1.pickup(testCB);
        assertEquals(9, testCB.getSize());
        assertTrue(p1.compareTo(p2) < 0);
        assertEquals("Player 0: \n" +
                "  Defence Point: 0 AttackPoint: 16\n" +
                "[Corrosive SWORD CombineLevel: 0]", p1.toString());

        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);
        p1.pickup(testCB);

        assertEquals("Player 0: \n" +
                "  Defence Point: 43 AttackPoint: 75\n" +
                "[Glowing, Celestial, Celestial HAT CombineLevel: 1,\n" +
                "Corrosive, Corrosive SWORD CombineLevel: 0,\n" +
                "Corrosive, Corrosive SWORD CombineLevel: 1,\n" +
                "Celestial BOOT CombineLevel: 0,\n" +
                "Hibernal, Corrosive, Corrosive SNEAKER CombineLevel: 1]", p1.toString());

    }

    @Test
    void testToString() {
        assertEquals("Player 0: \n" +
                "  Defence Point: 0 AttackPoint: 0", p1.toString());

        p1.pickup(testCB);
        assertEquals("Player 0: \n" +
                "  Defence Point: 0 AttackPoint: 16\n" +
                "[Corrosive SWORD CombineLevel: 0]", p1.toString());
    }
}