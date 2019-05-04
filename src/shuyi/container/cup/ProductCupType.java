package shuyi.container.cup;

import shuyi.container.Cup;
import shuyi.container.CupType;

public enum ProductCupType implements CupType {
    LARGE_PLASTIC, MID_PLASTIC, LARGE_PAPER, MID_PAPER;

    @Override
    public String toString() {
        switch (this) {
            case LARGE_PAPER:
                return "大纸杯";
            case LARGE_PLASTIC:
                return "大塑料杯";
            case MID_PAPER:
                return "中纸杯";
            case MID_PLASTIC:
            default:
                return "中塑料杯";
        }
    }

    @Override
    public Cup getCup() {
        switch (this) {
            case MID_PAPER:
                return new MidSizePaperCup();
            case LARGE_PLASTIC:
                return new LargeSizePlasticCup();
            case LARGE_PAPER:
                return new LargeSizePaperCup();
            case MID_PLASTIC:
            default:
                return new MidSizePlasticCup();
        }
    }
}
