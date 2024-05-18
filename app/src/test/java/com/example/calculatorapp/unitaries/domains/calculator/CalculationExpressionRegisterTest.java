package com.example.calculatorapp.unitaries.domains.calculator;


import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;

import com.example.calculatorapp.domains.calculator.*;

import org.junit.*;

public class CalculationExpressionRegisterTest {
    private static CalculationExpression calculationExpression;
    private static CalculationExpressionRegister calculationExpressionRegister;

    @BeforeClass
    public static void beforeAll() {
        calculationExpression = new CalculationExpression(EMPTY_STRING);
        calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
    }

    @Before
    public void beforeEach() {
        calculationExpression.setCalculationExpression(EMPTY_STRING);
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnsTheCurrentCalculationExpression() {
        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(EMPTY_STRING, currentCalculationExpression);
    }

    @Test
    public void testIfMethodSetCalculationExpressionReplacesTheCalculationExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterToCalculationExpressionAddsChoseCharacterToCalculationExpression() {
        calculationExpressionRegister.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }
}