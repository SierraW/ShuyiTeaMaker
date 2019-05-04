package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;

public enum  Note implements Adable {
    NOTE;

    @Override
    public Ingredient getIngredient() {
        return new Ingredient(IngredientType.NOTE) {
            @Override
            public String getDescriptions() {
                return "备注";
            }
        };
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
