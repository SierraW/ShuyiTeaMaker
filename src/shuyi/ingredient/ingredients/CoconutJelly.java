package shuyi.ingredient.ingredients;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.operation.OperationType;

public class CoconutJelly extends Ingredient {

    public CoconutJelly() {
        super(IngredientType.INGREDIENT);
    }


    @Override
    public String getDescriptions() {
        return "椰果";
    }
}
