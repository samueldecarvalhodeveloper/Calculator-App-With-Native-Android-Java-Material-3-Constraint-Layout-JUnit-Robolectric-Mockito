package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;

import com.example.calculatorapp.domains.calculator.*;

import org.junit.*;

public class CalculationExpressionActiveRecordTest {
    private static CalculationExpressionActiveRecord calculationExpressionActiveRecord;
    private static CalculationExpressionRegister calculationExpressionRegister;

    @BeforeClass
    public static void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression(EMPTY_STRING);
        calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
        calculationExpressionActiveRecord = new CalculationExpressionActiveRecord(calculationExpressionRegister);
    }

    @Before
    public void beforeEach() {
        calculationExpressionRegister.setCalculationExpression(EMPTY_STRING);
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        String currentCalculationExpression = calculationExpressionActiveRecord.getCalculationExpression();

        assertEquals(EMPTY_STRING, currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterToCalculatorExpressionAddChoseCharacterToCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfMethodRemoveLastCharacterFromCalculationExpressionRemovesLastCharacterFromExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecord.removeLastCharacterFromCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER, currentCalculationExpression);
    }

    @Test
    public void testIfMethodTurnCalculationExpressionEmptyMakesTheCalculationExpressionIntoEmptyString() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);

        calculationExpressionActiveRecord.turnCalculationExpressionEmpty();

        String updatedCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(EMPTY_STRING, updatedCalculationExpression);
    }

    @Test
    public void testIfMethodEvaluateCalculationExpressionTurnsTheCalculationExpressionIntoEvaluatedValue() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecord.evaluateCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);
    }
}