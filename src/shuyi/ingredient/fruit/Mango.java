package shuyi.ingredient.fruit;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class Mango extends Ingredient {
    public Mango() {
        super(IngredientType.FRUIT);
    }

    @Override
    public String getDescriptions() {
        return "θζδΈ";
    }
}
