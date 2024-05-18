package com.example.calculatorapp.unitaries.components;

import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;

import android.widget.*;

import androidx.test.filters.*;

import com.example.calculatorapp.*;
import com.example.calculatorapp.activities.*;

import org.junit.*;
import org.junit.runner.*;
import org.robolectric.*;
import org.robolectric.android.controller.*;

@RunWith(RobolectricTestRunner.class)
@LargeTest
public class ViewfinderTest {
    @Test
    public void testIfComponentIsRenderedOnMainActivity() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            String evaluatedCalculationExpressionValue = (String) viewfinderValueTextView.getText();

            assertEquals(EMPTY_STRING, evaluatedCalculationExpressionValue);
        }
    }

    @Test
    public void testIfMethodSetViewfinderValueUpdatesViewfinderValueTextviewText() {
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

    @Test
    public void testIfMethodScrollToTheEndScrollsViewfinderValueHorizontalScrollViewToTheEnd() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.one_button).performClick();

            HorizontalScrollView viewfinderValueHorizontalScrollView = activity.findViewById(R.id.viewfinder_value_scrollview);
            TextView viewfinderValueTextView = activity.findViewById(R.id.viewfinder_value_textview);

            int viewfinderValueHorizontalScrollviewScrollX = viewfinderValueHorizontalScrollView.getScrollX();
            int viewfinderValueTextViewWidth = viewfinderValueTextView.getWidth();

            assertEquals(
                    VIEWFINDER_SCROLL_TO_END_VALUE(viewfinderValueTextViewWidth),
                    viewfinderValueHorizontalScrollviewScrollX
            );
        }
    }
}
