package shuyi.container;

import shuyi.container.cup.ProductCupType;

import java.io.Serializable;

public class Cup extends Container {
    private String productName;
    private final ProductCupType SIZE;

    protected Cup(ProductCupType cupType) {
        this.SIZE = cupType;
        productName = null;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public void emptyCup() {
        this.empty();
    }

    @Override
    public String printCup() {
        if (productName != null) {
            return productName + "\n" + SIZE + ":\nOperations:" + this.getDescriptions();
        }
        return SIZE + ":\nOperations:" + this.getDescriptions();
    }

    @Override
    public String getName() {
        return SIZE.toString();
    }
}
