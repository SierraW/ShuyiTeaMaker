package shuyi.ingredient.milktea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class SignatureColdMilkTea extends Ingredient {
    public SignatureColdMilkTea() {
        super(IngredientType.MILK_TEA);
    }

    @Override
    public String getDescriptions() {
        return "冰仙草奶茶";
    }
}
