package com.example.calculatorapp.user_interface_theme_store;

import static com.example.calculatorapp.constants.UserInterfaceConstants.*;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.*;

import android.content.*;

import com.example.calculatorapp.infrastructure.anticorruption_layer.*;
import com.example.calculatorapp.infrastructure.exceptions.*;

public class UserInterfaceThemeStore {
    private UserInterfaceThemeStore() {
    }

    public static boolean getNightModeThemeState(Context context) {
        try {
            return KeyValueDatabase.getValue(THEME_KEY, context);
        } catch (NotExistingKeyException exception) {
            return isDeviceInNightMode(context);
        }
    }

    public static void setNightModeThemeState(boolean state, Context context) {
        KeyValueDatabase.setValue(THEME_KEY, state, context);
    }
}
