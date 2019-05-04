package shuyi.operation;

import org.jetbrains.annotations.NotNull;
import shuyi.ingredient.Ingredient;

import java.io.Serializable;

public abstract class Operation implements Serializable {
    public String prefix;

    public Operation() {
        prefix = null;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDescriptions() {
        if (prefix == null) {
            return "";
        }
        return "(" + prefix + ") ";
    }
    public abstract boolean isAtDefaultAmount();
    public abstract void addAmount(Operation operation);
    public abstract Ingredient getIngredient();
}
