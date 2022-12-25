package com.example.queenpuzzle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class Home extends AppCompatActivity {

    private Button button;
    private Button button3;
    private LoginButton loginButton;
    private CircleImageView circleImageView;
    private TextView txtName,txtEmail;

    private CallbackManager callbackManager;

   private BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(), setting_navigation.class));
                        overridePendingTransition(0,0);
                        return true ;
                }

                switch (menuItem.getItemId()) {
                    case R.id.Facebookk:
                        startActivity(new Intent(getApplicationContext(),facebook_navigation.class));
                        overridePendingTransition(0,0);
                        return true ;
                }
                return false;
            }
        });



        setContentView(R.layout.activity_home);
        loginButton = findViewById(R.id.login_button);
        txtName = findViewById(R.id.profilename);
        txtEmail = findViewById(R.id.profile_email);

        circleImageView =findViewById(R.id.profile_pic);
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("email, public_profile"));
        checkLoginStatus();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        button3 = findViewById(R.id.login01);
        button = findViewById(R.id.new_game);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLevel();
            }
        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if(currentAccessToken==null){
                txtName.setText("");
                txtEmail.setText("");
                circleImageView.setImageResource(0);
                Toast.makeText(Home.this, "user Logged out", Toast.LENGTH_SHORT).show();
            }
            else
                loaduserProfile(currentAccessToken);

        }
    };

    private void loaduserProfile(AccessToken newAccessToken) {
        GraphRequest request =GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email =object.getString("email");
                    String id = object.getString("id");
                    String image_url ="https://graph.facebook.com/" +id+ "/picture?type=normal";

                    txtEmail.setText(email);
                    txtName.setText(first_name+ "" +last_name);
                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();

                    Glide.with(Home.this).load(image_url).into (circleImageView);
                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }
    private  void checkLoginStatus() {
        if(AccessToken.getCurrentAccessToken() !=null)
        {
            loaduserProfile(AccessToken.getCurrentAccessToken());
        }
    }


    private void openLevel() {
        Intent intent = new Intent(this, Level.class);
        startActivity(intent);
            }
}

