package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.tea.BlackTea;
import shuyi.ingredient.tea.GreenTea;
import shuyi.ingredient.tea.OolongTea;
import shuyi.ingredient.tea.RoastedTea;

public enum Teas implements Adable {
    BLACK_TEA, GREEN_TEA, OOLONG_TEA, ROASTED_TEA;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case GREEN_TEA:
                return new GreenTea();
            case OOLONG_TEA:
                return new OolongTea();
            case ROASTED_TEA:
                return new RoastedTea();
            case BLACK_TEA:
            default:
                return new BlackTea();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
