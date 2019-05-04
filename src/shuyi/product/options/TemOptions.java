package shuyi.product.options;

public enum TemOptions {
    HOT, WARM, COLD;

    @Override
    public String toString() {
        switch (this) {
            case HOT:
                return "热";
            case WARM:
                return "温";
            case COLD:
            default:
                return "冷";
        }
    }
}
