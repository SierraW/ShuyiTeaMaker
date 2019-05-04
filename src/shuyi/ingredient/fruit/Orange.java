package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Orange extends Ingredient {
    public Orange() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "鲜橙";
    }
}
