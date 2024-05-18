package com.example.calculatorapp.domains.calculator;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.domains.calculator.infrastructure.formatters.CalculatorFormatter.*;

import com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.*;

public class CalculationExpressionActiveRecord {
    private final CalculationExpressionRegister calculationExpressionRegister;

    public CalculationExpressionActiveRecord(CalculationExpressionRegister calculationExpressionRegister) {
        this.calculationExpressionRegister = calculationExpressionRegister;
    }

    public String getCalculationExpression() {
        return calculationExpressionRegister.getCalculationExpression();
    }

    public void addCharacterToCalculationExpression(CalculatorCharacters character) {
        calculationExpressionRegister.addCharacterToCalculationExpression(character);
    }

    public void removeLastCharacterFromCalculationExpression() {
        String currentCalculationExpression = this.calculationExpressionRegister.getCalculationExpression();
        String currentCalculationExpressionWithoutLastCharacter = getCalculationExpressionWithoutLastCharacter(currentCalculationExpression);

        calculationExpressionRegister.setCalculationExpression(currentCalculationExpressionWithoutLastCharacter);
    }

    public void turnCalculationExpressionEmpty() {
        this.calculationExpressionRegister.setCalculationExpression(EMPTY_STRING);
    }

    public void evaluateCalculationExpression() {
        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();
        String evaluatedCalculationExpression = ExpressionEvaluater.getEvaluatedCalculationExpression(currentCalculationExpression);

        calculationExpressionRegister.setCalculationExpression(evaluatedCalculationExpression);
    }
}
