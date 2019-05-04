package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class CherryTomato extends Ingredient {
    public CherryTomato() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "圣女果";
    }
}
