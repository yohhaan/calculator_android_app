package com.ecl.calculatrice;

public class FirstMember {

    private double _x;
    private boolean _isFinal;
    private Operation _operation;
    private int _indexBeg, _indexEnd;

    public FirstMember(double x, Operation operation, int indexBeg, int indexEnd) {
        _x = x;
        _operation = operation;
        _indexBeg = indexBeg;
        _indexEnd = indexEnd;
    }

    public double getX() {
        return _x;
    }

    public int getNextIndex() {
        return _indexEnd;
    }

    public Operation getOperation() {
        return _operation;
    }
}
