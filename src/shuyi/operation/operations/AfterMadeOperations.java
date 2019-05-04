package shuyi.operation.operations;

import shuyi.operation.Operation;

public enum AfterMadeOperations {
    FINE_STRAW, WIDE_STRAW, ADD_SPOON, SEAL_TOP, CAP_TOP;

    public Operation getOperation() {
        switch (this) {
            case CAP_TOP:
                return new Capped();
            case SEAL_TOP:
                return new SealedTop();
            case ADD_SPOON:
                return new AddSpoon();
            case FINE_STRAW:
                return new AddFineStraw();
            case WIDE_STRAW:
            default:
                return new AddWideStraw();
        }
    }
}
