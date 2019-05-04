package shuyi.container.measuringcup;

import shuyi.container.Cup;
import shuyi.container.CupType;
import shuyi.container.MeasuringCup;

public enum MeasureCupType implements CupType {

    ONE_HUNDRED, FIVE_HUNDRED;

    @Override
    public MeasuringCup getCup() {
        switch (this) {
            case ONE_HUNDRED:
                return new mc100();
            case FIVE_HUNDRED:
            default:
                return new mc500();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ONE_HUNDRED:
                return "100毫升量杯";
            case FIVE_HUNDRED:
            default:
                return "500毫升量杯";
        }
    }
}
