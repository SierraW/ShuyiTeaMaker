package shuyi.ingredient.ice;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Ice extends Ingredient {

    public Ice() {
        super(IngredientType.ICE);
    }

    @Override
    public String getDescriptions() {
        return "冰块";
    }

}
