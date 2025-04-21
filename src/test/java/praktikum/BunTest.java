package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Test Bun", 50.0f);
    }

    @Test
    public void testGetName() {
        assertEquals("Test Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50.0f, bun.getPrice(), 0.001);
    }
}
