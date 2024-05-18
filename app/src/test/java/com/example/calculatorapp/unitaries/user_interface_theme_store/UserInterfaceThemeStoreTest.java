package com.example.calculatorapp.unitaries.user_interface_theme_store;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import android.content.*;

import com.example.calculatorapp.user_interface_theme_store.*;

import org.junit.*;

import java.util.*;

public class UserInterfaceThemeStoreTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map emptyMap;
    public static Map mapWithTrueThemeState;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        emptyMap = new HashMap();
        mapWithTrueThemeState = new HashMap<String, Object>();

        mapWithTrueThemeState.put(THEME_KEY, true);

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeState);
        when(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor);
        when(sharedPreferences.edit().putBoolean(anyString(), anyBoolean())).thenReturn(sharedPreferencesEditor);
    }

    @Before
    public void beforeEach() {
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeState);
    }

    @Test
    public void testIfMethodGetNightModeThemeStateReturnsTheStoredThemeState() {
        boolean storedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context);

        assertTrue(storedThemeState);
    }

    @Test
    public void testIfMethodGetNightModeThemeStateReturnsTheDeviceThemeStateWhenStoredStateIsNotSet() {
        when(sharedPreferences.getAll()).thenReturn(emptyMap);

        boolean storedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context);

        assertFalse(storedThemeState);
    }

    @Test
    public void testIfMethodSetNightModeThemeStateStoresWantedStateToKeyValueDatabase() {
        UserInterfaceThemeStore.setNightModeThemeState(true, context);

        boolean storedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context);

        assertTrue(storedThemeState);
    }
}