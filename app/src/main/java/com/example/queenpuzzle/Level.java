package com.example.queenpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level extends AppCompatActivity {

    private Button button, button02, button03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);


        button = findViewById(R.id.easy_level01);
        button02 = findViewById(R.id.middle_level);
        button03 = findViewById(R.id.hard_level);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhotoGrid();
            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhotoGrid02();
            }
        });
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhotoGrid03();
            }
        });



    }
    private void openPhotoGrid03() {
        Intent intent = new Intent(this, PhotoGrid03.class);
        startActivity(intent);
    }
    private void openPhotoGrid02 () {
        Intent intent = new Intent(this, PhotoGrid02.class);
        startActivity(intent);
    }
    private void openPhotoGrid () {
        Intent intent = new Intent(this, PhotoGrid.class);
        startActivity(intent);
    }
}
