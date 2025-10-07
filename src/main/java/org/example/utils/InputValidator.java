package org.example.utils;

//This is to prevent the program from crashing when the user inputs invalid inputs.
public class InputValidator {
    public static boolean isPositiveAmount(double amount) {
        return amount > 0;
    }
}
