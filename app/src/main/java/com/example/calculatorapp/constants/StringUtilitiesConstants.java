package com.example.calculatorapp.constants;

public class StringUtilitiesConstants {
    public static final String EMPTY_STRING = "";
    public static final int STRING_FIRST_INDEX = 0;

    private StringUtilitiesConstants() {
    }

    public static int STRING_LAST_INDEX(String string) {
        return string.length() - 1;
    }
}
