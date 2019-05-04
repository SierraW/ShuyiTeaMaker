package shuyi.container;

import shuyi.container.measuringcup.MeasureCupType;

public class MeasuringCup extends Container{
    private final MeasureCupType SIZE;

    protected MeasuringCup(MeasureCupType size) {
        this.SIZE = size;
    }

    @Override
    public String printCup() {
        return SIZE + ":\nOperations:" + this.getDescriptions();
    }

    @Override
    public String getName() {
        return SIZE.toString();
    }
}
