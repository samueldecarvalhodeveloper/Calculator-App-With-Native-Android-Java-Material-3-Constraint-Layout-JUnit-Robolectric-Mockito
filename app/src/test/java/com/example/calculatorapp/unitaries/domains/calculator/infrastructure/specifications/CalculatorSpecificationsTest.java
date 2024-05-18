package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.specifications;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.*;
import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorSpecificationsTest {
    @Test
    public void testIfMethodIsCalculationResultARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        boolean rationalNumber = isCalculationResultARationalNumber(RATIONAL_NUMBER);
        boolean notRationalNumber = isCalculationResultARationalNumber(NOT_RATIONAL_NUMBER);

        assertTrue(rationalNumber);
        assertFalse(notRationalNumber);
    }

    @Test
    public void testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        boolean emptyExpression = isCalculationExpressionEmpty(EMPTY_STRING);
        boolean notEmptyExpression = isCalculationExpressionEmpty(SIMPLE_CALCULATION_EXPRESSION);

        assertTrue(emptyExpression);
        assertFalse(notEmptyExpression);
    }

    @Test
    public void testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        boolean calculationExpressionIsNotValidExpressionMessage =
                isCalculationExpressionNotValidExpressionExceptionMessage(
                        NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
                );
        boolean notValidExpressionMessage =
                isCalculationExpressionNotValidExpressionExceptionMessage(SIMPLE_CALCULATION_EXPRESSION);

        assertTrue(calculationExpressionIsNotValidExpressionMessage);
        assertFalse(notValidExpressionMessage);
    }
}