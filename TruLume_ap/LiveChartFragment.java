package com.trulumeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class LiveChartFragment extends Fragment {

    private TextView chartInfo;

    public LiveChartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_live_chart, container, false);

        // Initialize views
        chartInfo = rootView.findViewById(R.id.chart_info);
        chartInfo.setText("Live TruLumé Coin Chart");

        return rootView;
    }
}
