package com.example.tharinduwanninayake.flightcrew;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    private EditText userEmail;
    private EditText userPassword;
    private Button login;
    private Button register;
    private String email;
    private String password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText) findViewById(R.id.uName);
        userPassword = (EditText) findViewById(R.id.uPass);

        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.regUser);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // checkUser();

                //call api and check users, give them privileges #admin/user


                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                try{

                    if(email.getText().toString().equals("wanni") && password.getText().toString().equals("wanni")){
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
    private void checkUser(){
        email = userEmail.getText().toString().trim();
        password = userPassword.getText().toString().trim();

        /*mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //registration successful
                                    Toast.makeText(Login_Activity.this, "registered ",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Login_Activity.this, "registration failed ",Toast.LENGTH_SHORT).show();

                                }
                            }
                        });*/
    }

}
