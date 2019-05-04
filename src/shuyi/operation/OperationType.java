package shuyi.operation;

public enum OperationType {
    SPOON, POUR, CLIP, FILL;

    public OperationUnit getUnit() {
        switch (this) {
            case CLIP:
                return OperationUnit.PIECES;
            case FILL:
                return OperationUnit.LINE;
            case POUR:
                return OperationUnit.MilliLiter;
            case SPOON:
            default:
                return OperationUnit.SPOON;
        }
    }
}
