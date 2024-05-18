package com.example.calculatorapp.unitaries.components;

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
public class ButtonTest {
    @Test
    public void testIfComponentIsRenderedOnMainActivityAndDispatchesClickEvent() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();

            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            String evaluatedCalculationExpressionValue = (String) viewfinderValueTextView.getText();

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, evaluatedCalculationExpressionValue);
        }
    }
}
