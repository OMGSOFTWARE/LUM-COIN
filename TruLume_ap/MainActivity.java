package com.trulumeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    
    private Button sendFundsBtn;
    private Button receiveFundsBtn;
    private Button buyTrulumeBtn;
    private Button tradeBtn;
    private Button gamesBtn;
    
    private TextView walletBalance;
    private ImageView walletIcon;
    
    // Simulating the state of TruLumé balance for testing
    private String trulumeBalance = "$5000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        sendFundsBtn = findViewById(R.id.send_funds_button);
        receiveFundsBtn = findViewById(R.id.receive_funds_button);
        buyTrulumeBtn = findViewById(R.id.buy_trulume_button);
        tradeBtn = findViewById(R.id.trade_button);
        gamesBtn = findViewById(R.id.play_games_button);

        walletBalance = findViewById(R.id.wallet_balance);
        walletIcon = findViewById(R.id.wallet_icon);

        // Setting up the Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_menu); // Customize your icon

        // Set wallet balance
        walletBalance.setText(trulumeBalance);

        // Set up navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Home Page
                    loadFragment(new HomeFragment());
                } else if (id == R.id.nav_wallet) {
                    // Wallet Page
                    loadFragment(new WalletFragment());
                } else if (id == R.id.nav_trulume_chart) {
                    // TruLumé Coin Live Charts
                    loadFragment(new LiveChartFragment());
                } else if (id == R.id.nav_settings) {
                    // Settings Page
                    loadFragment(new SettingsFragment());
                }

                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        // Setting up Button Actions
        sendFundsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFunds();
            }
        });

        receiveFundsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receiveFunds();
            }
        });

        buyTrulumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyTrulume();
            }
        });

        tradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trade();
            }
        });

        gamesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGames();
            }
        });

        // Load Home Fragment by default
        loadFragment(new HomeFragment());
    }

    // Method to load a specific fragment
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // Method to send funds (You can add your own logic to process this)
    private void sendFunds() {
        Toast.makeText(this, "Sending funds...", Toast.LENGTH_SHORT).show();
        // Implement the fund sending logic here
    }

    // Method to receive funds (You can add your own logic to process this)
    private void receiveFunds() {
        Toast.makeText(this, "Receiving funds...", Toast.LENGTH_SHORT).show();
        // Implement the fund receiving logic here
    }

    // Method to buy TruLumé (Redirect to the purchase page)
    private void buyTrulume() {
        Intent intent = new Intent(this, BuyTrulumeActivity.class);
        startActivity(intent);
    }

    // Method to open the trade section
    private void trade() {
        Intent intent = new Intent(this, TradeActivity.class);
        startActivity(intent);
    }

    // Method to start playing games
    private void playGames() {
        Intent intent = new Intent(this, GamesActivity.class);
        startActivity(intent);
    }

    // Handle the drawer menu toggle
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(navigationView);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
