package com.example.calculatorapp.events.main_activity_events;

import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.*;

import android.content.*;
import android.view.*;

import androidx.appcompat.widget.*;

import com.example.calculatorapp.user_interface_theme_state_adapter.*;

public class MainActivityOnMenuItemClickEventHandler implements Toolbar.OnMenuItemClickListener {
    private final Context context;

    public MainActivityOnMenuItemClickEventHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (isMenuItemIdEqualToToggleNightModeMenuItem(item)) {
            UserInterfaceThemeStateAdapter.toggleTheme(context);
        }

        return true;
    }
}
