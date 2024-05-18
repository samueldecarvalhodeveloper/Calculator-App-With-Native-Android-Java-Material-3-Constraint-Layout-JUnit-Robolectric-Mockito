package com.example.calculatorapp.events.main_activity_events;

import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.*;

import android.content.*;
import android.view.*;

import com.example.calculatorapp.components.*;
import com.example.calculatorapp.domains.calculator.*;
import com.example.calculatorapp.view_models.*;

public class MainActivityOnClickListenerEventHandler implements View.OnClickListener {
    private final CalculatorViewModel calculatorViewModel;
    private final Viewfinder viewfinder;
    private final Context context;

    public MainActivityOnClickListenerEventHandler(CalculatorViewModel calculatorViewModel, Viewfinder viewfinder, Context context) {
        this.calculatorViewModel = calculatorViewModel;
        this.viewfinder = viewfinder;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        if (isViewCleanButton(view)) {
            calculatorViewModel.clean(context);
        } else if (isViewDivisionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.DIVISION, context);
        } else if (isViewMultiplicationButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.MULTIPLICATION, context);
        } else if (isViewBackspaceButton(view)) {
            calculatorViewModel.backspace(context);
        } else if (isViewSevenButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SEVEN, context);
        } else if (isViewEightButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.EIGHT, context);
        } else if (isViewNineButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.NINE, context);
        } else if (isViewSubtractionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SUBTRACTION, context);
        } else if (isViewFourButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.FOUR, context);
        } else if (isViewFiveButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.FIVE, context);
        } else if (isViewSixButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SIX, context);
        } else if (isViewAdditionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        } else if (isViewOneButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        } else if (isViewTwoButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.TWO, context);
        } else if (isViewThreeButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.THREE, context);
        } else if (isViewZeroButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ZERO, context);
        } else if (isViewPointButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.POINT, context);
        } else if (isViewEvaluationButton(view)) {
            calculatorViewModel.evaluate(context);
        }

        viewfinder.scrollToTheEnd();
    }
}
