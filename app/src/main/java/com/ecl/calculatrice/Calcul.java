package com.ecl.calculatrice;

import android.widget.Button;

import java.util.ArrayList;

public class Calcul {

    private int _currentIndex, _endIndex;

    public Calcul(int index0, int index1) {
        _currentIndex = index0;
        _endIndex = index1;
    }

    public double getResult() throws CalculException {
        int buttonClickedID;
        double result;

        if (_currentIndex == _endIndex) {
            return 0;
        }
        else {
            result = getDouble();
        }

        if (_currentIndex == _endIndex) {
            return result;
        }

        while (true) {

            buttonClickedID = MainActivity.buttonsClicked.get(_currentIndex).getId();
            if (buttonClickedID == R.id.button_additionner || buttonClickedID == R.id.button_soustraire) {

                if (_currentIndex + 1 == _endIndex) {
                    throw new CalculException(_currentIndex, "Un caractère numérique est attendu");
                }
                else {
                    Calcul calcul = new Calcul(_currentIndex, _endIndex);
                    return result + calcul.getResult();
                }
            }
            else {
                if (_currentIndex + 1 == _endIndex) {
                    throw new CalculException(_currentIndex, "Un caractère numérique est attendu");
                }
                else {

                    _currentIndex++;
                    if (buttonClickedID == R.id.button_multiplier) {
                        result *= getDouble();
                    }
                    else {
                        result /= getDouble();
                    }

                    if (_currentIndex == _endIndex) {
                        return result;
                    }
                }
            }
        }
    }

    private double getDouble() throws CalculException {
        int buttonClickedID;

        if (_currentIndex == _endIndex) {
            throw new CalculException(_currentIndex, "Un calcul ne peut pas être vide");
        }

        buttonClickedID = MainActivity.buttonsClicked.get(_currentIndex).getId();
        if (buttonClickedID == R.id.button_multiplier || buttonClickedID == R.id.button_diviser) {
            throw new CalculException(_currentIndex, "Un caractère numérique est attendu");
        }
        else if (buttonClickedID == R.id.button_additionner || buttonClickedID == R.id.button_soustraire) {
            if (_currentIndex + 1 == _endIndex) {
                throw new CalculException(_currentIndex, "Un caractère numérique est attendu");
            }
            else if (buttonClickedID == R.id.button_additionner){
                _currentIndex++;
                return getValue();
            }
            else {
                _currentIndex++;
                return -1 * getValue();
            }
        }
        // Ajouter les parenthèses
        else if (buttonClickedID == R.id.button_res) {
            _currentIndex++;
            return MainActivity.result;
        }
        else {
            return getValue();
        }
    }

    private double getValue() {
        ArrayList<Button> buttonsClicked = MainActivity.buttonsClicked;
        String value = "";

        Button buttonClicked;
        while (true) {

            if (_currentIndex == _endIndex) {
                return Double.parseDouble(value);
            }

            buttonClicked = buttonsClicked.get(_currentIndex);
            if (MainActivity.isOperator(buttonClicked)) {
                return Double.parseDouble(value);
            }
            else {
                value += buttonClicked.getText();
                _currentIndex++;
            }
        }
    }
}
