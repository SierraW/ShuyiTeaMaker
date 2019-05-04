package shuyi.ingredient.water;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class HotWater extends Ingredient {
    public HotWater() {
        super(IngredientType.WATER);
    }

    @Override
    public String getDescriptions() {
        return "Hot water";
    }
}
