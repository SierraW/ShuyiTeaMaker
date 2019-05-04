package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum ShakeCupValue implements Values {
    THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, SIX_HUNDRED, FULL;

    @Override
    public Amount getValue() {
        return new Amount("至" + toString());
    }

    @Override
    public String toString() {
        switch (this) {
            case FOUR:
                return "4分线";
            case THREE:
                return "3分线";
            case SIX:
                return "6分线";
            case TEN:
                return "10分线";
            case FIVE:
                return "5分线";
            case NINE:
                return "9分线";
            case EIGHT:
                return "8分线";
            case SIX_HUNDRED:
                return "600线";
            case FULL:
                return "雪克杯满";
            case SEVEN:
            default:
                return "7分线";
        }
    }
}
