package com.example.queenpuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsEditer extends AppCompatActivity implements View.OnClickListener {
    DataBaseHelper db;

    EditText editTextName, editTextEmail, editTextDistrict, editTextMobile, editTeasyd, editTextLanguage;
    Button buttonInsert, buttonView, buttonDelete, buttonUpdate, buttonSearch;


    String name;
    String email;
    String District;
    String mobile;
    String id;
    String language;
    TextView txtforresult;
    Button btnforresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_editer);

        txtforresult = (TextView) findViewById(R.id.txtforresult);
        /*btnforresult = (Button) findViewById(R.id.btnforresult);
        btnforresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentforResult = new Intent(getApplicationContext(), profile_navigation.class);
                startActivityForResult(intentforResult, 1);

            }
        });*/

        editTextName = findViewById(R.id.edit_name);
        editTextEmail = findViewById(R.id.edit_email);
        editTextDistrict = findViewById(R.id.edit_district);
        editTextMobile = findViewById(R.id.edit_mobile);
        editTeasyd = findViewById(R.id.edit_id);
        editTextLanguage = findViewById(R.id.edit_language);

        buttonInsert = findViewById(R.id.button_insert);
        buttonView = findViewById(R.id.button_view);
        buttonDelete = findViewById(R.id.button_delete);
        buttonUpdate = findViewById(R.id.button_update);
        buttonSearch = findViewById(R.id.button_search);

        buttonInsert.setOnClickListener(this);
        buttonView.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);

        db = new DataBaseHelper(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_insert:
                name = editTextName.getText().toString();
                email = editTextEmail.getText().toString();
                District = editTextDistrict.getText().toString();
                mobile = editTextMobile.getText().toString();
                id = editTeasyd.getText().toString();
                language = editTextLanguage.getText().toString();


                if (name.equals("") | email.equals("") | mobile.equals("") | District.equals("") | language.equals("")) {
                    Toast.makeText(this, "Please fill the Fields", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertStudent(name, email, District, mobile, language);
                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextDistrict.setText("");
                    editTextMobile.setText("");
                    editTeasyd.setText("");
                    editTextLanguage.setText("");
                    Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_view:
                Intent intent = new Intent(getApplicationContext(), profile_navigation.class);
                startActivity(intent);
                break;

            case R.id.button_delete:
                id = editTeasyd.getText().toString();
                if (id.equals("")) {
                    Toast.makeText(this, "Plase fill the Id", Toast.LENGTH_SHORT).show();
                } else {
                    long l = Long.parseLong(id);
                    db.deleteStudent(l);

                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextDistrict.setText("");
                    editTextMobile.setText("");
                    editTeasyd.setText("");
                    editTextLanguage.setText("");
                    Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.button_update:
                id = editTeasyd.getText().toString().trim();
                name = editTextName.getText().toString();
                email = editTextEmail.getText().toString();
                mobile = editTextMobile.getText().toString();
                if (id.equals("") | name.equals("") | email.equals("") | mobile.equals("") | District.equals("") | language.equals("")) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    long l = Long.parseLong(id);
                    db.updateStudent(l, name, email, mobile, District, language);

                    editTextName.setText("");
                    editTextEmail.setText("");
                    editTextDistrict.setText("");
                    editTextMobile.setText("");
                    editTeasyd.setText("");
                    language = editTextLanguage.getText().toString();
                    Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_search:
                id = editTeasyd.getText().toString().trim();
                if (id.equals("")) {
                    Toast.makeText(this, "Please Fill the Id", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        long l1 = Long.parseLong(id);
                        name = db.getName(l1);
                        email = db.getEmail(l1);
                        mobile = db.getMobile(l1);
                        District = db.getDistrict(l1);
                        language = db.getlanguage(l1);

                        editTextName.setText(name);
                        editTextEmail.setText(email);
                        editTextMobile.setText(mobile);
                        Toast.makeText(this, "searched successfully", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(this, "Id is not Available", Toast.LENGTH_SHORT).show();
                    }
                }
                break;


        }
    }
}