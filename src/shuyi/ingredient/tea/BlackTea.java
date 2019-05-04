package shuyi.ingredient.tea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class BlackTea extends Ingredient {
    public BlackTea() {
        super(IngredientType.TEA);
    }

    @Override
    public String getDescriptions() {
        return "红茶";
    }
}
