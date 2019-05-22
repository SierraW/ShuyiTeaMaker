package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum FreshFruitYakult implements ShuyiTealiciousTeas {
    Pomelo_Yakult, Passion_Fruit_Yakult, Lemon_Yakult;

    @Override
    public String toString() {
        switch (this) {
            case Pomelo_Yakult:
                return "葡萄柚益菌多";
            case Passion_Fruit_Yakult:
                return "百香优多";
            case Lemon_Yakult:
            default:
                return "柠檬益菌多";
        }
    }

    @Override
    public boolean isContainColdOption() {
        return true;
    }

    @Override
    public boolean isContainHotOption() {
        return false;
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }

    @Override
    public File getFile() {
        switch (this) {
            case Lemon_Yakult:
                return new File("data/FreshFruitYakult/Lemon_Yakult.dat");
            case Passion_Fruit_Yakult:
                return new File("data/FreshFruitYakult/Passion_Fruit_Yakult.dat");
            case Pomelo_Yakult:
            default:
                return new File("data/FreshFruitYakult/Pomelo_Yakult.dat");
        }
    }
}
