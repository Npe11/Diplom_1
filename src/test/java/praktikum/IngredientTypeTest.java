package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testToStringValues() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testToLowerCaseConversion() {
        assertEquals("sauce", IngredientType.SAUCE.toString().toLowerCase());
        assertEquals("filling", IngredientType.FILLING.toString().toLowerCase());
    }
}
