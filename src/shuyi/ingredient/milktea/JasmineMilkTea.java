package shuyi.ingredient.milktea;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public class JasmineMilkTea extends Ingredient {
    public JasmineMilkTea() {
        super(IngredientType.MILK_TEA);
    }

    @Override
    public String getDescriptions() {
        return "奶绿";
    }
}
