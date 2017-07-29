package com.example.ramathi.flightcrew2;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by TharinduWanninayake on 7/26/2017.
 */

public class RegUser_Activity extends AppCompatActivity {

    private EditText email;
    private EditText username;
    private EditText password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.reguser_layout);

        email =(EditText) findViewById(R.id.emailCreate);
        username = (EditText) findViewById(R.id.uNameCreate);
        password = (EditText) findViewById(R.id.uPassCreate);

    }

    public void btnRegistrationUser_Click(View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(RegUser_Activity.this, "Please wait...", "Processing...", true);
        (firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(RegUser_Activity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegUser_Activity.this, Login_Activity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegUser_Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
