package com.example.calculatorapp.unitaries.observer_setup_adapter;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;

import android.widget.*;

import com.example.calculatorapp.*;
import com.example.calculatorapp.activities.*;

import org.junit.*;
import org.junit.runner.*;
import org.robolectric.*;
import org.robolectric.android.controller.*;

@RunWith(RobolectricTestRunner.class)
public class ObserverSetupAdapterTest {
    @Test
    public void testIfObserverIsSetUpByObservingCalculationExpressionAndUpdatingViewfinderValue() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.evaluation_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
        }
    }
}
