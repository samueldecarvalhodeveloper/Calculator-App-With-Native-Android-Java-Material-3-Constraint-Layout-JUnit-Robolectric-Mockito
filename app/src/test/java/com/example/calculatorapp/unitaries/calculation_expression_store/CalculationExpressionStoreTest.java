package com.example.calculatorapp.unitaries.calculation_expression_store;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.constants.StringUtilitiesConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.*;

import com.example.calculatorapp.calculation_expression_store.*;

import org.junit.*;

import java.util.*;

public class CalculationExpressionStoreTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map mapWithWantedValue;
    public static Map emptyMap;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        emptyMap = new HashMap<>();
        mapWithWantedValue = new HashMap<String, Object>();

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);

    }

    @Test
    public void testIfMethodGetStoredCalculationExpressionReturnsStoredCalculationExpression() {
        mapWithWantedValue.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, SIMPLE_CALCULATION_EXPRESSION);

        when(sharedPreferences.getAll()).thenReturn(mapWithWantedValue);

        String storedCalculationExpression = CalculationExpressionStore.getStoredCalculationExpression(context);

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression);
    }

    @Test
    public void testIfMethodGetStoredCalculationExpressionReturnsEmptyStringWhenNotExpressionIsStored() {
        when(sharedPreferences.getAll()).thenReturn(emptyMap);
        when(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor);
        when(sharedPreferences.edit().putString(LAST_SESSION_CALCULATION_EXPRESSION_KEY, EMPTY_STRING)).thenReturn(sharedPreferencesEditor);

        String storedCalculationExpression = CalculationExpressionStore.getStoredCalculationExpression(context);

        assertEquals(EMPTY_STRING, storedCalculationExpression);
    }

    @Test
    public void testIfMethodSetStoredCalculationExpressionStoresCalculationExpressionOnKeyValueDatabase() {
        mapWithWantedValue.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, SIMPLE_CALCULATION_EXPRESSION);

        when(sharedPreferences.getAll()).thenReturn(mapWithWantedValue);
        when(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor);
        when(sharedPreferences.edit().putString(LAST_SESSION_CALCULATION_EXPRESSION_KEY, SIMPLE_CALCULATION_EXPRESSION)).thenReturn(sharedPreferencesEditor);

        CalculationExpressionStore.setStoredCalculationExpression(SIMPLE_CALCULATION_EXPRESSION, context);

        String storedCalculationExpression = CalculationExpressionStore.getStoredCalculationExpression(context);

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression);
    }
}