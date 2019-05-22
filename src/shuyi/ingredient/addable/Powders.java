package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.powder.MilkPowder;
import shuyi.ingredient.powder.SugarPowder;

public enum Powders implements Adable {
    MILK_POWDER, SugarPowder, MatchaPoder, CHOCOLATE_POWDER, CRACKED_COOKIE;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case MatchaPoder:
                return new Ingredient(IngredientType.POWDER) {
                    @Override
                    public String getDescriptions() {
                        return "抹茶粉";
                    }
                };
            case SugarPowder:
                return new SugarPowder();
            case CHOCOLATE_POWDER:
                return new Ingredient(IngredientType.POWDER) {
                    @Override
                    public String getDescriptions() {
                        return "巧克力粉";
                    }
                };
            case CRACKED_COOKIE:
                return new Ingredient(IngredientType.POWDER) {
                    @Override
                    public String getDescriptions() {
                        return "饼干碎";
                    }
                };
            case MILK_POWDER:
            default:
                return new MilkPowder();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
