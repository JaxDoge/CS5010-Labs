package bird;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ParrotTest {

    private static Bird testParrot1;
    private static Bird testParrot2;
    private static Bird testParrot3;

    @BeforeEach
    void setUp() {
        testParrot1 = new Parrot();
        testParrot2 = new Parrot("TestParrot2", "Blahhhh");
        Map<Food, Integer> favFood = new HashMap<>();
        favFood.put(Food.Berries, 2);
        favFood.put(Food.Buds, 1);
        testParrot3 = new Parrot("TestParrot3", "Kakapo",
                true, favFood, 99, "Feed Me");
    }

    @Test
    void isExtinction() {
        assertTrue(testParrot3.isExtinction());
        assertFalse(testParrot1.isExtinction());
    }

    @Test
    void setExtinction() {
        testParrot1.setExtinction(false);
        assertFalse(testParrot1.isExtinct);
        testParrot1.setExtinction(true);
        assertTrue(testParrot1.isExtinct);

    }

    @Test
    void getNickName() {
        assertEquals("TestParrot2", testParrot2.getNickName());
        assertNull(testParrot1.getNickName());
    }

    @Test
    void setNickName() {
        testParrot1.setNickName("Toyota");
        assertEquals("Toyota", testParrot1.nickName);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setNickName("  ^^^  ");
        });
        assertEquals("The input name string start with a non-word or non-number character, included _", thrown.getMessage());
    }

    @Test
    void getSpeciesName() {
        assertEquals("Kakapo", testParrot3.getSpeciesName());
        assertNull(testParrot1.getSpeciesName());
    }

    @Test
    void setSpeciesName() {
        testParrot1.setSpeciesName("RoseringParakeet");
        assertEquals("RoseringParakeet", testParrot1.speciesName);

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setSpeciesName("  ^^^  ");
        });
        assertEquals("The input name string start with a non-word or non-number character, included _", thrown.getMessage());

        IllegalArgumentException thrown1 = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setSpeciesName("Hawk");
        });
        assertEquals("This species name is not valid for current bird type", thrown1.getMessage());

    }

    @Test
    void getTypeName() {
        assertEquals(TypeName.PARROT, testParrot2.getTypeName());
        assertEquals(TypeName.PARROT, testParrot1.getTypeName());
    }

    @Test
    void setTypeName() {
        testParrot1.setTypeName(TypeName.PARROT);
        assertEquals(TypeName.PARROT, testParrot1.typeName);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setTypeName(TypeName.OWL);
        });
        assertEquals("The type name does not match with this bird type.", e.getMessage());
    }

    @Test
    void getCharacteristic() {
        assertEquals("[Parrots have a short, curved beak and are known for their intelligence and ability to " +
                "mimic sounds, Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single " +
                "favorite saying.]", testParrot2.getCharacteristic().toString());
        assertEquals(null, testParrot1.getCharacteristic());
    }

    @Test
    void setCharacteristic() {
        List<String> char1 = new ArrayList<>(Arrays.asList("aaa", "bbb"));
        testParrot1.setCharacteristic(char1);
        assertEquals(char1, testParrot1.Characteristic);

        List<String> char2 = new ArrayList<>(Arrays.asList("", "bbb"));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setCharacteristic(char2);
        });
        assertEquals("One characteristic string is empty", e.getMessage());
    }

    @Test
    void getWingsNum() {
        assertEquals(2, testParrot2.getWingsNum());
        assertEquals(0, testParrot1.getWingsNum());
    }

    @Test
    void setWingsNum() {
        testParrot1.setWingsNum(4);
        assertEquals(4, testParrot1.wingsNum);


        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setWingsNum(-1);
        });
        assertEquals("Wing number cannot be negative.", e.getMessage());
    }

    @Test
    void getFavFood() {
        assertEquals("{Vegetation=1, Nuts=2}", testParrot2.getFavFood().toString());
        assertNull(testParrot1.getFavFood());
    }

    @Test
    void setFavFood() {
        Map<Food, Integer> favFood1 = new HashMap<>();
        favFood1.put(Food.Berries, 2);
        favFood1.put(Food.Buds, 1);
        testParrot1.setFavFood(favFood1);
        assertEquals("{Berries=2, Buds=1}", testParrot1.favoriteFood.toString());

        Map<Food, Integer> favFood2 = new HashMap<>();
        favFood2.put(Food.Berries, 2);
        favFood2.put(Food.Buds, -1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot1.setFavFood(favFood2);
        });
        assertEquals("The portion of food (Buds) is less or equal to ZERO", e.getMessage());

    }

    @Test
    void getFavFoodPortion() {
        assertEquals(1, testParrot2.getFavFoodPortion(Food.Vegetation));
        NullPointerException e = assertThrows(NullPointerException.class, () -> {
            testParrot1.getFavFoodPortion(Food.Vegetation);
        });
        assertEquals("The bird's favorite food hasn't settled yet.", e.getMessage());

    }

    @Test
    void getWaterHabitat() {
        assertFalse(testParrot2.getWaterHabitat());
        assertFalse(testParrot1.getWaterHabitat());
    }

    @Test
    void setWaterHabitat() {
        testParrot1.setWaterHabitat(true);
        assertTrue(testParrot1.waterHabitat);
    }

    @Test
    void getAviaryDemand() {
        assertEquals(AviaryDemand.NO_DEMAND, testParrot2.getAviaryDemand());
        assertEquals(AviaryDemand.NO_DEMAND, testParrot1.getAviaryDemand());
    }

    @Test
    void testGetAviaryDemand() {
        assertEquals(AviaryDemand.PREY_BIRD, testParrot2.getAviaryDemand(TypeName.PREYBIRD));
    }

    @Test
    void checkTypeBelong() {
        assertTrue(testParrot2.checkTypeBelong("Kakapo"));


        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            assertFalse(testParrot2.checkTypeBelong("Kakapo1"));
        });
        assertEquals("This species name is not valid for current bird type", e.getMessage());
    }

    @Test
    void checkNameValidity() {
        assertTrue(Bird.checkNameValidity("Peter"));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            assertFalse(Bird.checkNameValidity("  Peter"));
        });
        assertEquals("The input name string start with a non-word or non-number character, included _", e.getMessage());
    }

    @Test
    void birdSpec() {
        assertEquals("Type: PARROT\n" +
                "Species: RoseringParakeet\n" +
                "Nickname: TestParrot2\n" +
                "Live in: Land\n" +
                "Fun info: [Parrots have a short, curved beak and are known for their intelligence and ability " +
                "to mimic sounds, Many pet parrots can learn a vocabulary of up to 100 words and often adopt a " +
                "single favorite saying.]",
                testParrot2.birdSpec());

        assertEquals("Type: PARROT\n" +
                "Species: null\n" +
                "Nickname: null\n" +
                "Live in: Land\n" +
                "Fun info: []",
                testParrot1.birdSpec());
    }

    @Test
    void testToString() {
        assertEquals("TestParrot2-RoseringParakeet-PARROT", testParrot2.toString());
        assertEquals("null-null-PARROT", testParrot1.toString());
    }

    @Test
    void getWords() {
        Parrot testParrot = (Parrot) testParrot2;
        assertEquals(103, testParrot.getWords());

        testParrot = (Parrot) testParrot1;
        assertEquals(0, testParrot.getWords());

    }

    @Test
    void setWords() {
        Parrot testParrot = (Parrot) testParrot1;
        testParrot.setWords(110);
        assertEquals(110, testParrot.words);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot.setWords(-10);
        });
        assertEquals("Parrot's words cannot be negative", e.getMessage());
    }

    @Test
    void getFavSaying() {
        Parrot testParrot = (Parrot) testParrot2;
        assertEquals("Blahhhh", testParrot.getFavSaying());

        testParrot = (Parrot) testParrot1;
        assertEquals(null, testParrot.getFavSaying());
    }

    @Test
    void setFavSaying() {
        Parrot testParrot = (Parrot) testParrot1;
        testParrot.setFavSaying("Yahoo");
        assertEquals("Yahoo", testParrot.favSaying);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            testParrot.setFavSaying("");
        });
        assertEquals("The favorite saying is empty", e.getMessage());

    }
}