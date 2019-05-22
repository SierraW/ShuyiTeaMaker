package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;
import shuyi.product.options.IceOptions;

import java.io.File;

public enum FreshCheeseTea implements ShuyiTealiciousTeas {
    Salty_Cream_Oolong, Salty_Cream_Black_Tea, Salty_Cream_Tippy_Jasmine_Tea, Salty_Cream_Matcha;

    @Override
    public String toString() {
        switch (this) {
            case Salty_Cream_Oolong:
                return "芝士四季春";
            case Salty_Cream_Black_Tea:
                return "芝士蜜香红玉";
            case Salty_Cream_Tippy_Jasmine_Tea:
                return "芝士毛尖茉莉";
            case Salty_Cream_Matcha:
            default:
                return "芝士抹茶";
        }
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }

    @Override
    public boolean isContainColdOption() {
        return true;
    }

    @Override
    public boolean isContainHotOption() {
        return true;
    }

    @Override
    public File getFile() {
        switch (this) {
            case Salty_Cream_Oolong:
                return new File("data/FreshCheeseTea/SaltyCreamOolong.dat");
            case Salty_Cream_Black_Tea:
                return new File("data/FreshCheeseTea/SaltyCreamBlackTea.dat");
            case Salty_Cream_Tippy_Jasmine_Tea:
                return new File("data/FreshCheeseTea/SaltyCreamTippyJasmineTea.dat");
            case Salty_Cream_Matcha:
            default:
                return new File("data/FreshCheeseTea/SaltyCreamMatcha.dat");
        }
    }
}
