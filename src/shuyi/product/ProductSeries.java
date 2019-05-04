package shuyi.product;

import shuyi.ingredient.fruit.Mango;
import shuyi.product.shuyi_tealicious.*;

public enum ProductSeries {
    FULL_CUP, FRESH_FRUIT_YAKULT, FRESH_FRUITS_FRESH_TEA, MILK_TEA, FRESH_CHEESE_TEA, HANDMADE_FRESH_TEA;

    @Override
    public String toString() {
        switch (this) {
            case FULL_CUP:
                return "Full Cup";
            case MILK_TEA:
                return "Milk Tea";
            case FRESH_CHEESE_TEA:
                return "Fresh Cheese Tea";
            case FRESH_FRUIT_YAKULT:
                return "Fresh Fruit Yakult";
            case HANDMADE_FRESH_TEA:
                return "Handmade Fresh Tea";
            case FRESH_FRUITS_FRESH_TEA:
                return "Fresh Fruits Fresh Tea";
            default:
                return "No Such Type";
        }
    }

    public ShuyiTealiciousTeas getRandomTeas() {
        switch (this) {
            case FULL_CUP:
                return FullCup.values()[getRandomNumber(FullCup.values().length)];
            case FRESH_FRUITS_FRESH_TEA:
                return FreshFruitsFreshTea.values()[getRandomNumber(FreshFruitsFreshTea.values().length)];
            case HANDMADE_FRESH_TEA:
                return HandmadeFreshTea.values()[getRandomNumber(HandmadeFreshTea.values().length)];
            case FRESH_FRUIT_YAKULT:
                return FreshFruitYakult.values()[getRandomNumber(FreshFruitYakult.values().length)];
            case FRESH_CHEESE_TEA:
                return FreshCheeseTea.values()[getRandomNumber(FreshCheeseTea.values().length)];
            case MILK_TEA:
            default:
                return MilkTea.values()[getRandomNumber(MilkTea.values().length)];
        }
    }

    public static int getRandomNumber(int max) {
        return (int)(Math.random() * max);
    }
}
