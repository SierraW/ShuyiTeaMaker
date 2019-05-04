package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;

import java.io.Serializable;

public class Amount implements Serializable {
    private float amount;
    private String customAmount;
    public Amount(float amount) {
        this.amount = amount;
        customAmount = null;
    }

    public Amount(String amount) {
        this.customAmount = amount;
    }

    public void setAmount(float amount){
        this.amount = amount;
    }

    public void addAmount(float amount) {
        this.amount += amount;
    }

    public String getAmount() {
        if (customAmount == null) {
            return "" + amount;
        } else {
            return customAmount;
        }
    }

    public boolean isCustom() {
        if(customAmount == null) {
            return false;
        }
        return true;
    }
}
