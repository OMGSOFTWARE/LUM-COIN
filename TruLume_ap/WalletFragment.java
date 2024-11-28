package com.trulumeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class WalletFragment extends Fragment {

    private TextView walletBalanceText;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_wallet, container, false);

        // Initialize views
        walletBalanceText = rootView.findViewById(R.id.wallet_balance_text);
        walletBalanceText.setText("$5000"); // Dynamically set balance

        return rootView;
    }
}
