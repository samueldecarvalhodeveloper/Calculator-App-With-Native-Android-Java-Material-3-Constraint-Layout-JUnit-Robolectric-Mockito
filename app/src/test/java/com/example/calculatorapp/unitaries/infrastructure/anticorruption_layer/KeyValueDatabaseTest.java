package com.example.calculatorapp.unitaries.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.*;

import com.example.calculatorapp.infrastructure.anticorruption_layer.*;
import com.example.calculatorapp.infrastructure.exceptions.*;

import org.junit.*;

import java.util.*;

public class KeyValueDatabaseTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map mapWithWantedValue;
    public static Map emptyMap;
    public static Map mapWithAllWantedValue;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        emptyMap = new HashMap<>();
        mapWithWantedValue = new HashMap<String, Object>();
        mapWithAllWantedValue = new HashMap<>();

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);

    }

    @Before
    public void beforeEach() {
        mapWithWantedValue.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, SIMPLE_CALCULATION_EXPRESSION);

        when(sharedPreferences.getAll()).thenReturn(mapWithWantedValue);
    }

    @Test
    public void testIfMethodGetValueReturnsKeyValueDatabaseStoredValue() throws NotExistingKeyException {
        String storedValue = KeyValueDatabase.getValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, context);

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, storedValue);
    }

    @Test
    public void testIfMethodGetValueThrowsNotExistingKeyException() {
        when(sharedPreferences.getAll()).thenReturn(mapWithWantedValue);
        when(sharedPreferences.getAll()).thenReturn(mapWithWantedValue);

        try {
            System.out.println(sharedPreferences.getAll());
            KeyValueDatabase.getValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, context);
        } catch (NotExistingKeyException exception) {
            String exceptionMessage = exception.getMessage();

            assertEquals(NOT_EXISTING_KEY_EXCEPTION_MESSAGE(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY
            ), exceptionMessage);
        }
    }

    @Test
    public void testIfMethodSetValueAddsToChoseKeyWantedValue() {
        when(
                context
                        .getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE))
                .thenReturn(sharedPreferences
                );
        when(
                context
                        .getSharedPreferences
                                (APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                        .edit())
                .thenReturn(sharedPreferencesEditor);
        when(

                context
                        .getSharedPreferences(
                                APPLICATION_SHARED_PREFERENCES_NAME
                                , Context.MODE_PRIVATE
                        )
                        .edit()
                        .putString(anyString(), anyString())
        )
                .thenReturn(sharedPreferencesEditor);
        when(
                context
                        .getSharedPreferences(
                                APPLICATION_SHARED_PREFERENCES_NAME,
                                Context.MODE_PRIVATE
                        )
                        .edit()
                        .putBoolean(anyString(), anyBoolean()
                        ))
                .thenReturn(sharedPreferencesEditor);

        mapWithAllWantedValue.put(STRING_VALUE_KEY, STRING_VALUE);
        mapWithAllWantedValue.put(BOOLEAN_VALUE_KEY, BOOLEAN_VALUE);

        when(sharedPreferences.getAll()).thenReturn(mapWithAllWantedValue);

        KeyValueDatabase.setValue(BOOLEAN_VALUE_KEY, BOOLEAN_VALUE, context);
        KeyValueDatabase.setValue(STRING_VALUE_KEY, STRING_VALUE, context);

        Map mapWithAllStoredKeys = sharedPreferences.getAll();

        assertTrue(mapWithAllStoredKeys.containsKey(STRING_VALUE_KEY));
        assertTrue(mapWithAllStoredKeys.containsKey(BOOLEAN_VALUE_KEY));
    }
}
