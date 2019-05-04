package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.operation.Operation;

public class Squeeze extends Operation {
    @Override
    public String getDescriptions() {
        return super.getDescriptions() + "手动压汁机挤压3下";
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
