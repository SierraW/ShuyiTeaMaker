package shuyi.product;

import shuyi.product.options.IceOptions;
import shuyi.product.options.SweetnessOptions;
import shuyi.product.options.TemOptions;

import java.io.File;

public interface ShuyiTealiciousTeas {
    boolean isContainHotOption();
    boolean isContainColdOption();
    boolean isAdjustableSweetness();
    File getFile();
}
