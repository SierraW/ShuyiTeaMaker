package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Peanut extends Ingredient {

    public Peanut() {
        super(IngredientType.INGREDIENT);
    }

    @Override
    public String getDescriptions() {
        return "花生";
    }
}
