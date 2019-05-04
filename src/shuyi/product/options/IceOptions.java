package shuyi.product.options;

public enum IceOptions {
    NO_ICE, LESS_ICE, NORMAL;

    @Override
    public String toString() {
        switch (this) {
            case NO_ICE:
                return "飞冰";
            case LESS_ICE:
                return "少冰";
            case NORMAL:
            default:
                return "正常冰";
        }
    }
}
