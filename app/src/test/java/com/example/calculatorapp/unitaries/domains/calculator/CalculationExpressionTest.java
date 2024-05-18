package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;

import com.example.calculatorapp.domains.calculator.*;

import org.junit.*;

public class CalculationExpressionTest {
    @Test
    public void testIfClassRepresentsHowCalculationExpressionShouldBeUsedOnClient() {
        CalculationExpression calculationExpression = new CalculationExpression(EMPTY_STRING);

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(EMPTY_STRING, currentCalculationExpression);

        calculationExpression.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String updateCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, updateCalculationExpression);
    }
}