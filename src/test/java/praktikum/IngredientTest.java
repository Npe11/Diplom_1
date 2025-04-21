package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Test Sauce", 10.0f);
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Sauce", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0f, ingredient.getPrice(), 0.001);
    }
}
