package com.example.calculatorapp.unitaries.user_interface_theme_state_adapter;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import android.app.*;
import android.content.*;

import androidx.appcompat.app.*;

import com.example.calculatorapp.user_interface_theme_state_adapter.*;
import com.example.calculatorapp.user_interface_theme_store.*;

import org.junit.*;

import java.util.*;

public class UserInterfaceThemeStateAdapterTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static UiModeManager uiModeManager;
    public static Map mapWithTrueThemeStateValue;
    public static Map mapWithFalseThemeStateValue;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);
        uiModeManager = mock(UiModeManager.class);

        mapWithTrueThemeStateValue = new HashMap<String, Object>();
        mapWithFalseThemeStateValue = new HashMap<String, Object>();

        mapWithTrueThemeStateValue.put(THEME_KEY, true);
        mapWithFalseThemeStateValue.put(THEME_KEY, false);

        when(context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);
        when(context.getSystemService(Context.UI_MODE_SERVICE)).thenReturn(uiModeManager);
        when(((UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE)).getNightMode()).thenReturn(UiModeManager.MODE_NIGHT_NO);
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeStateValue);
        when(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor);
        when(sharedPreferences.edit().putBoolean(anyString(), anyBoolean())).thenReturn(sharedPreferencesEditor);
    }

    @Before
    public void beforeEach() {
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeStateValue);
    }

    @Test
    public void testIfMethodSetInitialAppThemeTurnsTheApplicationThemeAsSameAsSavedStateOnKeyValueDatabase() {
        UserInterfaceThemeStateAdapter.setInitialAppTheme(context);

        int themeMode = AppCompatDelegate.getDefaultNightMode();
        int currentUiMode = ((UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE)).getNightMode();

        assertEquals(AppCompatDelegate.MODE_NIGHT_YES, themeMode);
        assertEquals(UiModeManager.MODE_NIGHT_NO, currentUiMode);
    }

    @Test
    public void testIfMethodToggleThemeTogglesTheApplicationThemeAndUpdatesTheKeyValueDatabase() {
        UserInterfaceThemeStateAdapter.toggleTheme(context);

        boolean storedThemeState = UserInterfaceThemeStore.getNightModeThemeState(context);
        int currentThemeMode = AppCompatDelegate.getDefaultNightMode();
        int currentUiMode = ((UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE)).getNightMode();

        assertTrue(storedThemeState);
        assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentThemeMode);
        assertEquals(UiModeManager.MODE_NIGHT_NO, currentUiMode);
    }
}