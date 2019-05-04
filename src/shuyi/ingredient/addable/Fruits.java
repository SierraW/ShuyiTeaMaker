package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.fruit.*;

public enum Fruits implements Adable {
    CHERRY_TOMATO, GRAPE_FRUIT, GREEN_ORANGE, LEMON, LIME, MANGO, ORANGE;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case GRAPE_FRUIT:
                return new GrapeFruit();
            case MANGO:
                return new Mango();
            case LIME:
                return new Lime();
            case LEMON:
                return new Lemon();
            case ORANGE:
                return new Orange();
            case GREEN_ORANGE:
                return new GreenOrange();
            case CHERRY_TOMATO:
            default:
                return new CherryTomato();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
