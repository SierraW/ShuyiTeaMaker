package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.operation.Operation;

public class Shake extends Operation {
    @Override
    public String getDescriptions() {
        return super.getDescriptions() + "雪克机雪克";
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
