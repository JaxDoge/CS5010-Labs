package conservatory;

import bird.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AviaryTest {

    private static Aviary testAvi0;
    private static Aviary testAvi1;
    private static Bird testOwl;
    private static Bird testPigeon;
    private static Bird emptyParrot;
    private static Bird testHawk1;
    private static Bird testHawk2;

    @BeforeEach
    void setUp() {
        // Make sure for each test the index of aviaries is always start from 0
        Aviary.AviaryIndex = 0;
        testAvi0 = new Aviary();
        testAvi1 = new Aviary();
        testOwl = new Owl("Harry Potter");
        testPigeon = new Pigeon("Catelyn Stark");
        testHawk1 = new PreyBird("Tywin Lannister");
        testHawk2 = new PreyBird("Khal Drogo");
        emptyParrot = new Parrot();
    }

    @Test
    void getLocation() {
        assertEquals("Location 0", testAvi0.getLocation());
        assertEquals("Location 1", testAvi1.getLocation());
    }

    @Test
    void addBird() {
        assertTrue(testAvi0.addBird(testOwl));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
           testAvi0.addBird(testOwl);
        });
        assertEquals("Case 0, the bird has already exited in this aviary.", e.getMessage());
        assertTrue(testAvi0.addBird(testPigeon));
        assertFalse(testAvi0.addBird(testHawk1));

    }

    @Test
    void removeBird() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        assertTrue(testAvi0.removeBird(testOwl));
        assertFalse(testAvi1.removeBird(testOwl));
        assertFalse(testAvi1.removeBird(testHawk1));

    }

    @Test
    void getBirdsCount() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        assertEquals(2, testAvi0.getBirdsCount());
        assertEquals(0, testAvi1.getBirdsCount());
    }

    @Test
    void getBird() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        assertEquals(testPigeon, testAvi0.getBird(1));

        IndexOutOfBoundsException e = assertThrows(IndexOutOfBoundsException.class, () -> {
            testAvi0.getBird(100);
        });
        assertEquals("Index 100 out of bounds for length 2", e.getMessage());

    }

    @Test
    void updateFoodDemand() {
        testAvi0.updateFoodDemand(testHawk1);
        Map<Food, Integer> expect1 = Map.of(
                Food.Other_Birds, 5,
                Food.Small_Mammals, 2
        );
        assertEquals(expect1, testAvi0.aviaryFoodDemand);

        testAvi1.updateFoodDemand(emptyParrot);
        assertEquals("{}", testAvi1.aviaryFoodDemand.toString());
    }

    @Test
    void getAviaryFoodDemand() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        Map<Food, Integer> expected1 = Map.of(Food.Nuts, 5, Food.Insects, 3, Food.Seeds, 3, Food.Small_Mammals, 4);
        assertEquals(expected1, testAvi0.getAviaryFoodDemand());
        assertEquals("{}", testAvi1.getAviaryFoodDemand().toString());
    }

    @Test
    void printASign() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        assertEquals("[\n" +
                "Type: OWL\n" +
                "Species: SnowyOwl\n" +
                "Nickname: Harry Potter\n" +
                "Live in: Land\n" +
                "Fun info: [Owls are distinguished by the facial disks that frame the eyes and bill],\n" +
                "\n" +
                "Type: PIGEON\n" +
                "Species: BlueheadedQuaildove\n" +
                "Nickname: Catelyn Stark\n" +
                "Live in: Land\n" +
                "Fun info: [Pigeons (or doves) are known for feeding their young \"bird milk\" very similar to the milk of mammals.]\n" +
                "]", testAvi0.printASign());
        assertEquals("[]", testAvi1.printASign());
    }

    @Test
    void testToString() {
        testAvi0.addBird(testOwl);
        testAvi0.addBird(testPigeon);

        assertEquals("Location 0  Harry Potter-SnowyOwl-OWL, Catelyn Stark-BlueheadedQuaildove-PIGEON", testAvi0.toString());
        assertEquals("Location 1", testAvi1.toString());
    }
}