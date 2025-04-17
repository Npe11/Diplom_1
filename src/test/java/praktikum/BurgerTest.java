package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        Bun bunMock = Mockito.mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(100f);

        burger.setBuns(bunMock);

        assertEquals(100.0f, burger.bun.getPrice(), 0.001);
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(new Bun("Test Bun", 50f));

        Ingredient ingredientMock = Mockito.mock(Ingredient.class);
        when(ingredientMock.getPrice()).thenReturn(20f);
        when(ingredientMock.getName()).thenReturn("Mock Sauce");
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Mock Sauce", burger.ingredients.get(0).getName());
        assertEquals(20f, burger.ingredients.get(0).getPrice(), 0.001);
        assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(new Bun("Test Bun", 50f));
        Ingredient ing1 = new Ingredient(IngredientType.SAUCE, "Sauce1", 10f);
        Ingredient ing2 = new Ingredient(IngredientType.FILLING, "Filling1", 20f);

        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Filling1", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(new Bun("Test Bun", 50f));
        Ingredient ing1 = new Ingredient(IngredientType.SAUCE, "Sauce1", 10f);
        Ingredient ing2 = new Ingredient(IngredientType.FILLING, "Filling1", 20f);
        Ingredient ing3 = new Ingredient(IngredientType.SAUCE, "Sauce2", 5f);

        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        burger.addIngredient(ing3);
        // Изначальный порядок: [ing1, ing2, ing3]
        burger.moveIngredient(0, 2); // Перемещаем элемент с индексом 0 на позицию 2
        // Ожидаемый порядок: [ing2, ing3, ing1]
        assertEquals("Filling1", burger.ingredients.get(0).getName());
        assertEquals("Sauce2", burger.ingredients.get(1).getName());
        assertEquals("Sauce1", burger.ingredients.get(2).getName());
    }
}
