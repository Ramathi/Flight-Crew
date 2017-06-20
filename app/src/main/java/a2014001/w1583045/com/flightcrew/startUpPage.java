package a2014001.w1583045.com.flightcrew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class startUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

    }

    public void admin(View v){
        Intent adminSignIn = new Intent(this, a2014001.w1583045.com.flightcrew.adminSignIn.class);
        finish();
        startActivity(adminSignIn);
    }

    public void crewMembers (View v){
        Intent crew_sign_In = new Intent(this, a2014001.w1583045.com.flightcrew.crew_sign_In.class);
        finish();
        startActivity(crew_sign_In);
    }
}
