package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static org.junit.Assert.*;

import com.example.calculatorapp.domains.calculator.*;

import org.junit.*;

public class CalculatorTest {
    private static Calculator calculator;
    private static CalculationExpressionActiveRecord calculationExpressionActiveRecord;

    @BeforeClass
    public static void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression(EMPTY_STRING);
        CalculationExpressionRegister calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
        calculationExpressionActiveRecord = new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
        calculator = new Calculator(calculationExpressionActiveRecord);
    }

    @Before
    public void beforeEach() {
        calculationExpressionActiveRecord.turnCalculationExpressionEmpty();
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnsCalculationExpression() {
        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EMPTY_STRING, currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterAddsCharacterToCalculationExpression() {
        calculator.addCharacter(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfMethodBackspaceRemovesLastCharacterFromCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.backspace();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfMethodCleanRemovesAllCharactersFromCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.clean();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(EMPTY_STRING, currentCalculationExpression);
    }

    @Test
    public void testIfMethodEvaluateEvaluatesCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ADDITION);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.evaluate();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.TWO.value, currentCalculationExpression);
    }
}