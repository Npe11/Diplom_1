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
        Bun bunMock = Mockito.mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(50f);

        burger.setBuns(bunMock);

        Ingredient ingredientMock = Mockito.mock(Ingredient.class);
        when(ingredientMock.getPrice()).thenReturn(20f);
        when(ingredientMock.getName()).thenReturn("Mock Sauce");
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredientMock);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        Bun bunMock = Mockito.mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(50f);

        burger.setBuns(bunMock);

        Ingredient ingredient1Mock = Mockito.mock(Ingredient.class);
        when(ingredient1Mock.getPrice()).thenReturn(10f);
        when(ingredient1Mock.getName()).thenReturn("Sauce1");
        when(ingredient1Mock.getType()).thenReturn(IngredientType.SAUCE);
        burger.addIngredient(ingredient1Mock);

        Ingredient ingredient2Mock = Mockito.mock(Ingredient.class);
        when(ingredient2Mock.getPrice()).thenReturn(20f);
        when(ingredient2Mock.getName()).thenReturn("Filling1");
        when(ingredient2Mock.getType()).thenReturn(IngredientType.FILLING);

        burger.addIngredient(ingredient2Mock);
        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Bun bunMock = Mockito.mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(50f);

        burger.setBuns(bunMock);

        Ingredient ingredient1Mock = Mockito.mock(Ingredient.class);
        when(ingredient1Mock.getPrice()).thenReturn(10f);
        when(ingredient1Mock.getName()).thenReturn("Sauce1");
        when(ingredient1Mock.getType()).thenReturn(IngredientType.SAUCE);

        Ingredient ingredient2Mock = Mockito.mock(Ingredient.class);
        when(ingredient2Mock.getPrice()).thenReturn(20f);
        when(ingredient2Mock.getName()).thenReturn("Filling1");
        when(ingredient2Mock.getType()).thenReturn(IngredientType.FILLING);

        Ingredient ingredient3Mock = Mockito.mock(Ingredient.class);
        when(ingredient3Mock.getPrice()).thenReturn(5f);
        when(ingredient3Mock.getName()).thenReturn("Sauce2");
        when(ingredient3Mock.getType()).thenReturn(IngredientType.SAUCE);

        burger.addIngredient(ingredient1Mock);
        burger.addIngredient(ingredient2Mock);
        burger.addIngredient(ingredient3Mock);
        // Изначальный порядок: [ing1, ing2, ing3]
        burger.moveIngredient(0, 2); // Перемещаем элемент с индексом 0 на позицию 2
        // Ожидаемый порядок: [ing2, ing3, ing1]
        assertEquals("Sauce1", burger.ingredients.get(2).getName());
    }
}
