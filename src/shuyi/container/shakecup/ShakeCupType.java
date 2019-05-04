package shuyi.container.shakecup;

import shuyi.container.CupType;
import shuyi.container.ShakeCup;

public enum ShakeCupType implements CupType {
    FIVE_HUNDRED, SEVEN_HUNDRED;

    @Override
    public ShakeCup getCup() {
        switch (this) {
            case SEVEN_HUNDRED:
                return new sc700();
            case FIVE_HUNDRED:
            default:
                return new sc500();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case SEVEN_HUNDRED:
                return "700毫升雪克杯";
            case FIVE_HUNDRED:
            default:
                return "500毫升雪克杯";
        }
    }
}
