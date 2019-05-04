package shuyi.ingredient.powder;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class SugarPowder extends Ingredient {
    public SugarPowder() {
        super(IngredientType.POWDER);
    }

    @Override
    public String getDescriptions() {
        return "白糖";
    }
}
