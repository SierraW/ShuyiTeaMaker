package shuyi.ingredient.tea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class OolongTea extends Ingredient {
    public OolongTea() {
        super(IngredientType.TEA);
    }

    @Override
    public String getDescriptions() {
        return "四季春茶";
    }
}
