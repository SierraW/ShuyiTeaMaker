package shuyi.ingredient.addable;

import shuyi.ingredient.Adable;
import shuyi.ingredient.Ingredient;
import shuyi.ingredient.IngredientType;
import shuyi.ingredient.fruit.GrapeFruit;
import shuyi.ingredient.fruit.Mango;
import shuyi.ingredient.ingredients.*;

public enum Ingredients implements Adable {
    COCONUT_JELLY, DRY_GRAPE, GRASS_JELLY, PEANUT, PEARL, RED_BEAN, FIG_JELLY, BLACK_BRICK_JELLY, OATS, PINEAPPLE_JELLY, CARAMEL_PUDDING, HONEY_POMELO, PINEAPPLE_PULP, YOGURT_POP_PEARL, MANGO_POP_PEARL;

    @Override
    public Ingredient getIngredient() {
        switch (this) {
            case PINEAPPLE_PULP:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "菠萝丁酱";
                    }
                };
            case HONEY_POMELO:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "蜂蜜柚子酱";
                    }
                };
            case PEARL:
                return new Pearl();
            case PEANUT:
                return new Peanut();
            case RED_BEAN:
                return new RedBean();
            case DRY_GRAPE:
                return new DryGrape();
            case GRASS_JELLY:
                return new GrassJelly();
            case OATS:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "燕麦";
                    }
                };
            case FIG_JELLY:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "爱玉冻";
                    }
                };
            case CARAMEL_PUDDING:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "焦糖布丁";
                    }
                };
            case PINEAPPLE_JELLY:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "凤梨水晶";
                    }
                };
            case BLACK_BRICK_JELLY:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "黑砖";
                    }
                };
            case MANGO_POP_PEARL:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "芒果爆爆珠";
                    }
                };
            case YOGURT_POP_PEARL:
                return new Ingredient(IngredientType.INGREDIENT) {
                    @Override
                    public String getDescriptions() {
                        return "酸奶爆爆珠";
                    }
                };
            case COCONUT_JELLY:
            default:
                return new CoconutJelly();

        }
    }

    @Override
    public String toString() {
        return getIngredient().getDescriptions();
    }
}
