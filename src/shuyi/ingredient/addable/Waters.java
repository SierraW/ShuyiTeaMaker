package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.water.ColdWater;
import shuyi.ingredient.water.HotWater;

public enum Waters implements Adable {
    WATER_HOT, WATER_COLD;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case WATER_HOT:
                return new HotWater();
            case WATER_COLD:
            default:
                return new ColdWater();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
