package bird;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SwanTest {
    Swan sw1;

    @BeforeAll
    public void testConstructor() {
        sw1 = new Swan("Tim");
    }

    @Test
    public void test1() {

    }

}