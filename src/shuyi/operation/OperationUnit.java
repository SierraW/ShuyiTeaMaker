package shuyi.operation;

public enum OperationUnit {
    MilliLiter, SPOON, PIECES, LINE;

    @Override
    public String toString() {
        switch (this) {
            case SPOON:
                return "spoon(s)";
            case MilliLiter:
                return "ml";
            case PIECES:
                return "piece(s)";
            case LINE:
                return "th line";
            default:
                return "error";
        }
    }
}
