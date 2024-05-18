package com.example.calculatorapp.system;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.*;
import android.widget.*;

import com.example.calculatorapp.*;
import com.example.calculatorapp.activities.*;
import com.example.calculatorapp.user_interface_theme_store.*;

import org.junit.*;
import org.junit.runner.*;
import org.robolectric.*;
import org.robolectric.android.controller.*;

import java.util.*;

@RunWith(RobolectricTestRunner.class)
public class SystemTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map mapWithStoredCalculationExpression;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        mapWithStoredCalculationExpression = new HashMap<String, Object>();

        mapWithStoredCalculationExpression.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, EVALUATED_SIMPLE_CALCULATION_EXPRESSION);
        mapWithStoredCalculationExpression.put(THEME_KEY, true);

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);

        when(sharedPreferences.getAll()).thenReturn(mapWithStoredCalculationExpression);
    }

    @Test
    public void testIfCalculationIsExecutedAndStoredInKeyValueDatabaseOnUserInterface() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.addition_button).performClick();
            activity.findViewById(R.id.one_button).performClick();
            activity.findViewById(R.id.evaluation_button).performClick();

            String currentViewfinderValue = (String) ((TextView) activity.findViewById(R.id.viewfinder_value_textview)).getText();

            String storedCalculationExpression = (String) mapWithStoredCalculationExpression.get(LAST_SESSION_CALCULATION_EXPRESSION_KEY);

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression);
        }
    }

    @Test
    public void testIfToggleThemeIsExecutedOnAndStoredInKeyValueDatabaseOnUserInterface() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();

            boolean currentUserInterfaceMode = UserInterfaceThemeStore.getNightModeThemeState(context);

            assertTrue(currentUserInterfaceMode);
        }
    }
}
