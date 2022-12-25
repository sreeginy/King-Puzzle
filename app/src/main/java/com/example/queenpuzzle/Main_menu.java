package com.example.queenpuzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Main_menu extends AppCompatActivity {
    Button button;

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        button = (Button) findViewById(R.id.new_game);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel();
            }
        });

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setSelectedItemId(R.id.Home20);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Home20:
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
                        startActivity(new Intent(getApplicationContext(), setting_navigation.class));
                        overridePendingTransition(0,0);
                        return true ;
                }

                return false;
            }
        });
    }
     private void openLevel() {
         Intent intent = new Intent(this, Level.class);
         startActivity(intent);
     }
}
