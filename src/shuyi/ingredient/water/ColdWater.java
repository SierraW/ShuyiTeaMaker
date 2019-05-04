package shuyi.ingredient.water;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class ColdWater extends Ingredient {
    public ColdWater() {
        super(IngredientType.WATER);
    }

    @Override
    public String getDescriptions() {
        return "Cold Water";
    }
}
