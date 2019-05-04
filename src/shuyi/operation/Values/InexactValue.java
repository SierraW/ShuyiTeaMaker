package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum InexactValue implements Values {
    ONE_TENTHS_CUP("1/10"), TWO_TENTHS_CUP("2/10"), THREE_TENTHS_CUP("3/10"), FOUR_TENTHS_CUP("4/10"), HALF_CUP("5/10"), SIX_TENTHS_CUP("6/10"), SEVEN_TENTHS_CUP("7/10"), EIGHT_TENTHS_CUP("8/10"), NINE_TENTHS_CUP("9/10"), FULL_CUP("10/10(杯口0.5cm)");

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
        return "至杯身" + value;
    }
}
