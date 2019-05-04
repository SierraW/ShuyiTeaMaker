package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.sugar.BrownSugar;
import shuyi.ingredient.sugar.FruitSugar;
import shuyi.ingredient.sugar.MangoSugar;

public enum Sugars implements Adable {
    FRUIT_SUGAR, BROWN_SUGAR, MANGO_SUGAR, ROASTED_SUGAR;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case ROASTED_SUGAR:
                return new Ingredient(IngredientType.SUGAR) {
                    @Override
                    public String getDescriptions() {
                        return "烤糖";
                    }
                };
            case BROWN_SUGAR:
                return new BrownSugar();
            case FRUIT_SUGAR:
                return new FruitSugar();
            case MANGO_SUGAR:
            default:
                return new MangoSugar();

        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
