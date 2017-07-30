package com.example.ramathi.flightcrew2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Tharindu Wanninayake on 7/29/2017.
 */

public class Login_Activity extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPwd;
    private FirebaseAuth firebaseAuth;
    private boolean isAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailLogin = (EditText) findViewById(R.id.userEmail);
        txtPwd = (EditText) findViewById(R.id.userPass);
        firebaseAuth = FirebaseAuth.getInstance();
    }


    public void btnUserLogin_Click(View v) {

        //session
        CurrentUser sessionEmail = new CurrentUser();
        sessionEmail.setCurrentUserEmail(txtEmailLogin.getText().toString());


        final ProgressDialog progressDialog = ProgressDialog.show(Login_Activity.this, "Please wait...", "Proccessing...", true);

        (firebaseAuth.signInWithEmailAndPassword(txtEmailLogin.getText().toString(), txtPwd.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(Login_Activity.this, "Login successful", Toast.LENGTH_LONG).show();

                            //boolian check

                            /*if(isAdmin=true){
                                Intent i = new Intent(Login_Activity.this, AdminHome_Activity.class);
                                i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                startActivity(i);
                            }else {
                                Intent i = new Intent(Login_Activity.this, UserHome_Activity.class);
                                i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                startActivity(i);
                            }*/

                            Intent i = new Intent(Login_Activity.this, home_Activity.class);
                            i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(Login_Activity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }
}

