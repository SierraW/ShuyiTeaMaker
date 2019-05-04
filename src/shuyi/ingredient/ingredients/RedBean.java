package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class RedBean extends Ingredient {

    public RedBean() {
        super(IngredientType.INGREDIENT);
    }

    @Override
    public String getDescriptions() {
        return "红豆";
    }
}
