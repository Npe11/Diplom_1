package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testFillingToString() {
        assertEquals("FILLING", IngredientType.FILLING.toString());
    }

    @Test
    public void testSauceToString() {
        assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFillingToLowerCaseConversion() {
        assertEquals("filling", IngredientType.FILLING.toString().toLowerCase());
    }

    @Test
    public void testSauceToLowerCaseConversion() {
        assertEquals("sauce", IngredientType.SAUCE.toString().toLowerCase());
    }
}
