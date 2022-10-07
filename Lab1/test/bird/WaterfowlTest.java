package bird;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterfowlTest {

    private static Bird testWaterfowl1;
    private static Bird testWaterfowl2;

    @BeforeEach
    void setUp() {
        testWaterfowl1 = new Waterfowl();
        testWaterfowl2 = new Waterfowl("Anne Hathaway");
    }

    @Test
    void getWaterBody() {
        Waterfowl tw = (Waterfowl) testWaterfowl1;
        assertEquals(null, tw.getWaterBody());

        tw = (Waterfowl) testWaterfowl2;
        assertEquals(WaterBody.FRESH_WATER_SOURCES, tw.getWaterBody());
    }

    @Test
    void setWaterBody() {
        Waterfowl tw = (Waterfowl) testWaterfowl2;
        tw.setWaterBody(WaterBody.SALT_WATER_SOURCES);
        assertEquals(WaterBody.SALT_WATER_SOURCES, tw.waterBody);

        Waterfowl tw1 = (Waterfowl) testWaterfowl1;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            tw1.setWaterBody(WaterBody.OCEAN);
        });
        assertEquals("Not a suitable water body type for Waterfowl", e.getMessage());

    }
}