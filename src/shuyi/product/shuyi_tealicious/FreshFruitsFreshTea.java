package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum FreshFruitsFreshTea implements ShuyiTealiciousTeas {
    Pineapple_and_Passion_Fruit, Fruits_Party, Pineapple_Jasmine, Fresh_Orange_and_Pomelo, Orange_King, Honey_Pomelo_Tea, Kumquat_Lemon;

    @Override
    public String toString() {
        switch (this) {
            case Pineapple_and_Passion_Fruit:
                return "百香凤梨";
            case Fruits_Party:
                return "超级水果茶";
            case Pineapple_Jasmine:
                return "金菠萝茉莉";
            case Fresh_Orange_and_Pomelo:
                return "鲜橙葡萄柚";
            case Orange_King:
                return "霸气鲜橙";
            case Honey_Pomelo_Tea:
                return "蜂蜜柚子茶";
            case Kumquat_Lemon:
            default:
                return "金桔柠檬";
        }
    }

    @Override
    public boolean isColdOnly() {
        switch (this) {
            case Honey_Pomelo_Tea:
                return false;
            default:
                return true;
        }
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }

    @Override
    public File getFile() {
        switch (this) {
            case Pineapple_and_Passion_Fruit:
                return new File("data/FreshFruitsFreshTea/Pineapple_and_Passion_Fruit.dat");
            case Honey_Pomelo_Tea:
                return new File("data/FreshFruitsFreshTea/Honey_Pomelo_Tea.dat");
            case Orange_King:
                return new File("data/FreshFruitsFreshTea/Orange_King.dat");
            case Fresh_Orange_and_Pomelo:
                return new File("data/FreshFruitsFreshTea/Fresh_Orange_and_Pomelo.dat");
            case Pineapple_Jasmine:
                return new File("data/FreshFruitsFreshTea/Pineapple_Jasmine.dat");
            case Fruits_Party:
                return new File("data/FreshFruitsFreshTea/Fruits_Party.dat");
            case Kumquat_Lemon:
            default:
                return new File("data/FreshFruitsFreshTea/Kumquat_Lemon.dat");
        }
    }
}
