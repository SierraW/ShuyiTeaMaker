package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.ice.Ice;

public enum Ices implements Adable {
    ICE;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case ICE:
            default:
                return new Ice();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
