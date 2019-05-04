package shuyi.ingredient.powder;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class MilkPowder extends Ingredient {
    public MilkPowder() {
        super(IngredientType.POWDER);
    }

    @Override
    public String getDescriptions() {
        return "奶粉";
    }
}
