package shuyi.ingredient.fruit_pulp;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class MangoPulp extends Ingredient {
    public MangoPulp() {
        super(IngredientType.FRUIT_PULP);
    }

    @Override
    public String getDescriptions() {
        return "芒果浆";
    }
}
