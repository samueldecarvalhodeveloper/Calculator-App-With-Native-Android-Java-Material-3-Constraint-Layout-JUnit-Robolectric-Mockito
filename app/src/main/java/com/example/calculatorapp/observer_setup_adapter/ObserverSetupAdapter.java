package com.example.calculatorapp.observer_setup_adapter;

import android.content.*;

import androidx.lifecycle.*;

import com.example.calculatorapp.components.*;
import com.example.calculatorapp.view_models.*;

public class ObserverSetupAdapter {
    public static void setupViewfinderValueObserver(Viewfinder viewfinderView,
                                                    CalculatorViewModel calculatorViewModel,
                                                    Context context,
                                                    LifecycleOwner lifecycleOwner
    ) {

        calculatorViewModel.getCalculationExpression(context).observe(lifecycleOwner,
                viewfinderView::setViewfinderValue);
    }
}
