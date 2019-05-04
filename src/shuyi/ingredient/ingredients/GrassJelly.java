package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class GrassJelly extends Ingredient {
    public GrassJelly() {
        super(IngredientType.INGREDIENT);
    }

    @Override
    public String getDescriptions() {
        return "仙草冻";
    }
}
