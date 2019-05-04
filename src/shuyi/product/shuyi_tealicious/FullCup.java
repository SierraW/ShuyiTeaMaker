package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum FullCup implements ShuyiTealiciousTeas {
    Signature_Grass_Jelly_Milk_Tea_Large, Signature_Grass_Jelly_Milk_Tea_Medium, Mango_Pomelo_Meet_Grass_Jelly, Mango_Pudding_Jasmine_Milk_Tea, Caramel_Pudding_Jasmine_Milk_Tea, Fig_Jelly_Green_Tea;

    @Override
    public String toString() {
        switch (this) {
            case Signature_Grass_Jelly_Milk_Tea_Large:
                return "书亦烧仙草（大杯）";
            case Signature_Grass_Jelly_Milk_Tea_Medium:
                return "书亦烧仙草（中杯）";
            case Mango_Pomelo_Meet_Grass_Jelly:
                return "杨枝甘露烧仙草";
            case Mango_Pudding_Jasmine_Milk_Tea:
                return "芒果布丁奶绿";
            case Caramel_Pudding_Jasmine_Milk_Tea:
                return "那么大焦糖布丁";
            case Fig_Jelly_Green_Tea:
            default:
                return "满杯青柠爱玉";
        }
    }

    @Override
    public boolean isColdOnly() {
        switch (this) {
            case Signature_Grass_Jelly_Milk_Tea_Large:
            case Signature_Grass_Jelly_Milk_Tea_Medium:
                return false;
            default:
                return true;
        }
    }

    @Override
    public boolean isAdjustableSweetness() {
        switch (this) {
            case Signature_Grass_Jelly_Milk_Tea_Large:
            case Signature_Grass_Jelly_Milk_Tea_Medium:
                return false;
            case Mango_Pomelo_Meet_Grass_Jelly:
                return false;
            case Mango_Pudding_Jasmine_Milk_Tea:
                return false;
            case Caramel_Pudding_Jasmine_Milk_Tea:
                return false;
            case Fig_Jelly_Green_Tea:
            default:
                return true;
        }
    }

    @Override
    public File getFile() {
        switch (this) {
            case Fig_Jelly_Green_Tea:
                return new File("data/FullCup/Fig_Jelly_Green_Tea.dat");
            case Caramel_Pudding_Jasmine_Milk_Tea:
                return new File("data/FullCup/Caramel_Pudding_Jasmine_Milk_Tea.dat");
            case Mango_Pudding_Jasmine_Milk_Tea:
                return new File("data/FullCup/Mango_Pudding_Jasmine_Milk_Tea.dat");
            case Mango_Pomelo_Meet_Grass_Jelly:
                return new File("data/FullCup/Mango_Pomelo_Meet_Grass_Jelly.dat");
            case Signature_Grass_Jelly_Milk_Tea_Large:
                return new File("data/FullCup/Signature_Grass_Jelly_Milk_Tea_Large.dat");
            case Signature_Grass_Jelly_Milk_Tea_Medium:
            default:
                return new File("data/FullCup/Signature_Grass_Jelly_Milk_Tea_Medium.dat");
        }
    }
}
