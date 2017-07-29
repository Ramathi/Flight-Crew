package com.example.tharinduwanninayake.flightcrew;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by TharinduWanninayake on 7/26/2017.
 */

public class RegUser_Activity extends AppCompatActivity {

    private EditText userEmail;
    private EditText username;
    private EditText userPassword;
    private Button create;
    private String email;
    private String password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reguser_layout);

        progressDialog = new ProgressDialog(this );
        userEmail =(EditText) findViewById(R.id.emailCreate);
        //username = (EditText) findViewById(R.id.uNameCreate);
        userPassword = (EditText) findViewById(R.id.uPassCreate);
        create = (Button) findViewById(R.id.create);

        //search previous users to check there are any other users exists from that name
        //set up a request to connect to server and send the user info to db

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regUser();
            }
        });

    }

    private void regUser(){
        email = userEmail.getText().toString().trim();
        password = userPassword.getText().toString().trim();

        //user cannot register without giving data
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your email",Toast.LENGTH_SHORT).show();
            //stop the function from executing further
            return;
        }if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password",Toast.LENGTH_SHORT).show();
            //stop the function from executing further
            return;
        }

        //user have enter both email and password
        progressDialog.setMessage("Registering User");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //registration successful
                            Toast.makeText(RegUser_Activity.this, "registered ",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(RegUser_Activity.this, "registration failed ",Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }
}
