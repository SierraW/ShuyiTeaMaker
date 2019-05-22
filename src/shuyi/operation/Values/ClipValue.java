package shuyi.operation.Values;

import shuyi.operation.operations.Amount;

public enum ClipValue implements Values {
    ONE_PIECE, TWO_PIECES, THREE_PIECES, FOUR_PIECES, EIGHT_PIECES;

    @Override
    public Amount getValue() {
        switch (this) {
            case ONE_PIECE:
                return new Amount("One Piece");
            case THREE_PIECES:
                return new Amount("Three Pieces");
            case FOUR_PIECES:
                return new Amount("Four Pieces");
            case EIGHT_PIECES:
                return new Amount("Eight pieces");
            case TWO_PIECES:
            default:
                return new Amount("Two Pieces");
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ONE_PIECE:
                return "一片（块）（颗）";
            case THREE_PIECES:
                return "三片（块）（颗）";
            case FOUR_PIECES:
                return "四片（块）（颗）";
            case EIGHT_PIECES:
                return "八片（块）（颗）";
            case TWO_PIECES:
            default:
                return "两片（块）（颗）";
        }
    }
}
