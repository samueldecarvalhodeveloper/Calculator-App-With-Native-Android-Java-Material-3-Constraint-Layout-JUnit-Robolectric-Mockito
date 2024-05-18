package com.example.calculatorapp.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.ApplicationConstants.*;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.*;

import android.content.*;

import com.example.calculatorapp.infrastructure.exceptions.*;

import java.util.*;

public class KeyValueDatabase {
    private KeyValueDatabase() {
    }

    public static <T> T getValue(String key, Context context) throws NotExistingKeyException {
        Map<String, ?> allStoredValue = context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .getAll();

        if (isKeyWithinMap(key, allStoredValue)) {
            return (T) allStoredValue.get(key);
        } else {
            throw new NotExistingKeyException(key);
        }
    }

    public static void setValue(String key, String value, Context context) {
        context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .apply();
    }

    public static void setValue(String key, Boolean value, Context context) {
        context.getSharedPreferences(APPLICATION_SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(key, value)
                .apply();
    }
}
