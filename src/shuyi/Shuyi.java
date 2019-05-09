package shuyi;

import shuyi.container.Container;
import shuyi.container.Cup;
import shuyi.container.MeasuringCup;
import shuyi.container.ShakeCup;
import shuyi.container.cup.LargeSizePlasticCup;
import shuyi.container.measuringcup.mc100;
import shuyi.container.measuringcup.mc500;
import shuyi.container.shakecup.sc500;
import shuyi.product.Product;

public class Shuyi {
    private Product product;


    private Cup cup;
    private ShakeCup shakeCup;
    private MeasuringCup measuringCup;
    private MeasuringCup measuringCup100;

    private Container mixerLeft;
    private Container mixerRight;

    public Shuyi() {
        product = new Product();
        cup = new LargeSizePlasticCup();
        shakeCup = new sc500();
        measuringCup = new mc500();
        measuringCup100 = new mc100();

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

    public MeasuringCup getMeasuringCup100() {
        return measuringCup100;
    }

    public String getToMakeName() {
        return "当前饮品：" + product.getDescriptions();
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

    public void setMeasuringCup100(Container measuringCup100) {
        this.measuringCup100 = (MeasuringCup)measuringCup100;
    }

    public void setShakeCup(Container shakeCup) {
        this.shakeCup = (ShakeCup)shakeCup;
    }

    public boolean addToMixer(Container container) {
        if (container == null && mixerLeft == null) {
            return false;
        }
        if (container == null && (mixerLeft instanceof MeasuringCup)){
            return false;
        }
        if (container == null) {
            container = new Container() {
                @Override
                public String getName() {
                    return "100量杯与500量杯";
                }

                @Override
                public String printCup() {
                    return "100量杯与500量杯";
                }
            };
        }
        if (this.mixerLeft == null) {
            mixerLeft = container;
            return true;
        } else if (this.mixerRight == null) {
            if (this.mixerLeft == container) {
                return false;
            }
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

    public void emptyAll() {
        cup.empty();
        measuringCup.empty();
        measuringCup100.empty();
        shakeCup.empty();
        cleanMixer();
    }
}
