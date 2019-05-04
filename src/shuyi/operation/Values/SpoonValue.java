package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum SpoonValue implements Values {
    HALF_SPOON(0.5f), FULL_SPOON(1), TWO_SPOON(2), THREE_SPOON(3), FOUR_SPOON(4), FIVE_SPOON(5);

    private final float amount;

    private SpoonValue(float amount) {
        this.amount = amount;
    }

    @Override
    public Amount getValue() {
        switch (this) {
            case HALF_SPOON:
                return new Amount(0.5f);
            case TWO_SPOON:
                return new Amount(2);
            case THREE_SPOON:
                return new Amount(3);
            case FOUR_SPOON:
                return new Amount(4);
            case FIVE_SPOON:
                return new Amount(5);
            case FULL_SPOON:
            default:
                return new Amount(1);
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case HALF_SPOON:
                return "0.5勺";
            case TWO_SPOON:
                return "2勺";
            case FIVE_SPOON:
                return "5勺";
            case FOUR_SPOON:
                return "4勺";
            case THREE_SPOON:
                return "3勺";
            case FULL_SPOON:
            default:
                return "1勺";
        }
    }
}
