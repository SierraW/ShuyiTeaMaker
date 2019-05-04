package shuyi.product.shuyi_tealicious;

import shuyi.product.ShuyiTealiciousTeas;

import java.io.File;

public enum HandmadeFreshTea implements ShuyiTealiciousTeas {
    Taiwan_Oolong, Fresh_Jasmine;

    @Override
    public String toString() {
        switch (this) {
            case Taiwan_Oolong:
                return "台湾四季春茶";
            case Fresh_Jasmine:
            default:
                return "茉莉清茶";
        }
    }

    @Override
    public boolean isColdOnly() {
        return true;
    }

    @Override
    public boolean isAdjustableSweetness() {
        return true;
    }

    @Override
    public File getFile() {
        switch (this) {
            case Fresh_Jasmine:
                return new File("data/HandmadeFreshTea/Fresh_Jasmine.dat");
            case Taiwan_Oolong:
            default:
                return new File("data/HandmadeFreshTea/Taiwan_Oolong.dat");

        }
    }
}
