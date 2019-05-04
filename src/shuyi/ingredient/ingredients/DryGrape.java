package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class DryGrape extends Ingredient {
    public DryGrape() {
        super(IngredientType.INGREDIENT);
    }

    @Override
    public String getDescriptions() {
        return "葡萄干";
    }
}
