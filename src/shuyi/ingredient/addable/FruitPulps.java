package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.fruit_pulp.MangoPulp;
import shuyi.ingredient.fruit_pulp.YangZhiPulp;

public enum FruitPulps implements Adable {
    YangZhiPulp, MangoPulp, LemonPulp, OrangePulp, Passion_Fruit_Pulp, Yakult, Grape_Juice,;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case Yakult:
                return new Ingredient(IngredientType.FRUIT_PULP) {
                    @Override
                    public String getDescriptions() {
                        return "优菌多";
                    }
                };
            case Passion_Fruit_Pulp:
                return new Ingredient(IngredientType.FRUIT_PULP) {
                    @Override
                    public String getDescriptions() {
                        return "冻浆百香果";
                    }
                };
            case OrangePulp:
                return new Ingredient(IngredientType.FRUIT_PULP) {
                    @Override
                    public String getDescriptions() {
                        return "冻浆柳橙";
                    }
                };
            case LemonPulp:
                return new Ingredient(IngredientType.FRUIT_PULP) {
                    @Override
                    public String getDescriptions() {
                        return "冻浆柠檬";
                    }
                };
            case MangoPulp:
                return new MangoPulp();
            case Grape_Juice:
                return new Ingredient(IngredientType.FRUIT_PULP) {
                    @Override
                    public String getDescriptions() {
                        return "葡萄汁";
                    }
                };
            case YangZhiPulp:
            default:
                return new YangZhiPulp();
        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
