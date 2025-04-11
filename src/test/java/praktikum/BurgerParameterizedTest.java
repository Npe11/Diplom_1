package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final String bunName;
    private final float bunPrice;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    private Burger burger;

    public BurgerParameterizedTest(String bunName, float bunPrice, List<Ingredient> ingredients, float expectedPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();

        // Тестовый случай 1: Булочка с двумя ингредиентами
        List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Ingredient(IngredientType.SAUCE, "TestSauce", 20f));
        ingredients1.add(new Ingredient(IngredientType.FILLING, "TestFilling", 30f));
        float price1 = 100f * 2 + 20f + 30f; // 250.0
        params.add(new Object[]{"Test Bun", 100f, ingredients1, price1});

        // Тестовый случай 2: Булочка с одним ингредиентом
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(new Ingredient(IngredientType.FILLING, "MiniFilling", 15f));
        float price2 = 50f * 2 + 15f; // 115.0
        params.add(new Object[]{"Mini Bun", 50f, ingredients2, price2});

        // Тестовый случай 3: Булочка без ингредиентов
        List<Ingredient> ingredients3 = new ArrayList<>();
        float price3 = 80f * 2; // 160.0
        params.add(new Object[]{"Empty Bun", 80f, ingredients3, price3});

        return params;
    }

    @Before
    public void setUp() {
        burger = new Burger();
        Bun bun = new Bun(bunName, bunPrice);
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testGetPriceParameterized() {
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceiptParameterized() {
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        for (Ingredient ingredient : ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n",
                    ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        }
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %f%n", expectedPrice));

        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
