package com.example.calculatorapp.view_models;

import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.*;

import android.content.*;

import androidx.lifecycle.*;

import com.example.calculatorapp.*;
import com.example.calculatorapp.calculation_expression_store.*;
import com.example.calculatorapp.domains.calculator.*;

import javax.inject.*;

import dagger.hilt.android.lifecycle.*;

@HiltViewModel
public class CalculatorViewModel extends ViewModel {
    private final MutableLiveData<String> calculationExpression;
    private final Calculator calculator;

    @Inject
    public CalculatorViewModel(Calculator calculator) {
        this.calculator = calculator;

        String initialExpression = calculator.getCalculationExpression();

        calculationExpression = new MutableLiveData<>(initialExpression);
    }

    public LiveData<String> getCalculationExpression(Context context) {
        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
        ) ?
                context.getString(R.string.not_valid_expression_message) :
                currentCalculationExpression);
        
        return calculationExpression;
    }

    public void addCharacter(CalculatorCharacters calculatorCharacters, Context context) {
        calculator.addCharacter(calculatorCharacters);

        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(currentCalculationExpression);
        CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
        );
    }

    public void backspace(Context context) {
        calculator.backspace();

        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(currentCalculationExpression);
        CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
        );
    }

    public void clean(Context context) {
        calculator.clean();

        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(currentCalculationExpression);
        CalculationExpressionStore.setStoredCalculationExpression(
                currentCalculationExpression,
                context
        );
    }

    public void evaluate(Context context) {
        calculator.evaluate();

        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
        ) ?
                context.getString(R.string.not_valid_expression_message) :
                currentCalculationExpression);

        CalculationExpressionStore.setStoredCalculationExpression(currentCalculationExpression,
                context
        );
    }
}
