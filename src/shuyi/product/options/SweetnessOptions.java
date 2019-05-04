package shuyi.product.options;

public enum SweetnessOptions {
    NO_SUGAR, SUGAR_30, HALF_SUGAR, SUGAR_70, NORMAL;

    @Override
    public String toString() {
        switch (this) {
            case NO_SUGAR:
                return "无糖";
            case SUGAR_30:
                return "30%糖";
            case SUGAR_70:
                return "70%糖";
            case HALF_SUGAR:
                return "50%糖";
            case NORMAL:
            default:
                return "正常糖";
        }
    }
}
