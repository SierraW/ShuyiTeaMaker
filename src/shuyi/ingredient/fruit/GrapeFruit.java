package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class GrapeFruit extends Ingredient {
    public GrapeFruit() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "葡萄柚碎";
    }
}
