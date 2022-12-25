package com.example.queenpuzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class setting_navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_navigation);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.setting);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Home20:
                        startActivity(new Intent(getApplicationContext(), Main_menu.class));
                        overridePendingTransition(0,0);
                        return true ;
                }

                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile_navigation.class));
                        overridePendingTransition(0,0);
                        return true ;
                }


                switch (menuItem.getItemId()) {
                    case R.id.Facebookk:
                        startActivity(new Intent(getApplicationContext(),facebook_navigation.class));
                        overridePendingTransition(0,0);
                        return true ;
                }

                switch (menuItem.getItemId()) {
                    case R.id.setting:
                        return true ;
                }
                return false;
            }
        });

    }
}