package elektro.rechen;

import elektro.rechen.Rechner;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class RechnerTest {

    private static Rechner rechner;

    @BeforeClass
    public static void setUp() {
        rechner = new Rechner();
    }

    @Test
    public void smokeTestPlus() {
        assertEquals(rechner.plus(2, 3), 5);
    }

    @Test
    public void smokeTestMinus() { assertEquals(rechner.minus(7, 4), 3);}

    @Test(expected = IllegalArgumentException.class)
    public void numOutOfRange() {
        rechner.plus(1200, -1300);
    }

    @Test (expected = IllegalArgumentException.class)
    public void divideByZero() {
        rechner.geteilt(10, 0);
    }
}
