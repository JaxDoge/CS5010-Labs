package conservatory;

import bird.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConservatoryTest {

    private static Conservatory testCon;
    private static Aviary testAvi0;
    private static Aviary testAvi1;
    private static Bird testOwl;
    private static Bird testPigeon;
    private static Bird emptyParrot;
    private static Bird testHawk1;
    private static Bird testHawk2;
    private static Bird testShoreBird;

    @BeforeEach
    void setUp() {
        // Make sure for each test the index of aviaries is always start from 0
        Aviary.AviaryIndex = 0;
        testCon = new Conservatory();
        testAvi0 = new Aviary();
        testAvi1 = new Aviary();
        testOwl = new Owl("Harry Potter");
        testPigeon = new Pigeon("Catelyn Stark");
        testHawk1 = new PreyBird("Tywin Lannister");
        testHawk2 = new PreyBird("Khal Drogo");
        testShoreBird = new Shorebird("Crazy King");
        emptyParrot = new Parrot();

    }

    @Test
    void addNewAviary() {
        assertTrue(testCon.addNewAviary(testAvi0));
        assertFalse(testCon.addNewAviary(testAvi0));
    }

    @Test
    void getCurrentAviaryNum() {
        assertEquals(0, testCon.getCurrentAviaryNum());

        testCon.addNewAviary(testAvi0);
        testCon.addNewAviary(testAvi1);
        assertEquals(2, testCon.getCurrentAviaryNum());

    }

    @Test
    void checkSpace() {
        Aviary testAvi2 = new Aviary();
        Aviary testAvi3 = new Aviary();
        Aviary testAvi4 = new Aviary();
        Aviary testAvi5 = new Aviary();
        Aviary testAvi6 = new Aviary();
        Aviary testAvi7 = new Aviary();
        Aviary testAvi8 = new Aviary();
        Aviary testAvi9 = new Aviary();
        Aviary testAvi10 = new Aviary();
        Aviary testAvi11 = new Aviary();
        Aviary testAvi12 = new Aviary();
        Aviary testAvi13 = new Aviary();
        Aviary testAvi14 = new Aviary();
        Aviary testAvi15 = new Aviary();
        Aviary testAvi16 = new Aviary();
        Aviary testAvi17 = new Aviary();
        Aviary testAvi18 = new Aviary();
        Aviary testAvi19 = new Aviary();

        assertTrue(testCon.checkSpace());

        testCon.addNewAviary(testAvi0);
        testCon.addNewAviary(testAvi1);
        testCon.addNewAviary(testAvi2);
        testCon.addNewAviary(testAvi3);
        testCon.addNewAviary(testAvi4);
        testCon.addNewAviary(testAvi5);
        testCon.addNewAviary(testAvi6);
        testCon.addNewAviary(testAvi7);
        testCon.addNewAviary(testAvi8);
        testCon.addNewAviary(testAvi9);
        testCon.addNewAviary(testAvi10);
        testCon.addNewAviary(testAvi11);
        testCon.addNewAviary(testAvi12);
        testCon.addNewAviary(testAvi13);
        testCon.addNewAviary(testAvi14);
        testCon.addNewAviary(testAvi15);
        testCon.addNewAviary(testAvi16);
        testCon.addNewAviary(testAvi17);
        testCon.addNewAviary(testAvi18);
        testCon.addNewAviary(testAvi19);

        assertFalse(testCon.checkSpace());
    }

    @Test
    void removeAviary() {
        testCon.addNewAviary(testAvi0);
        testCon.addNewAviary(testAvi1);
        Aviary testAvi2 = new Aviary();

        assertTrue(testCon.removeAviary(testAvi0));
        assertFalse(testCon.removeAviary(testAvi2));

    }

    @Test
    void addNewBird() {
        assertTrue(testCon.addNewBird(testHawk1));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testCon.addNewBird(testHawk1);
        });
        assertEquals("Case 0, the bird has already exited in this aviary.", e.getMessage());
        assertFalse(testCon.addNewBird(testShoreBird));
    }

    @Test
    void updateFoodDemand() {
        testCon.updateFoodDemand(emptyParrot);
        assertEquals("{}", testCon.conservatoryFoodDemand.toString());

        testCon.updateFoodDemand(testHawk1);
        Map<Food, Integer> expect1 = Map.of(
                Food.Other_Birds, 5,
                Food.Small_Mammals, 2
        );
        assertEquals(expect1, testCon.conservatoryFoodDemand);
    }

    @Test
    void getConservatoryFoodDemand() {
        assertEquals("{}", testCon.getConservatoryFoodDemand().toString());
        testCon.addNewBird(testHawk1);
        testCon.addNewBird(testHawk2);
        Map<Food, Integer> expect1 = Map.of(
                Food.Other_Birds, 10,
                Food.Small_Mammals, 4
        );
        assertEquals(expect1, testCon.getConservatoryFoodDemand());

    }

    @Test
    void checkBirdAviary() {
        assertEquals(null, testCon.checkBirdAviary(testHawk2));
        testCon.addNewBird(testHawk1);
        testCon.addNewBird(testHawk2);
        assertEquals("Location 2  Tywin Lannister-Hawk-PREYBIRD, Khal Drogo-Hawk-PREYBIRD", testCon.checkBirdAviary(testHawk2).toString());
    }

    @Test
    void printAMap() {
        assertEquals("{}", testCon.printAMap());
        testCon.addNewBird(testHawk1);
        testCon.addNewBird(testHawk2);
        testCon.addNewBird(testOwl);
        testCon.addNewBird(testPigeon);
        testCon.addNewBird(testShoreBird);
        assertEquals("{\n" +
                "Aviary 0: Location 2  Tywin Lannister-Hawk-PREYBIRD, Khal Drogo-Hawk-PREYBIRD; \n" +
                "Aviary 1: Location 3  Harry Potter-SnowyOwl-OWL, Catelyn Stark-BlueheadedQuaildove-PIGEON\n" +
                "}", testCon.printAMap());
    }

    @Test
    void printAIndex() {
        assertEquals("[]", testCon.printAIndex());
        testCon.addNewBird(testHawk1);
        testCon.addNewBird(testHawk2);
        testCon.addNewBird(testOwl);
        testCon.addNewBird(testPigeon);
        testCon.addNewBird(testShoreBird);
        assertEquals("[\n" +
                "Catelyn Stark-BlueheadedQuaildove-PIGEON in Location 3;\n" +
                "Harry Potter-SnowyOwl-OWL in Location 3;\n" +
                "Khal Drogo-Hawk-PREYBIRD in Location 2;\n" +
                "Tywin Lannister-Hawk-PREYBIRD in Location 2\n" +
                "]", testCon.printAIndex());

    }
}