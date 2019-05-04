package shuyi.ingredient.sugar;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class BrownSugar extends Ingredient {
    public BrownSugar() {
        super(IngredientType.SUGAR);
    }

    @Override
    public String getDescriptions() {
        return "焦糖";
    }
}
