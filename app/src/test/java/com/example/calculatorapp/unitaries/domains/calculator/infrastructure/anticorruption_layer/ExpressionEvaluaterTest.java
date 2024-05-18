package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluater.*;
import static org.junit.Assert.*;

import org.junit.*;

public class ExpressionEvaluaterTest {
    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() {
        String evaluatedExpression = getEvaluatedCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, evaluatedExpression);
    }

    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        String evaluatedExpression =
                getEvaluatedCalculationExpression(NOT_VALID_EXPRESSION);

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, evaluatedExpression);
    }
}