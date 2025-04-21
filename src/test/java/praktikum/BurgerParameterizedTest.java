package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private final String bunName;
    private final float bunPrice;
    private final Object[][] ingredientTuples;
    private final float expectedPrice;

    private Burger burger;
    private Bun mockBun;
    private List<Ingredient> mockIngredients;

    public BurgerParameterizedTest(String bunName, float bunPrice, Object[][] ingredientTuples, float expectedPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientTuples = ingredientTuples;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: bun={0}, expectedPrice={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                        "Test Bun", 100f,
                        new Object[][] {
                                { IngredientType.SAUCE,   "TestSauce",   20f },
                                { IngredientType.FILLING, "TestFilling", 30f }
                        },
                        100f * 2 + 20f + 30f  // 250f
                },
                {
                        "Mini Bun", 50f,
                        new Object[][] {
                                { IngredientType.FILLING, "MiniFilling", 15f }
                        },
                        50f * 2 + 15f  // 115f
                },
                {
                        "Empty Bun", 80f,
                        new Object[][] {},
                        80f * 2  // 160f
                }
        });
    }

    @Before
    public void setUp() {
        burger = new Burger();

        mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn(bunName);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(mockBun);

        mockIngredients = new ArrayList<>();

        for (Object[] tuple : ingredientTuples) {
            IngredientType type = (IngredientType) tuple[0];
            String name = (String) tuple[1];
            float price = (Float) tuple[2];

            Ingredient ing = mock(Ingredient.class);
            when(ing.getType()).thenReturn(type);
            when(ing.getName()).thenReturn(name);
            when(ing.getPrice()).thenReturn(price);

            burger.addIngredient(ing);
            mockIngredients.add(ing);
        }
    }

    @Test
    public void testGetPriceParameterized() {
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceiptParameterized() {
        StringBuilder expected = new StringBuilder();
        expected.append(String.format("(==== %s ====)%n", bunName));
        for (Ingredient ing : mockIngredients) {
            expected.append(String.format("= %s %s =%n",
                    ing.getType().toString().toLowerCase(),
                    ing.getName()));
        }
        expected.append(String.format("(==== %s ====)%n", bunName));
        expected.append(String.format("%nPrice: %f%n", expectedPrice));

        assertEquals(expected.toString(), burger.getReceipt());
    }
}
