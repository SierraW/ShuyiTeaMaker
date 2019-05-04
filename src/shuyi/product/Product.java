package shuyi.product;

import shuyi.product.options.IceOptions;
import shuyi.product.options.SweetnessOptions;
import shuyi.product.options.TemOptions;
import shuyi.product.shuyi_tealicious.MilkTea;
import shuyi.product.toppings.Toppings;

import java.io.File;
import java.util.ArrayList;

public class Product {
    private ProductSeries series;
    private ShuyiTealiciousTeas shuyiTealiciousTea;
    private IceOptions iceOptions;
    private SweetnessOptions sweetnessOptions;
    private TemOptions temOptions;
    private ArrayList<Toppings> toppingOptions;

    public Product() {
        random();
    }

    public Product(ProductSeries series, ShuyiTealiciousTeas teas) {
        this.series = series;
        this.shuyiTealiciousTea = teas;
        iceOptions = IceOptions.NORMAL;
        sweetnessOptions = SweetnessOptions.NORMAL;
        temOptions = TemOptions.COLD;
        toppingOptions = new ArrayList<>();
    }

    public File getFile() {
        return shuyiTealiciousTea.getFile();
    }

    public void random() {
        series = ProductSeries.values()[ProductSeries.getRandomNumber(ProductSeries.values().length)];
        shuyiTealiciousTea = series.getRandomTeas();
        if (shuyiTealiciousTea.isColdOnly()) {
            temOptions = TemOptions.COLD;
            iceOptions = IceOptions.values()[ProductSeries.getRandomNumber(IceOptions.values().length)];
        } else {
            temOptions = TemOptions.values()[ProductSeries.getRandomNumber(TemOptions.values().length)];
            iceOptions = IceOptions.NO_ICE;
        }
        if (shuyiTealiciousTea.isAdjustableSweetness()) {
            sweetnessOptions = SweetnessOptions.values()[ProductSeries.getRandomNumber(SweetnessOptions.values().length)];
        } else {
            sweetnessOptions = SweetnessOptions.NORMAL;
        }
        int ranNum = ProductSeries.getRandomNumber(10);
        toppingOptions = new ArrayList<>();
        if (ranNum < 5) {

        } else if (ranNum < 8) {
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
        } else if (ranNum < 10) {
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
        } else {
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
            toppingOptions.add(Toppings.values()[ProductSeries.getRandomNumber(Toppings.values().length)]);
        }
    }

    public String getDescriptions() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Toppings toppings : toppingOptions) {
            stringBuilder.append("[加");
            stringBuilder.append(toppings);
            stringBuilder.append("]");
        }
        if(temOptions == TemOptions.COLD && shuyiTealiciousTea == MilkTea.Oolong_Milk_Tea_with_Oats_Hot) {
            return series + ": " + shuyiTealiciousTea + " (" + iceOptions + ", " + sweetnessOptions + ")" + stringBuilder.toString();
        }
        return series + ": " + shuyiTealiciousTea + " (" + iceOptions + ", " + sweetnessOptions + ", " + temOptions + ")" + stringBuilder.toString();
    }

    public String getAnswer() {
        return ProductSerializer.read(getFile()).printCup();
    }
}
