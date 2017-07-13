package a2014001.w1583045.com.flightcrew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class adminSignIn extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);
    }
    public void adminSignIn(View v){
        EditText Email = (EditText) findViewById(R.id.txtAdminEmail);
        EditText password = (EditText) findViewById(R.id.txtAdminPassword);

        String AdminEmail = Email.getText().toString();
        String AdminPassword = password.getText().toString();


        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Hold on, We are Signing you in");
        progressDialog.show();

        //login username and password authentication
        firebaseAuth.signInWithEmailAndPassword(AdminEmail, AdminPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(getApplicationContext(),adminMainScreen.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Error while signing in",Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });

    }
}

