package com.example.tharinduwanninayake.flightcrew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TharinduWanninayake on 7/26/2017.
 */

public class RegUser_Activity extends AppCompatActivity {

    private EditText email;
    private EditText username;
    private EditText password;
    private Button create;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reguser_layout);

        email =(EditText) findViewById(R.id.emailCreate);
        username = (EditText) findViewById(R.id.uNameCreate);
        password = (EditText) findViewById(R.id.uPassCreate);
        create = (Button) findViewById(R.id.create);

        //search previous users to check there are any other users exists from that name
        //set up a request to connect to server and send the user info to db


    }
}
