package shuyi.operate;

import org.jetbrains.annotations.NotNull;
import shuyi.container.Container;
import shuyi.operation.Operation;
import shuyi.operation.operations.*;

public class Operate {
    public static void addIngredient(@NotNull Container container, IngredientWithAmount ingredientWithAmount) {
        container.operate(ingredientWithAmount);
    }

    public static void pourIn(@NotNull Container containerIn, @NotNull Container containerPour) {
        containerIn.pourIn(containerPour.getOperationList(), containerPour);
        containerPour.empty();
    }

    public static void shake(@NotNull Container container) {
        container.operate(new Shake());
    }

    public static void skim(@NotNull Container container) {
        container.operate(new Skim());
    }

    public static void stir(@NotNull Container container) {
        container.operate(new Stir());
    }

    public static void customOperation(@NotNull Container container, Operation operation) {
        container.operate(operation);
    }
}
