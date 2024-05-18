package com.example.calculatorapp.components;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.EMPTY_STRING;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.*;

import org.junit.*;

public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression(EMPTY_STRING);
        CalculationExpressionRegister calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
        CalculationExpressionActiveRecord calculationExpressionActiveRecord = new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
        calculator = new Calculator(calculationExpressionActiveRecord);
    }

    @Test
    public void testIfComponentHandlesDataInputAndOutputsScenario() {
        String initialCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EMPTY_STRING, initialCalculationExpression);

        calculator.addCharacter(CalculatorCharacters.ONE);
        calculator.addCharacter(CalculatorCharacters.ADDITION);
        calculator.addCharacter(CalculatorCharacters.ONE);

        calculator.backspace();

        calculator.addCharacter(CalculatorCharacters.ONE);

        calculator.evaluate();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);

        calculator.clean();

        String finalCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EMPTY_STRING, finalCalculationExpression);
    }
}
