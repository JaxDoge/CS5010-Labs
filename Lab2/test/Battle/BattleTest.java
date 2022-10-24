package Battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    private Battle testBT;

    @BeforeEach
    void setUp() {
        testBT = new Battle();
    }

    @Test
    void finalWinner() {
        assertEquals("P1 win.", testBT.finalWinner());
    }
}