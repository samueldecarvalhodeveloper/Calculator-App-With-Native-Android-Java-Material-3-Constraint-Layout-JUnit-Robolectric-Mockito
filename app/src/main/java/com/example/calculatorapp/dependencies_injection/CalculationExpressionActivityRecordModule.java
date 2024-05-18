package com.example.calculatorapp.dependencies_injection;

import com.example.calculatorapp.domains.calculator.*;

import dagger.*;
import dagger.hilt.*;
import dagger.hilt.components.*;

@Module
@InstallIn(SingletonComponent.class)
public class CalculationExpressionActivityRecordModule {
    @Provides
    public CalculationExpressionActiveRecord provideCalculationExpressionActiveRecord(CalculationExpressionRegister calculationExpressionRegister) {
        return new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
    }
}
