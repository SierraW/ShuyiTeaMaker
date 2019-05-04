package shuyi.ingredient.sugar;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class FruitSugar extends Ingredient {
    public FruitSugar() {
        super(IngredientType.SUGAR);
    }

    @Override
    public String getDescriptions() {
        return "果糖";
    }
}
