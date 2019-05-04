package shuyi.product;

import shuyi.product.options.IceOptions;
import shuyi.product.options.SweetnessOptions;
import shuyi.product.options.TemOptions;

import java.io.File;

public interface ShuyiTealiciousTeas {
    boolean isColdOnly();
    boolean isAdjustableSweetness();
    File getFile();
}
