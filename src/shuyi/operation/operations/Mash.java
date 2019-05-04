package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.operation.Operation;

public class Mash extends Operation {
    @Override
    public String getDescriptions() {
        return super.getDescriptions() + "捣碎";
    }

    @Override
    public boolean isAtDefaultAmount() {
        return false;
    }

    @Override
    public void addAmount(Operation operation) {
        return;
    }

    @Override
    public Ingredient getIngredient() {
        return null;
    }
}
