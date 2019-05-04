package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Lime extends Ingredient {
    public Lime() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "青柠";
    }
}
