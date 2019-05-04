package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.operation.Operation;

import java.io.Serializable;

public class IngredientWithAmount extends Operation{
    private Ingredient ingredient;
    private Amount amount;

    public IngredientWithAmount(Ingredient ingredient, float amount) {
        this.ingredient = ingredient;
        this.amount = new Amount(amount);
    }

    public IngredientWithAmount(Ingredient ingredient, String amount) {
        this.ingredient = ingredient;
        this.amount = new Amount(amount);
    }

    public IngredientWithAmount(Ingredient ingredient, Amount amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public String getAmount() {
        return amount.getAmount();
    }

    @Override
    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public String getDescriptions() {
        if (amount.isCustom()) {
            return super.getDescriptions() + ingredient.getDescriptions() + ": " + getAmount();
        }
        return super.getDescriptions() + ingredient.getDescriptions() + ": " + getAmount() + " " + ingredient.getIngredientType().getOperationType().getUnit();
    }

    @Override
    public boolean isAtDefaultAmount() {
        if (!this.amount.isCustom()) {
            return true;
        }
        return false;
    }

    @Override
    public void addAmount(Operation operation) {
        if (operation.isAtDefaultAmount()) {
            float amount = Float.parseFloat(((IngredientWithAmount)operation).amount.getAmount());
            this.amount.addAmount(amount);
        }
        return;
    }
}
