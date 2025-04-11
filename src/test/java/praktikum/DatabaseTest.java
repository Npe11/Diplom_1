package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAvailableBunsNotEmpty() {
        List<Bun> buns = database.availableBuns();
        assertNotNull(buns);
        // В конструкторе Database добавляем 3 булки
        assertEquals(3, buns.size());
    }

    @Test
    public void testAvailableIngredientsNotEmpty() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertNotNull(ingredients);
        // В конструкторе Database добавляем 6 ингредиентов (3 соуса и 3 начинки)
        assertEquals(6, ingredients.size());
    }
}
