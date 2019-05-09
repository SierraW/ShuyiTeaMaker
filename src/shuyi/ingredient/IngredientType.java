package shuyi.ingredient;

import shuyi.operation.OperationType;

public enum IngredientType {
    TEA, FRUIT, FRUIT_PULP, SUGAR, INGREDIENT, WATER, ICE, MILK_TEA, POWDER, CHEESE_CAP, NOTE;

    public OperationType getOperationType() {
        switch (this) {
            case FRUIT:
            case INGREDIENT:
            case POWDER:
                return OperationType.SPOON;
            case ICE:
            case MILK_TEA:
            case WATER:
            case FRUIT_PULP:
            case TEA:
            case SUGAR:
            case CHEESE_CAP:
            default:
                return OperationType.POUR;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case FRUIT:
                return "水果/水果丁";
            case SUGAR:
                return "糖浆类";
            case ICE:
                return "冰块";
            case FRUIT_PULP:
                return "水果浆类/优菌多";
            case MILK_TEA:
                return "仙草奶茶/奶绿/奶";
            case TEA:
                return "茶类";
            case WATER:
                return "水";
            case INGREDIENT:
                return "添加物";
            case CHEESE_CAP:
                return "奶盖";
            case NOTE:
                return "备注";
            case POWDER:
            default:
                return "粉状物";
        }
    }
}
