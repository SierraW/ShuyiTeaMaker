package shuyi.ingredient.tea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class GreenTea extends Ingredient {
    public GreenTea() {
        super(IngredientType.TEA);
    }

    @Override
    public String getDescriptions() {
        return "绿茶";
    }
}
