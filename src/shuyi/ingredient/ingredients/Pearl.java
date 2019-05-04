package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Pearl extends Ingredient {
    public Pearl() {
        super(IngredientType.INGREDIENT);
    }

    @Override
    public String getDescriptions() {
        return "珍珠";
    }
}
