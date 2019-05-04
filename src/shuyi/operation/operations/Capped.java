package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.operation.Operation;

public class Capped extends Operation {
    @Override
    public String getDescriptions() {
        return super.getDescriptions() + "加盖子";
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
