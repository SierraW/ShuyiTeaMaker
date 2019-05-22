package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum NewProduct implements ShuyiTealiciousTeas {
    Boba_Jello_Green_Tea, Grape_Fig_Jello_Green_Tea, Grape_Yakult, Brown_Sugar, Caramel_Hot_Chocolate, Oreo_Hot_Chocolate;

    @Override
    public String toString() {
        switch (this) {
            case Grape_Yakult:
                return "葡萄优多";
            case Grape_Fig_Jello_Green_Tea:
                return "葡萄珍珠冻冻";
            case Boba_Jello_Green_Tea:
                return "柠檬爆爆珠冻冻";
            case Oreo_Hot_Chocolate:
                return "奥利奥珍珠可可";
            case Caramel_Hot_Chocolate:
                return "焦糖可可";
            case Brown_Sugar:
            default:
                return "黑糖珍珠奶茶";
        }
    }

    @Override
    public File getFile() {
        switch (this) {
            case Brown_Sugar:
                System.out.println("here");
                return new File("data/NewProduct/Brown_Sugar.dat");
            case Caramel_Hot_Chocolate:
                return new File("data/NewProduct/Caramel_Hot_Chocolate.dat");
            case Oreo_Hot_Chocolate:
                return new File("data/NewProduct/Oreo_Hot_Chocolate.dat");
            case Boba_Jello_Green_Tea:
                return new File("data/NewProduct/Boba_Jello_Green_Tea.dat");
            case Grape_Fig_Jello_Green_Tea:
                return new File("data/NewProduct/Grape_Fig_Jello_Green_Tea.dat");
            case Grape_Yakult:
            default:
                return new File("data/NewProduct/Grape_Yakult.dat");
        }
    }

    @Override
    public boolean isContainColdOption() {
        switch (this) {
            case Grape_Yakult:
                return true;
            case Grape_Fig_Jello_Green_Tea:
                return true;
            case Boba_Jello_Green_Tea:
                return true;
            case Oreo_Hot_Chocolate:
                return false;
            case Caramel_Hot_Chocolate:
                return false;
            case Brown_Sugar:
            default:
                return false;
        }
    }

    @Override
    public boolean isContainHotOption() {
        return !isContainColdOption();
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }
}
