package com.example.ramathi.flightcrew2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Tharindu Wanninayake on 7/29/2017.
 */

public class home_Activity extends AppCompatActivity {
    Boolean isAdmin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.selectuser_layout);
    }

    public void btnAdminHome_Click(View v) {
        Intent i = new Intent(home_Activity.this, AdminHome_Activity.class);
        startActivity(i);
    }

    public void btnUserHome_Click(View v) {

        Intent i = new Intent(home_Activity.this, UserHome_Activity.class);
        startActivity(i);
    }
}
