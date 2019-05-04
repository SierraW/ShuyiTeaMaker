package shuyi.operation.operations;

import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.water.HotWater;
import shuyi.operation.Operation;

public class CraftTea extends Operation {

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

    @Override
    public String getDescriptions() {
        return super.getDescriptions() + "萃茶:225ml(8分线)热水，皇家茶包，萃茶机1档+5档萃茶，倒入";
    }
}
