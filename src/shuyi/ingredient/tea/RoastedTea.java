package shuyi.ingredient.tea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class RoastedTea extends Ingredient {
    public RoastedTea() {
        super(IngredientType.TEA);
    }

    @Override
    public String getDescriptions() {
        return "烤茶";
    }
}
