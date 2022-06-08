package com.uc.iot_group3_fantomatic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainMenuActivity extends AppCompatActivity {
    BottomNavigationView bottomNV;
    NavHostFragment navHF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNV = findViewById(R.id.bottomNavigationView);
        navHF = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navfrag);
        NavigationUI.setupWithNavController(bottomNV, navHF.getNavController());
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navHF.getNavController().navigateUp() || super.onSupportNavigateUp();
    }
}