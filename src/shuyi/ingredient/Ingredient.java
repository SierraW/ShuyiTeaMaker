package shuyi.ingredient;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import shuyi.operation.OperationType;

import java.io.Serializable;

public abstract class Ingredient implements Serializable {

    private IngredientType ingredientType;

    @Contract(pure = true)
    protected Ingredient(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public abstract String getDescriptions();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ingredient) {
            if (this.getDescriptions().equals(((Ingredient) obj).getDescriptions())) {
                return true;
            }
        }
        return false;
    }
}
