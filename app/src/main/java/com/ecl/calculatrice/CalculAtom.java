package com.ecl.calculatrice;

public class CalculAtom {
    private double _x;
    private Operation _operation;

    public CalculAtom(double x, Operation operation) {
        _x = x;
        _operation = operation;
    }
}
