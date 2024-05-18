package com.example.calculatorapp.dependencies_injection;

import android.content.*;

import com.example.calculatorapp.calculation_expression_store.*;
import com.example.calculatorapp.domains.calculator.*;

import dagger.*;
import dagger.hilt.*;
import dagger.hilt.android.qualifiers.*;
import dagger.hilt.components.*;

@Module
@InstallIn(SingletonComponent.class)
public class CalculationExpressionModule {

    @Provides
    public CalculationExpression provideCalculationExpression(@ApplicationContext Context context) {
        String storedCalculationExpression = CalculationExpressionStore.getStoredCalculationExpression(context);

        return new CalculationExpression(storedCalculationExpression);
    }
}
