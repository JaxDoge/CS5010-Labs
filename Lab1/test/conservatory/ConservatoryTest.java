package conservatory;

import bird.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        emptyParrot = new Parrot();

    }

    @Test
    void addNewAviary() {
    }

    @Test
    void getCurrentAviaryNum() {
        assertEquals(0, testCon.getCurrentAviaryNum());

    }

    @Test
    void checkSpace() {
    }

    @Test
    void removeAviary() {
    }

    @Test
    void getAviary() {
    }

    @Test
    void addNewBird() {
    }

    @Test
    void updateFoodDemand() {
    }

    @Test
    void getConservatoryFoodDemand() {
    }

    @Test
    void updateBird2Aviary() {
    }

    @Test
    void checkBirdAviary() {
    }

    @Test
    void printAMap() {
    }

    @Test
    void printAIndex() {
    }
}