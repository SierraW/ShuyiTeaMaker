package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class GreenOrange extends Ingredient {
    public GreenOrange() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "青桔";
    }
}
