package com.example.calculatorapp.calculation_expression_store;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;

import android.content.*;

import com.example.calculatorapp.infrastructure.anticorruption_layer.*;
import com.example.calculatorapp.infrastructure.exceptions.*;

public class CalculationExpressionStore {
    private CalculationExpressionStore() {
    }

    public static String getStoredCalculationExpression(Context context) {
        try {
            return KeyValueDatabase.getValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, context);
        } catch (NotExistingKeyException exception) {
            KeyValueDatabase.setValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, EMPTY_STRING, context);
            return EMPTY_STRING;
        }
    }

    public static void setStoredCalculationExpression(String newCalculationExpression, Context context) {
        KeyValueDatabase.setValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, newCalculationExpression, context);
    }
}
