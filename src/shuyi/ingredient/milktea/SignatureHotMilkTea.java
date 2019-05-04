package shuyi.ingredient.milktea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class SignatureHotMilkTea extends Ingredient {
    public SignatureHotMilkTea() {
        super(IngredientType.MILK_TEA);
    }

    @Override
    public String getDescriptions() {
        return "热仙草奶茶";
    }
}
