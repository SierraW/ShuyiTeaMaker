package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum InexactValue implements Values {
    ONE_TENTHS_CUP("杯身1/10"), TWO_TENTHS_CUP("杯身2/10"), THREE_TENTHS_CUP("杯身3/10"), FOUR_TENTHS_CUP("杯身4/10"), HALF_CUP("杯身5/10"), SIX_TENTHS_CUP("杯身6/10"), SEVEN_TENTHS_CUP("杯身7/10"), EIGHT_TENTHS_CUP("杯身8/10"), NINE_TENTHS_CUP("杯身9/10"), ALMOST_FULL_CUP("杯口0.5cm"), FULL_CUP("杯身10/10");

    private String value;

    private InexactValue(String value) {
        this.value = value;
    }

    @Override
    public Amount getValue() {
        return new Amount(toString());
    }

    @Override
    public String toString() {
        return "至" + value;
    }
}
