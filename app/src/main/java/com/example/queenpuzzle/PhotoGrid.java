package com.example.queenpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhotoGrid extends AppCompatActivity {
    EditText etText;
    Button btnadd ;
    ListView listView;

    DatabaseHelperOnlyName databaseHelper ;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;


    ImageButton imageButton1 , imageButton2 , imageButton3, imageButton4,imageButton5, imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_grid);

        //Assign Variable
        etText = findViewById(R.id.et_text);
        btnadd = findViewById(R.id.bt_add01);
        listView = findViewById(R.id.List_view);

        //intent pass value
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = etText.getText().toString();
                Intent intentlevel = new Intent(getApplicationContext(), Level.class );
                intentlevel.putExtra("value",value);
                startActivity(intentlevel);
            }
        });



        //Initialize DatabaseHelper
        databaseHelper = new DatabaseHelperOnlyName(PhotoGrid.this);

        //Add Database Values to ArrayList
        arrayList = databaseHelper.getAllText();

        //Initialize ArrayAdapter
        arrayAdapter = new ArrayAdapter(PhotoGrid.this, android.R.layout.simple_expandable_list_item_1, arrayList);

        //set ArrayAdapter to ListView
        listView.setAdapter(arrayAdapter);


        imageButton1 = findViewById(R.id.imagebutton01);
        imageButton2 = findViewById(R.id.imagebutton02);
        imageButton3 = findViewById(R.id.imagebutton03);
        imageButton4 = findViewById(R.id.imagebutton04);
        imageButton5 = findViewById(R.id.imagebutton05);
        imageButton6 = findViewById(R.id.imagebutton06);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel_3_3();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLevel_3_3_Image2();
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel_3_3_Image3();
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel_3_3_Image4();
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel_3_3_Image5();
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel_3_3_Image6();
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from EditText
                String text = etText.getText().toString();
                if (!text.isEmpty()) {
                    if (databaseHelper.addText(text)) {
                        etText.setText(""); //Clear EditText
                        //Display Toast Message
                        Toast.makeText(getApplicationContext(), "Already Name exist...", Toast.LENGTH_SHORT).show();
                        //Clear ArrayList
                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getAllText());
                        //Refresh ListView Data
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();

                    }
                }
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get text from EditText
                String text = etText.getText().toString();
                if (!text.isEmpty()) {
                    if (databaseHelper.addText(text)) {
                        etText.setText(""); //Clear EditText
                        //Display Toast Message
                        Toast.makeText(getApplicationContext(), "Data Inserted...", Toast.LENGTH_SHORT).show();
                        //Clear ArrayList
                        arrayList.clear();
                        arrayList.addAll(databaseHelper.getAllText());
                        //Refresh ListView Data
                        arrayAdapter.notifyDataSetChanged();
                        listView.invalidateViews();
                        listView.refreshDrawableState();

                    }
                }
            }
        });


    }
        public void openLevel_3_3 () {
            Intent intent = new Intent(this, Level_3_3.class);
            startActivity(intent);
        }

        public void openLevel_3_3_Image2 () {
            Intent intent = new Intent(this, Level_3_3_Image2.class);
            startActivity(intent);
        }

        public void openLevel_3_3_Image3 () {
             Intent intent = new Intent(this, Level_3_3_Image3.class);
             startActivity(intent);
        }

        public void openLevel_3_3_Image4 () {
             Intent intent = new Intent(this, Level_3_3_Image4.class);
             startActivity(intent);
        }

        public void openLevel_3_3_Image5 () {
              Intent intent = new Intent(this, Level_3_3_Image5.class);
              startActivity(intent);
        }

        public void openLevel_3_3_Image6 () {
              Intent intent = new Intent(this, Level_3_3_Image6.class);
              startActivity(intent);
        }



}
