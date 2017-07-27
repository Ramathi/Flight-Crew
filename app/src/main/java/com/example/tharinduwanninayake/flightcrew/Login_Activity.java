package com.example.tharinduwanninayake.flightcrew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login_Activity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.uName);
        password = (EditText) findViewById(R.id.uPass);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.regUser);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call api and check users, give them privileges #admin/user
                try{

                    if(userName.getText().toString().equals("wanni") && password.getText().toString().equals("wanni")){
                        Intent ahome = new Intent(getApplicationContext(), AdminHome_Activity.class);
                        startActivity(ahome);

                    }else if(userName.getText().toString().equals("wanni2") && password.getText().toString().equals("wanni2")){
                        Intent uhome = new Intent(getApplicationContext(), UserHome_Activity.class);
                        startActivity(uhome);
                    }else{
                        Intent uhome2 = new Intent(getApplicationContext(), SplashScreen_Activity.class);
                        startActivity(uhome2);
                        //err
                    }

                }catch(Exception e){

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //direct to reg user page

                Intent regUser = new Intent(getApplicationContext(), RegUser_Activity.class);
                startActivity(regUser);


            }
        });

    }
}