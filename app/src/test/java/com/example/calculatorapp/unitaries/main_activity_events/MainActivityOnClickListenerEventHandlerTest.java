package com.example.calculatorapp.unitaries.main_activity_events;

import static org.junit.Assert.*;

import androidx.appcompat.app.*;

import com.example.calculatorapp.*;
import com.example.calculatorapp.activities.*;

import org.junit.*;
import org.junit.runner.*;
import org.robolectric.*;
import org.robolectric.android.controller.*;

@RunWith(RobolectricTestRunner.class)
public class MainActivityOnClickListenerEventHandlerTest {
    @Test
    public void testIfMethodOnMenuItemClickDispatchesActionBarToggleNightModeAction() {
        try (ActivityController<MainActivity> controller = Robolectric.buildActivity(MainActivity.class)) {
            controller.setup();

            MainActivity activity = controller.get();

            activity.findViewById(R.id.toggle_night_mode_menu_item).performClick();

            int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

            assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentUserInterfaceMode);
        }
    }
}
