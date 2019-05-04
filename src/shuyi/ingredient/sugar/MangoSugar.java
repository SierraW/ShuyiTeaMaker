package shuyi.ingredient.sugar;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class MangoSugar extends Ingredient {
    public MangoSugar() {
        super(IngredientType.SUGAR);
    }

    @Override
    public String getDescriptions() {
        return "芒果糖浆";
    }
}
