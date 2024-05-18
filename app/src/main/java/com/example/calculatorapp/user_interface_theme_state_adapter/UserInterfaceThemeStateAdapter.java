package com.example.calculatorapp.user_interface_theme_state_adapter;

import static androidx.appcompat.app.AppCompatDelegate.*;

import android.content.*;

import androidx.appcompat.app.*;

import com.example.calculatorapp.infrastructure.specifications.*;
import com.example.calculatorapp.user_interface_theme_store.*;

public class UserInterfaceThemeStateAdapter {
    private UserInterfaceThemeStateAdapter() {
    }

    public static void setInitialAppTheme(Context context) {
        boolean isUserInterfaceInNightMode = UserInterfaceThemeStore.getNightModeThemeState(context);

        if (isUserInterfaceInNightMode) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        }
    }

    public static void toggleTheme(Context context) {
        if (UserInterfaceSpecifications.isUserInterfaceInNightMode()) {
            UserInterfaceThemeStore.setNightModeThemeState(false, context);

            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        } else {
            UserInterfaceThemeStore.setNightModeThemeState(true, context);

            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        }
    }
}
