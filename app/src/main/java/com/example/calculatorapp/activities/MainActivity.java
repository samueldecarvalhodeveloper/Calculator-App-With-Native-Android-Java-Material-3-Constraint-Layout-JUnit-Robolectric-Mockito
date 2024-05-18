package com.example.calculatorapp.activities;

import android.os.*;

import androidx.appcompat.app.*;
import androidx.constraintlayout.widget.*;
import androidx.lifecycle.*;

import com.example.calculatorapp.databinding.*;
import com.example.calculatorapp.events.main_activity_events.*;
import com.example.calculatorapp.observer_setup_adapter.*;
import com.example.calculatorapp.user_interface_theme_state_adapter.*;
import com.example.calculatorapp.view_models.*;

import dagger.hilt.android.*;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.calculatorapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        ConstraintLayout rootLayout = binding.getRoot();

        setContentView(rootLayout);

        UserInterfaceThemeStateAdapter.setInitialAppTheme(this);

        CalculatorViewModel calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        MainActivityOnMenuItemClickEventHandler onMenuItemClickEventHandler =
                new MainActivityOnMenuItemClickEventHandler(this);
        MainActivityOnClickListenerEventHandler mainActivityOnClickListenerEventHandler =
                new MainActivityOnClickListenerEventHandler(calculatorViewModel, binding.viewfinder, getApplicationContext());

        binding.toolbar.setOnMenuItemClickListener(onMenuItemClickEventHandler);

        ObserverSetupAdapter.setupViewfinderValueObserver(binding.viewfinder,
                calculatorViewModel,
                this,
                this
        );

        binding.cleanButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.divisionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.multiplicationButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.backspaceButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.sevenButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.eightButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.nineButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.subtractionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.fourButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.fiveButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.sixButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.additionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.oneButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.twoButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.threeButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.zeroButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.pointButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.evaluationButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
    }
}