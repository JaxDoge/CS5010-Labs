package Clothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class ClothingBankTest {

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
        testHeG3 = new HeadGear(prefix1, HeadGearName.HAT, 1);
        testHeG4 = new HeadGear(prefix1, HeadGearName.HAT, 1);
        testHanG1 = new HandGear(prefix2, HandGearName.SWORD, 14);
        testHanG2 = new HandGear(prefix2, HandGearName.SWORD, 14);
        testHanG3 = new HandGear(prefix2, HandGearName.SWORD, 14);
        testHanG4 = new HandGear(prefix2, HandGearName.SWORD, 14);
    }

    @Test
    void getSize() {
        assertEquals(0, testCB.getSize());
        testCB.addClothing(testFW1);
        testCB.addClothing(testFW2);
        testCB.addClothing(testFW3);
        testCB.addClothing(testHeG1);
        assertEquals(4, testCB.getSize());
    }

    @Test
    void addClothing() {
        testCB.addClothing(testFW1);
        testCB.addClothing(testFW2);
        testCB.addClothing(testFW3);
        testCB.addClothing(testHeG1);
        assertEquals(4, testCB.getSize());
        assertThrows(IllegalArgumentException.class, () -> {
            testCB.addClothing(testFW1);
        });
        testCB.addClothing(testHeG2);
        testCB.addClothing(testHeG3);
        testCB.addClothing(testHeG4);
        testCB.addClothing(testHanG1);
        testCB.addClothing(testHanG2);
        testCB.addClothing(testHanG3);
        assertThrows(IllegalStateException.class, () -> {
            testCB.addClothing(testHanG4);
        });




    }

    @Test
    void deleteClothing() {
        assertFalse(testCB.deleteClothing(null));
        assertFalse(testCB.deleteClothing(testFW1));
        testCB.addClothing(testFW1);
        testCB.addClothing(testFW2);
        testCB.addClothing(testFW3);
        testCB.addClothing(testHeG1);
        assertTrue(testCB.deleteClothing(testHeG1));
        assertEquals(3, testCB.getSize());
        assertFalse(testCB.deleteClothing(testHeG1));
        Object other = "test";
        assertThrows(ClassCastException.class, () -> {
            testCB.deleteClothing((Clothing) other);
        });
    }

    private String display(ClothingBank cb) {
        StringJoiner sj = new StringJoiner(",\n");
        for (Clothing c : cb) {
            sj.add(c.toString() + " ATK: " + c.getAttack() + " DFS: " + c.getDefence());
        }
        return sj.toString();
    }
    @Test
    void iterator() {
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

        assertEquals("Corrosive SWORD CombineLevel: 0 ATK: 14 DFS: 0,\n" +
                "Corrosive SWORD CombineLevel: 0 ATK: 14 DFS: 0,\n" +
                "Corrosive SWORD CombineLevel: 0 ATK: 14 DFS: 0,\n" +
                "Hibernal HOVERBOARD CombineLevel: 0 ATK: 5 DFS: 1,\n" +
                "Celestial BOOT CombineLevel: 0 ATK: 2 DFS: 5,\n" +
                "Corrosive SNEAKER CombineLevel: 0 ATK: 2 DFS: 2,\n" +
                "Glowing HELMET CombineLevel: 0 ATK: 0 DFS: 7,\n" +
                "Celestial HAT CombineLevel: 0 ATK: 0 DFS: 1,\n" +
                "Celestial HAT CombineLevel: 0 ATK: 0 DFS: 1,\n" +
                "Celestial HAT CombineLevel: 0 ATK: 0 DFS: 1", display(testCB));

    }
}