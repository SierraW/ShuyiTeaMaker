package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.cheese_cap.CheeseCap;

public enum CheeseCaps implements Adable {
    CHEESE_CAPS;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case CHEESE_CAPS:
            default:
                return new CheeseCap();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
