package shuyi;

import shuyi.container.Container;
import shuyi.container.Cup;
import shuyi.container.MeasuringCup;
import shuyi.container.ShakeCup;
import shuyi.container.cup.LargeSizePlasticCup;
import shuyi.container.measuringcup.mc500;
import shuyi.container.shakecup.sc500;
import shuyi.product.Product;

public class Shuyi {
    private Product product;


    private Cup cup;
    private ShakeCup shakeCup;
    private MeasuringCup measuringCup;

    private Container mixerLeft;
    private Container mixerRight;

    public Shuyi() {
        product = new Product();
        cup = new LargeSizePlasticCup();
        shakeCup = new sc500();
        measuringCup = new mc500();

    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cup getCup() {
        return cup;
    }

    public ShakeCup getShakeCup() {
        return shakeCup;
    }

    public MeasuringCup getMeasuringCup() {
        return measuringCup;
    }

    public String getToMakeName() {
        return product.getDescriptions();
    }

    public Product getProduct() {
        return product;
    }

    public void setCup(Container cup) {
        this.cup = (Cup)cup;
    }

    public void setMeasuringCup(Container measuringCup) {
        this.measuringCup = (MeasuringCup)measuringCup;
    }

    public void setShakeCup(Container shakeCup) {
        this.shakeCup = (ShakeCup)shakeCup;
    }

    public boolean addToMixer(Container container) {
        if (this.mixerLeft == null) {
            mixerLeft = container;
            return true;
        } else if (this.mixerRight == null) {
            mixerRight = container;
            return true;
        } else {
            return false;
        }
    }

    public boolean isReadyToMix() {
        return mixerLeft != null && mixerRight != null;
    }

    public void cleanMixer() {
        mixerRight = null;
        mixerLeft = null;
    }

    public Container getMixerLeft() {
        return mixerLeft;
    }

    public Container getMixerRight() {
        return mixerRight;
    }
}
