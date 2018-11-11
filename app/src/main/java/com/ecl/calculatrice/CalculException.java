package com.ecl.calculatrice;

public class CalculException extends Exception {
    int _index;

    public CalculException(int index, String reason) {
        super(reason);

        _index = index;
    }
}
