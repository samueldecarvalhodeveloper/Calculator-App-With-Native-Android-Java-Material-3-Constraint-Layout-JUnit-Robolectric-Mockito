package com.example.calculatorapp.domains.calculator.infrastructure.formatters;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;

public class CalculatorFormatter {
    private CalculatorFormatter() {
    }

    public static String getCalculationExpressionWithoutLastCharacter(String calculationExpression) {
        return calculationExpression.substring(STRING_FIRST_INDEX, STRING_LAST_INDEX(calculationExpression));
    }
}
