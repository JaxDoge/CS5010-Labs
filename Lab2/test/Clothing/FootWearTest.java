package Clothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FootWearTest {
    private FootWear testFW1;
    private FootWear testFW2;
    private FootWear testFW3;
    private HeadGear testHeG1;

    @BeforeEach
    void setUp() {
        List<ClothingPrefix> prefix1 = new ArrayList<>(List.of(ClothingPrefix.Celestial));
        testFW1 = new FootWear(prefix1, FootWearName.BOOT, 5, 2);
        List<ClothingPrefix> prefix2 = new ArrayList<>(List.of(ClothingPrefix.Corrosive));
        testFW2 = new FootWear(prefix2, FootWearName.SNEAKER, 2, 2);
        List<ClothingPrefix> prefix3 = new ArrayList<>(List.of(ClothingPrefix.Hibernal));
        testFW3 = new FootWear(prefix3, FootWearName.HOVERBOARD, 1, 5);
        List<ClothingPrefix> prefix5 = new ArrayList<>(List.of(ClothingPrefix.Glowing));
        testHeG1 = new HeadGear(prefix5, HeadGearName.HELMET, 7);
    }

    @Test
    void testConstructor() {
        List<ClothingPrefix> prefix4 = new ArrayList<>(List.of(ClothingPrefix.Jagged));
        FootWear testFW4 = new FootWear(prefix4, FootWearName.SNEAKER, 3, 1);
        assertEquals("[Jagged]", testFW4.getClothingPrefix().toString());
        assertEquals(3, testFW4.getDefence());
        assertEquals(1, testFW4.getAttack());
        assertEquals("SNEAKER", testFW4.getClothingName());

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new FootWear(prefix4, FootWearName.SNEAKER, -3, 1);
        });
        assertEquals("Negative defence point", thrown.getMessage());

        Object other = "test";
        assertThrows(ClassCastException.class, () -> {
            new FootWear(prefix4, FootWearName.SNEAKER, 3, (Integer) other);
        });

    }

    @Test
    void compareTo() {
        assertTrue(testFW1.compareTo(testFW1) == 0);
        assertTrue(testFW1.compareTo(testFW3) > 0);
        assertTrue(testFW1.compareTo(testFW2) < 0);

        Object other = "test";
        assertThrows(ClassCastException.class, () -> {
           testFW1.compareTo((Clothing) other);
        });

        assertThrows(NullPointerException.class, () -> {
            testFW1.compareTo(null);
        });


    }

    @Test
    void getDefence() {
        assertEquals(5, testFW1.getDefence());
    }

    @Test
    void getAttack() {
        assertEquals(2, testFW1.getAttack());
    }

    @Test
    void getComblvl() {
        assertEquals(0, testFW1.getComblvl());
    }

    @Test
    void getClothingPrefix() {
        assertEquals("[Celestial]", testFW1.getClothingPrefix().toString());
    }


    @Test
    void getClothingType() {
        assertEquals(ClothingType.FOOTWAER, testFW1.getClothingType());
    }

    @Test
    void getClothingName() {
        assertEquals("BOOT", testFW1.getClothingName());
    }

    @Test
    void combTo() {
        FootWear testcomb = (FootWear) testFW1.combTo(testFW2);
        assertEquals(1, testcomb.getComblvl());
        assertEquals("Celestial, Corrosive SNEAKER CombineLevel: 1", testcomb.toString());

        assertThrows(IllegalArgumentException.class, () -> {
            testFW1.combTo(testFW1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            testFW1.combTo(testHeG1);
        });

        Object other = "test";
        assertThrows(ClassCastException.class, () -> {
            testFW1.combTo((Clothing) other);
        });

        assertThrows(NullPointerException.class, () -> {
            testFW1.combTo(null);
        });
    }

    @Test
    void testToString() {
        assertEquals("Corrosive SNEAKER CombineLevel: 0", testFW2.toString());
    }
}
