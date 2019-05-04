package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum MilliLiterValue implements Values {
    FIVE(5), TEN(10), FIFTEEN(15), TWENTY(20), TWENTY_FIVE(25), THIRTY(30), THIRTY_FIVE(35), FORTY(40), FORTY_FIVE(45), FIFTY(50), FIFTY_FIVE(55), SEVENTY_FIVE(75), HUNDRED(100), TWO_HUNDRED(200), TWO_HUNDRED_TEN(210), TWO_HUNDRED_TWENTY_FIVE(225), TWO_HUNDRED_FIFTY(250), THREE_HUNDRED(300), FOUR_HUNDRED(400);

    private final int value;

    private MilliLiterValue(int value) {
        this.value = value;
    }

    @Override
    public Amount getValue() {
        return new Amount(value);
    }

    @Override
    public String toString() {
        return this.value + "ml";
    }
}
