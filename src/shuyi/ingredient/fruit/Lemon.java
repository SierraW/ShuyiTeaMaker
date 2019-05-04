package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Lemon extends Ingredient {
    public Lemon() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "黄柠";
    }
}
