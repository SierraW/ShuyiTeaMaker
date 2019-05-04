package shuyi.ingredient.cheese_cap;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class CheeseCap extends Ingredient {
    public CheeseCap() {
        super(IngredientType.CHEESE_CAP);
    }

    @Override
    public String getDescriptions() {
        return "奶盖";
    }
}
