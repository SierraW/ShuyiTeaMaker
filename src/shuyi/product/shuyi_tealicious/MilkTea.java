package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum MilkTea implements ShuyiTealiciousTeas {
    Royal_No_1, Caramel_Bubble_Tea, Oolong_Milk_Tea_with_Oats_Cold, Oolong_Milk_Tea_with_Oats_Hot, Roasted_Red_Bean_and_Pudding, Signature_Golden_Bubble, Oolong_Roasted_Milk_Tea, Coconut_Jelly_Milk_Tea, Red_Bean_Matcha_Latte;

    @Override
    public String toString() {
        switch (this) {
            case Royal_No_1:
                return "牛魔王黑砖奶茶";
            case Caramel_Bubble_Tea:
                return "焦糖珍奶";
            case Oolong_Milk_Tea_with_Oats_Cold:
                return "四季春燕麦奶茶(冰)";
            case Oolong_Milk_Tea_with_Oats_Hot:
                return "四季春燕麦奶茶(热)";
            case Roasted_Red_Bean_and_Pudding:
                return "红豆布丁烤奶";
            case Signature_Golden_Bubble:
                return "黄金珍奶";
            case Oolong_Roasted_Milk_Tea:
                return "乌龙烤奶";
            case Coconut_Jelly_Milk_Tea:
                return "椰果奶茶";
            case Red_Bean_Matcha_Latte:
            default:
                return "抹茶红豆拿铁";
        }
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }

    @Override
    public boolean isContainColdOption() {
        switch (this) {
            case Oolong_Milk_Tea_with_Oats_Hot:
                return false;
            default:
                return true;
        }
    }

    @Override
    public boolean isContainHotOption() {
        switch (this) {
            case Oolong_Milk_Tea_with_Oats_Cold:
                return false;
            default:
                return true;
        }
    }

    @Override
    public File getFile() {
        switch (this) {
            case Red_Bean_Matcha_Latte:
                return new File("data/MilkTea/Red_Bean_Matcha_Latte.dat");
            case Coconut_Jelly_Milk_Tea:
                return new File("data/MilkTea/Coconut_Jelly_Milk_Tea.dat");
            case Oolong_Roasted_Milk_Tea:
                return new File("data/MilkTea/Oolong_Roasted_Milk_Tea.dat");
            case Signature_Golden_Bubble:
                return new File("data/MilkTea/Signature_Golden_Bubble.dat");
            case Roasted_Red_Bean_and_Pudding:
                return new File("data/MilkTea/Roasted_Red_Bean_and_Pudding.dat");
            case Oolong_Milk_Tea_with_Oats_Cold:
                return new File("data/MilkTea/Oolong_Milk_Tea_with_Oats_Cold.dat");
            case Oolong_Milk_Tea_with_Oats_Hot:
                return new File("data/MilkTea/Oolong_Milk_Tea_with_Oats_Hot.dat");
            case Caramel_Bubble_Tea:
                return new File("data/MilkTea/Caramel_Bubble_Tea.dat");
            case Royal_No_1:
            default:
                return new File("data/MilkTea/Royal_No_1.dat");
        }
    }
}
