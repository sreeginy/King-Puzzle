package com.example.queenpuzzle;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class profile_navigation extends AppCompatActivity {

    TextView textView;
    Button btnforresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_navigation);



        textView=(TextView) findViewById(R.id.txtforresult);
        btnforresult = (Button) findViewById(R.id.btnforresult);
        btnforresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailsEditer();
            }
        });


        DataBaseHelper db = new DataBaseHelper(this);

        String data = db.getData();
        textView.setText(data);
        textView.setMovementMethod(new ScrollingMovementMethod());



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.profile);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Home20:
                        startActivity(new Intent(getApplicationContext(), Main_menu.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        return true;
                }
                switch (menuItem.getItemId()) {
                    case R.id.Facebookk:
                        startActivity(new Intent(getApplicationContext(), facebook_navigation.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                switch (menuItem.getItemId()) {
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), setting_navigation.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


    }

    private void openDetailsEditer() {
        Intent intent = new Intent(this, DetailsEditer.class);
        startActivity(intent);
    }



}

